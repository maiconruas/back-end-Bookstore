package com.api.springboot.dtos;

import com.api.springboot.domain.Livro;

import java.io.Serializable;

public class LivroDTO implements Serializable {

    private static  final long serialVersionUID = 1l;

    private Integer id;
    private String titulo;

    public LivroDTO() {
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
