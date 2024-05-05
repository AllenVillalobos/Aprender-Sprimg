package com.aprender.ApenderSpring.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice//Anotacion que hace que la clase se convierta en la encargada de manejar las exepciones
@Slf4j
public class RutasHandler {
    @ExceptionHandler(NullPointerException.class)//Detecta las NullPointerException Y las trae a esta funcion
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//El estado que se devuelve cuando se ejequta una NullPointerException
    public String handlerExecp(NullPointerException excp){
        log.debug(excp.getMessage());//Obtiene el mensaje de la NullPointerException del Controller principal
        return "Error en el server";

    }
}
