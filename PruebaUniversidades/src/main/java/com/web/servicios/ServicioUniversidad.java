package com.web.servicios;

import com.web.gestion.*;
import com.web.modelo.Universidad;

import java.util.List;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("universidades")//ruta para acceder a la clase
public class ServicioUniversidad {


    @Inject//injectamos la clase para no necesitar inicializarla
    private GestionUniversidad gUniversidad;

    @POST//especificamos que el servicio es de tipo POST
    @Produces(MediaType.APPLICATION_JSON)//especificamos que produce un JSON como resultado
    @Consumes(MediaType.APPLICATION_JSON)//especificamos que consume un objeto JSON
    @Path("crear")
    //metodo para guardar el objeto
    public Response crear(Universidad universidad){
    	System.out.println(universidad);//imprimimos el objeto que recibimos
        try{
            gUniversidad.guardar(universidad);//mandamos a guardar el objeto
            ErrorMessage error = new ErrorMessage(1, "OK");//creamos el objeto de respuesta
            //creamos la respuesta, le asignamos el estado y el objeto JSON de respuesta
            return Response.status(Response.Status.CREATED)
                .entity(error)
                .build();
        }catch (Exception e) {
            //capturamos el error y devolvemos el mensaje
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
        }
    }

    @PUT//especificamos que el servicio es de tipo PUT
    @Produces(MediaType.APPLICATION_JSON)//especificamos que produce un JSON como resultado
    @Consumes(MediaType.APPLICATION_JSON)//especificamos que consume un objeto JSON
    @Path("actualizar")
    //metodo para actualizar el objeto
    public Response actualizar(Universidad universidad){
        try{
            gUniversidad.actualizar(universidad);//mandamos a actualizar el objeto
            return Response.ok(universidad).build();//retornamos un OK y con el objeto del carro encontrado
        }catch (Exception e) {
            //capturamos el error y devolvemos el mensaje
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
        }
    }

    @DELETE//especificamos que el servicio es de tipo DELETE
    @Produces(MediaType.APPLICATION_JSON)//especificamos que produce un JSON como resultado
    @Path("borrar")
    //metodo para eliminar el objeto
    public String borrar(@QueryParam("codigo") int codigo){
        try{
            gUniversidad.borrar(codigo);//mandamos a eliminar el objeto
            return "OK";//respondemos con un OK
        }catch (Exception e) {
            return "Error";//respondemos con un Error
        }
    }

    @GET//especificamos que el servicio es de tipo GET
    @Produces(MediaType.APPLICATION_JSON)//especificamos que produce un JSON como resultado
    @Path("list")//ruta para acceder al servicio
    public Response getUniversidades(){
    	System.out.println("Listando Universidades");
    	List<Universidad> universidades = gUniversidad.listar();//obtenemos todos los objetos guardados
    	if(universidades.size() > 0)//verificamos que existan objetos
            return Response.ok(universidades).build();//retornamos un OK y con la lista de universidades
    	ErrorMessage error = new ErrorMessage(6, "No se registran universidades");//creamos el objeto de respuesta
    	return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(error)
            .build();
    }

    @GET//especificamos que el servicio es de tipo GET
    @Produces(MediaType.APPLICATION_JSON)//especificamos que produce un JSON como resultado
    @Path("leer")
    public Response leer(@QueryParam("codigo") int codigo){
        try{
            System.out.println("Codigo universidad: " + codigo);
            Universidad universidad = gUniversidad.buscar(codigo);//obtenemos la universidad
            return Response.ok(universidad).build();//retornamos un OK y con el objeto del carro encontrado
        }catch (Exception e) {
            ErrorMessage error = new ErrorMessage(4, "Universidad no existe");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
        }
    }
}
