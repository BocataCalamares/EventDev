package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.datos.RepositorioGenerico;
import com.azahartech.eventdev.modelo.Evento;
import com.azahartech.eventdev.modelo.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ServicioUsuario {
    // private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private RepositorioGenerico<Usuario> repositorio = new RepositorioGenerico<>();
    private HashMap<String, Usuario> mapaUsuarios = new HashMap<>();
    public void registrarUsuario(Usuario usuario) {
        //listaUsuarios.add(usuario);
        repositorio.guardar(usuario);
        if(mapaUsuarios.containsKey(usuario.consultarEmail()))
        {
            System.out.println("Error: email repetido");
        }else {
            mapaUsuarios.put(usuario.consultarEmail(), usuario);
        }
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        /*boolean banderita = false;
        Usuario usuarioTemporal = null;
        for (Usuario listaUsuario : repositorio.listar()) {
            if (listaUsuario.consultarEmail().equals(email)) {
                banderita = true;
                usuarioTemporal = listaUsuario;
            }
        }
        if (banderita) {
            return usuarioTemporal;
        } else {
            return null;
        } */
    return mapaUsuarios.get(email);
    }
     public void mostrarUsuarios(){
         for (Usuario usuario : repositorio.listar() ) {
            System.out.println(usuario.consultarNombre());
        }
    }
     public void imprimirVips(){
        ArrayList<String> usuarioVip;
        usuarioVip = repositorio.listar().stream().filter(usuario -> usuario.getEsVip()).map(m -> m.consultarNombre()).collect(Collectors.toCollection(ArrayList::new));
        usuarioVip.stream().forEach(e-> System.out.println(e));
    }

    public void buscarPorNombre(String nombreUsuario){
       Usuario usuarioEncontrado;
       usuarioEncontrado = mapaUsuarios.values().stream().filter(e->e.consultarNombre().equals(nombreUsuario)).findFirst().orElse(null);
        if (usuarioEncontrado == null){
            System.out.println("Usuario no encontrado");
        }else{
           usuarioEncontrado.mostrarInforamcion();
        }
    }


}



