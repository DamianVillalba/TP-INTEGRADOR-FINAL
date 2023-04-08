package org.example;
public class Equipo {
    //propiedades
    private String nombre;

    //constructores
    public Equipo(){

    }
    public Equipo(String nombre){
        this.nombre = nombre;
    }

    //get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
