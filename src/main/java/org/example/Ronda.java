package org.example;

import java.util.ArrayList;
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

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    //metodo
    public int puntos(List<Pronostico> pronosticosJugador){
        //System.out.println(pronosticosJugador);
        int aciertos = 0;
        //Itero sobre los pronosticos para sacar el puntaje individual de cada uno
        for(Pronostico pronosticoActual : pronosticosJugador){
            //System.out.println("Pronostico actual: " + pronosticoActual);
            //Itero sobre los partidos para ver si en algun partido hubo un acierto en el pronostico actual
            for (Partido partidoActual : this.partidos){
                if(pronosticoActual.getPartido() == partidoActual && pronosticoActual.getResultado() == partidoActual.resultado()){
                   // System.out.println(partidoActual.getEquipo1().getNombre());
                    aciertos++;
                }
            }
        }
        return aciertos;
    }
}
