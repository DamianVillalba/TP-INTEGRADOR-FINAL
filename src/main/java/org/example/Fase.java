package org.example;

import java.util.ArrayList;
import java.util.List;

public class Fase {
    //atributos
    private int numeroFase;
    private List<Ronda> rondas;

    //constructor
    public Fase(){
        this.rondas = new ArrayList<>();
    }

    public Fase(int numeroFase, List<Ronda> rondas){
        this.numeroFase = numeroFase;
        this.rondas = rondas;
    }

    //get y set
    public int getNumeroFase() {
        return numeroFase;
    }

    public void setNumeroFase(int numeroFase) {
        this.numeroFase = numeroFase;
    }

    public List<Ronda> getRondas() {
        //encapsulamos
        List<Ronda> listaRondas = new ArrayList<>();
        listaRondas.addAll(this.rondas);
        return listaRondas;
    }

    public void setRondas(List<Ronda> rondas) {
        rondas = rondas;
    }

    //metodos
    /*
    public void puntos(List<Persona> personas, int puntosExtraRonda, int puntosExtraFase){
        for(Persona personaActual : personas){
            System.out.println(personaActual.nombre + ": " + personaActual.puntosFase(this.numeroFase, this.rondas.size(), puntosExtraFase, puntosExtraRonda));
        }
    }

     */
}
