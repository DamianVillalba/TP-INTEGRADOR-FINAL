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
    //metodos
    public int puntosRonda(int numeroRonda){
        // TODO NUEVA FUNCION PARA SACAR LOS PUNTOS DE LA RONDA INGRESADA. HACER QUE CORROBORE SI LOS PARTIDOS SON LA RONDA INGRESADA.
        // DEBERIA FUNCIONAR
        int aciertos = 0;
        //Itero sobre los pronosticos para sacar el puntaje individual de cada uno
        for(Pronostico pronosticoActual : this.pronosticosPersona){
            // consulto si el pronostico actual es de la ronda ingresada
            if (pronosticoActual.getPartido().getRondaPartido().equals(numeroRonda)){
                //Itero sobre los partidos para ver si en algun partido hubo un acierto en el pronostico actual
                // TODO AUTOMATIZAR // aciertosPartidos(pronosticoActual);
                for (Partido partidoActual : pronosticoActual.getPartido().getRondaPartido().getPartidos()){
                    if(pronosticoActual.getPartido() == partidoActual && pronosticoActual.getResultado() == partidoActual.resultado()){
                        aciertos++;
                    }
                }
            }
        }
        return aciertos;
    }

    public int puntosTotales(){
        int aciertos = 0;
        //Itero sobre los pronosticos para sacar el puntaje individual de cada uno
        for(Pronostico pronosticoActual : this.pronosticosPersona){
            //Itero sobre los partidos para ver si en algun partido hubo un acierto en el pronostico actual
            for (Partido partidoActual : pronosticoActual.getPartido().getRondaPartido().getPartidos()){
                if(pronosticoActual.getPartido() == partidoActual && pronosticoActual.getResultado() == partidoActual.resultado()){
                    aciertos++;
                }
            }
        }
        return aciertos;
    }
}
