package com.web.gestion;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import com.web.modelo.Universidad;

import com.web.dao.DAOUniversidad;

@Stateless
public class GestionUniversidad{

    @Inject
    private DAOUniversidad universidadDao;


    public void guardar(Universidad universidad){
        Universidad prod = universidadDao.read(universidad.getCodigo());
        if(prod == null)
            universidadDao.create(universidad);
        else
            universidadDao.update(universidad);
    }

    public void actualizar(Universidad universidad) throws Exception{
        Universidad prod = universidadDao.read(universidad.getCodigo());
        if(prod != null)
            universidadDao.update(universidad);
        else
            throw new Exception("Universidad no existe");
    }

    public void borrar(int id){
        universidadDao.delete(id);
    }

    public Universidad buscar(int id){
        return universidadDao.read(id);
    }

    public List<Universidad> listar(){
        return universidadDao.getAll();
    }

}
