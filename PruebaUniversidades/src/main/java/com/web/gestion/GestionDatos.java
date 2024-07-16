package com.web.gestion;

import com.web.modelo.Universidad;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

import java.util.List;

//@Singleton
//@Startup
public class GestionDatos{

    /*
    @Inject
    GestionProducto gestionProducto;

    @PostConstruct
    public void init(){
        Universidad producto = new Universidad();
        producto.setDescripcion("1KG Carne ahumada");
        producto.setPrecio(10.25);
        producto.setIVA('S');
        gestionProducto.guardarProducto(producto);

        List<Universidad> productos = gestionProducto.getProductos();
        for(Universidad p : productos){
            System.out.println(p);
        }
    }
    */
}
