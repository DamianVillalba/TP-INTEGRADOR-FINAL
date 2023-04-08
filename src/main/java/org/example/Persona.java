package org.example;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    //atributos
    String nombre;

    List<Pronostico> pronosticosPersona;

    //constructores
    public Persona(){
        this.pronosticosPersona = new ArrayList<>();
    }
    public Persona(String nombre, List<Pronostico> listaPronosticos){
        this.nombre = nombre;
        this.pronosticosPersona = listaPronosticos;
    }

    //get y set
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Pronostico> getPronosticosPersona(){
        //encapsulamos
        List<Pronostico> listaPronostico = new ArrayList<>();
        listaPronostico.addAll(this.pronosticosPersona);
        return listaPronostico;
    }

    public void setPronosticosPersona(List<Pronostico> pronosticosPersona) {
        this.pronosticosPersona = pronosticosPersona;
    }
}
