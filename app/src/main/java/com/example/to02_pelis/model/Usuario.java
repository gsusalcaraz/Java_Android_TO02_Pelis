package com.example.to02_pelis.model;

import java.util.Objects;

public class Usuario {
    private String user, pass, email, plataforma, telefono;

    public Usuario(String user, String pass, String email, String plataforma, String telefono) {
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.plataforma = plataforma;
        this.telefono = telefono;
    }

   public Usuario(Usuario usuario) {
        this.user = getUser();
        this.pass = getPass();
        this.email = getEmail();
        this.plataforma = getPlataforma();
        this.telefono = getTelefono();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return user.equals(usuario.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
