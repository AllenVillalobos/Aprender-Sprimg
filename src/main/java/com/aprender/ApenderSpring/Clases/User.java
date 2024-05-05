package com.aprender.ApenderSpring.Clases;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
    private int id;
    @JsonProperty("Nombre_Completo")
    private String name;
    @JsonIgnore
    private int age;

    
    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    
    @Override
    //@JsonValue Devuele SOLO el return del metodo saltandose el return del controller
    @JsonGetter("Informacion") //Agrega un nuevo parametro a la respuesta/Se debe ponerle un nombre dentro de los ()/
    public String toString() {
        return "id=" + id + ", name=" + name + ", age=" + age;
    }
    
    
}
