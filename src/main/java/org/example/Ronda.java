package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Ronda {
    //propiedades
    private String numeroRonda;
    private List<Partido> partidos;

    //constructores
    public Ronda(){
        this.partidos =new ArrayList<>();
    }
    public Ronda(String numeroRonda, List<Partido> partidos){
        this.numeroRonda = numeroRonda;
        this.partidos = partidos;
    }

    //get y set
    public String getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(String numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public List<Partido> getPartidos(){
        //encapsulamos
        List<Partido> listaPartidos = new ArrayList<>();
        listaPartidos.addAll(this.partidos);
        return listaPartidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    //metodo
    public List<Persona> puntos(List<Persona> personasJugando){
        //NO HACE FALTA ORDENAR LOS PUNTAJES
    }
}
