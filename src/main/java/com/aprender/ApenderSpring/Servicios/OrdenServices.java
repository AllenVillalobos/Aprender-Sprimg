package com.aprender.ApenderSpring.Servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aprender.ApenderSpring.Clases.Productos;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service //Establce la clase como un servicio la cual no hace falta crear una instancia de la misma solo inicializarla
//Es parecido a un component y a un bean se usa para establcer las capaz en la que estamos
public class OrdenServices {
    //Se hace la llamada a la base de datos
    public void guadarOrden(List<Productos> lista){
        System.out.println("Guardado en la base de datos");
        for(Productos p:lista){
            log.debug("Nombre{}",p.getNombre());
        }
    }
}
