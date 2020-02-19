package com.once.facturas.controller;

import javax.websocket.server.PathParam;

import com.once.facturas.model.Producto;
import com.once.facturas.model.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * MainController es el controlador de la aplicación Facturas,
 * que es una aplicación tipo MVC (Modelo Vista Controlador)
 * 
 * 
 */

@RestController
@RequestMapping(value = "/productos")
class ProductoControler{
    
    @Autowired
    ProductoRepository pr; // Interface for generic CRUD operations 
                            // on a repository for a specific type.
    @GetMapping("/")
    public Iterable<Producto> getAllProductos(){
        return pr.findAll();
    }

    @GetMapping("/{id}/")
    public Producto getProducto(
        @PathParam("id") final long Id
    ){
        return null;
        
    }

    @GetMapping("/almacen") // Escucho al GET en /count
    @ResponseBody // Haré un body html para devolver la página completa
    public String count() { // Método para devolver un string con responsebody
        return "Tengo "+String.valueOf(pr.count())+" productos"; // Devuelvo el número de productos desde pr.count()
    }
}
