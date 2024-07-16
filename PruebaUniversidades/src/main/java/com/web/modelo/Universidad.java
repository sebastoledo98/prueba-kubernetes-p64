package com.web.modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Universidad implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
	private int codigo;
    private String nombre;
    private String ciudad;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setDescripcion(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad;
	}
}
