package com.aprender.ApenderSpring.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aprender.ApenderSpring.Beans.MetodosDelBean;
import com.aprender.ApenderSpring.Clases.Productos;
import com.aprender.ApenderSpring.Clases.User;
import com.aprender.ApenderSpring.Clases.model;
import com.aprender.ApenderSpring.Companentes.Componente;
import com.aprender.ApenderSpring.Servicios.OrdenServices;

import lombok.extern.slf4j.Slf4j;


@RestController//Establece esta clase como un controllador
@Slf4j//Anotacion para los LOG
@RequestMapping("/ejemplo")//Establce una ruta especifica para este controlador/Lo mapea 
public class HttpMetodos {

    private OrdenServices service; //Se inicializa el service/
    private MetodosDelBean Bean;
    private Componente componente;

    //Para hacer uso del service se debe crear un costructor con el serivice para usarlo en un endpoit  /
    public HttpMetodos(OrdenServices service, MetodosDelBean Bean,Componente componente){
        this.service = service;
        this.Bean = Bean;
        this.componente=componente;
    }

    @GetMapping("/get")//Anotacion para solucitudes GET
    public String MetodoGet(){
        return "Hola get";
    }

    @GetMapping("/get/{nombre}/{edad}")
    public String MetodoGet(@PathVariable /*Se usa para extraer informacion desde la URl */ String nombre, @PathVariable int edad){
        return "Hola"+nombre+" "+" tu edad es: "+edad ;
    }

    @GetMapping("/libro/{id}")
    public String MetodoGetQuerry(@PathVariable int id,@RequestParam/*Se usa para extraer informacion de los querry params  */
                                                                    /*NO SE TIENEN QUE PONER EN LA URL*/ String nombre){
        return "Estoy lechendo el libro: "+id+" diferentes parametro de los query:"+nombre;
    }
    @PostMapping("/guardar")//Anotacion que maneja las solicitudes POST
    public String Guadar(@RequestBody/*Parametros Para el body */ HashMap<String,Integer> libro){
        for(String ket:libro.keySet()){
            log.debug("Llve{}, Valor{}",ket, libro.get(ket));
        }
        return "Guardado";
    }

    @PostMapping("/guardar2")
    public ResponseEntity/*Clase de Spring para manejo de Estado de la respuesta de la solicitud*/
    <String> guardar(@RequestBody model libro) {
        log.debug("Nombre: {}, Editorial: {}", libro.getNombre(), libro.getEditorial());
        
        if (libro.getNombre() == null || libro.getEditorial() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nombre y editorial no pueden ser nulos");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body("Guardado");
        }
        
    }

     @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).body( "Ya hay una nueva ruta");
    }

    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> lugar(@PathVariable String lugar){
        if(lugar.toLowerCase().equals("granja".toLowerCase())){
            return ResponseEntity.status(HttpStatus.OK).body("Estamos con los animales de granja");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe el lugar");
        }
    }

    @GetMapping("/cal/{num}")
    public int lugar(@PathVariable int num){
        if(num>100){
            throw new NullPointerException("El numero es mayor a 100");
            //Se usa para el manejo de estado de las respuesta de la solicitud
            //En la clase llamada RutasHandler
        }else{
            return num;
        }
    }

    @GetMapping("/UserData")
    public ResponseEntity<String> Userdata(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
        .header("Content-Type", "application/json"/*Establece como va a ser el cuerpo de la respuesta 
                                                                               En este caso un JSON*/)
        .body("{\"name\":\"Allen\"}");
    }

    @GetMapping("/UserData2")
    public Map<String,Map<String,String>> getUserdate2(){
        return Map.of("user",Map.of("name","Allen","age","18"));
    }

    @GetMapping("/UserData3")
    public User getUserdate3(@RequestParam int id,@RequestParam String nombre, @RequestParam int edad){
        User user=new User(id,nombre,edad);
        return user;
    }

    @PostMapping("/orden")
    public String orden(@RequestBody List<Productos> lista){
        service.guadarOrden(lista);
        return "Productos Guardados";

    }
    @GetMapping("/beans")
    public String MotodoBeans(){
        return Bean.SaludarMDB();
    }

    @GetMapping("/comp")
    public String MotodoComponente(){
        return componente.SaludarCompnente();
    }
}
