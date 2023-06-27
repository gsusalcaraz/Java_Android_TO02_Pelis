package com.example.to02_pelis.model;

import androidx.annotation.NonNull;

public class Plataformas {
    private int code;
    private String name;

    public Plataformas(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(String lcode) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
