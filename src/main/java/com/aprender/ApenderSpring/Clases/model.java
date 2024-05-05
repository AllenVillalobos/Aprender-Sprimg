package com.aprender.ApenderSpring.Clases;

public class model {
    private String nombre;
    private String editorial;
    
    public model(String nombre, String editorial) {
        this.nombre = nombre;
        this.editorial = editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    
}
