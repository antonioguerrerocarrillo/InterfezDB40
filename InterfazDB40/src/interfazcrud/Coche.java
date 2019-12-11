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
public class Coche  implements Serializable{
    String nombre, modelo;
    int identificador, ano;

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    Coche(String nombre, int n_modelo) {
      this.nombre = nombre;
      this.identificador = n_modelo;
    }

    public Coche() {
        
    }

    public Coche(String nombre, String modelo, int identificador) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.identificador = identificador;
    }
     public Coche(String nombre, String modelo, int identificador, int año) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.identificador = identificador;
        this.ano = año;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    
}
