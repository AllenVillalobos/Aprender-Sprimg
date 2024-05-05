package com.aprender.ApenderSpring.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//Lo configuramos para que cree solo una instancia de los beans que vamos a crear
//se usa para establcer las capaz en la que estamos es parecido a service y a component
public class ContenedorBean {
    @Bean//Establecemos el metodo como un Bean
    public MetodosDelBean Bean(){//Se tiene que hacer una funcion de la clase a la cual le vamos a hacer un bean//
        return new MetodosDelBean();//Se tiene que devolver un objeto del la clase que vamos a hacer un bean 
    }
}
