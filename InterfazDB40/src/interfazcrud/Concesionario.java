/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazcrud;

import java.io.Serializable;

/**
 *
 * @author cuvil
 */
public class Concesionario  implements Serializable{
    String direccion, nombre;
    int telefono, id;

    public Concesionario(String direccion, String nombre, int telefono, int id) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.id = id;
    }

    public Concesionario() {
       this.direccion = "";
        this.nombre = "";
        this.telefono = 0;
        this.id = 0; 
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
