package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Ronda {
    //propiedades
    private int numeroFase;
    private int numeroRonda;
    private List<Partido> partidos;

    //constructores
    public Ronda(){
        this.partidos =new ArrayList<>();
    }
    public Ronda(int numeroFase, int numeroRonda, List<Partido> partidos){
        this.numeroFase = numeroFase;
        this.numeroRonda = numeroRonda;
        this.partidos = partidos;
    }

    //get y set
    public int getNumeroFase() {
        return numeroFase;
    }

    public void setNumeroFase(int numeroFase) {
        this.numeroFase = numeroFase;
    }
    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(int numeroRonda) {
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
    /*
    public void puntos(List<Persona> personasJugando, int puntosExtraRonda){
        for(Persona personaActual : personasJugando){
            System.out.println(personaActual.nombre + ": " + personaActual.puntosRondaFase(this.numeroFase, this.numeroRonda, puntosExtraRonda));
        }
    }

     */
}
