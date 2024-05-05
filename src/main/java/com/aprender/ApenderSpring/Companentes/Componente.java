package com.aprender.ApenderSpring.Companentes;

import org.springframework.stereotype.Component;

@Component//Establece la clase como un componente es parecido a un bean y a un service se usa para establcer las capaz en la que estamos
public class Componente {
    
    public String SaludarCompnente(){
        return "Saludando desde un Componente";
    }
}
