package com.example.to02_pelis.model;

import java.util.ArrayList;

public class Modelo {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void insertar(Usuario usuario) {
        if (!usuarios.contains(usuario)) {
            usuarios.add(new Usuario(usuario));
        }
    }

    public static boolean buscar(Usuario usuario) {
        boolean existe = true;
        int indice = usuarios.indexOf(usuario);
        if (indice == -1) {
            existe = false;
            return existe;
        } else {
            return existe;
        }
    }
}
