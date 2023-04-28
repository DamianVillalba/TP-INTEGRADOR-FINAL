package org.example;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    //atributos
    String nombre;
    List<Pronostico> pronosticosPersona;

    //constructores
    public Persona(String nombre){
        this.nombre = nombre;
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

    public void agregarPronostico(Pronostico pronosticoNuevo){
        this.pronosticosPersona.add(pronosticoNuevo);
    }

    //metodos
    //aciertos ronda
    private int aciertosPartidos(Pronostico pronosticoPartido, int puntosExtras){
        int aciertos = 0;
        boolean flag = true; //bandera para corroborar si acerto todos los partidos
        //itero sobre los partidos para buscar los aciertos
        for(Partido partidoActual : pronosticoPartido.getPartido().getRondaPartido().getPartidos()){
            if(partidoActual.resultado() == pronosticoPartido.getResultado() && partidoActual == pronosticoPartido.getPartido()){
                aciertos++;
            }
            else{
                //si no acerto algun resultado, la bandera cambia a false
                flag = false;
            }
        }
        if (flag == true){
            //devuelve los aciertos + los puntos extras por acertar a todos los partidos
            return aciertos + puntosExtras;
        }
        else{
            //devuelve solo los aciertos que tuvo
            return aciertos;
        }
    }

    public int puntosRondaFase(int numeroFase, int numeroRonda, int puntosExtra){
        int aciertos = 0;
        //Itero sobre los pronosticos para buscar el pronostico correspondiente
        for(Pronostico pronosticoActual : this.pronosticosPersona){
            // consulto si el pronostico actual es de la ronda ingresada de la fase correspondiente
            if (pronosticoActual.getPartido().getRondaPartido().getNumeroRonda() == numeroRonda &&
                    pronosticoActual.getPartido().getRondaPartido().getNumeroFase() == numeroFase){
                //Itero sobre los partidos para ver si en algun partido hubo un acierto en el pronostico actual
                aciertos += aciertosPartidos(pronosticoActual, puntosExtra);
            }
        }
        return aciertos;
    }

    //aciertos fase

    private boolean acertoResultadosEquipo(Pronostico pronostico, int numeroRondas){
        boolean flag = true;
        // itero sobre las rondas de la fase para ver si en alguna le erro al resultado
        for (int rondaActual = 1; rondaActual <= numeroRondas; rondaActual++){
            //itero sobre los partidos de la ronda para ver si resultado
            for(Partido partidoActual : pronostico.getPartido().getRondaPartido().getPartidos()){
                // consulto si el pronostico es diferente al resultado, en caso de ser diferente cambia el valor de la bandera a falso
                if(partidoActual != pronostico.getPartido() || partidoActual.resultado() != pronostico.getPartido().resultado()){
                    flag = false;
                }
            }
        }
        return flag;
    }

    private int puntosExtraFase(int numeroFase, int rondas, int puntosExtra){
        int puntos = 0;
        //itero sobre los pronosticos para corroborar si acerto en todos.
        for (Pronostico pronosticoActual : this.pronosticosPersona){
            // corroboro si acerto todos los resultados de la rondas
            if(pronosticoActual.getPartido().getRondaPartido().getNumeroFase() == numeroFase && acertoResultadosEquipo(pronosticoActual, rondas)){
                puntos+= puntosExtra;
            }
        }
        return puntos;
    }

    public int puntosFase(int numeroFase, int rondas, int puntosExtraFase, int puntosExtraRonda){
        int puntos = 0;
        //Itero sobre las rondas de la fase para sacar los aciertos de cada una
        for(int nroRonda = 1; nroRonda <= rondas; nroRonda++){
            // sumo los aciertos posibles de la ronda actual de la fase ingresada.
            puntos+= puntosRondaFase(numeroFase, nroRonda, puntosExtraRonda);
        }
        // retorno los aciertos de la fase + los puntos extra si acerto el resultado del equipo correspondiente en la fase.
        return puntos + puntosExtraFase(numeroFase, rondas, puntosExtraFase);
    }

    //puntos totales
    public int puntosTotales(List<Fase> fases, int puntosExtraRonda, int puntosExtraFase){
        int puntos = 0;
        // itero los pronosticos para sacar los puntos de cada uno.
        for(Pronostico pronosticoActual : this.pronosticosPersona){
            // itero sobre las fases para complementar informacion teniendo en cuenta que tanto las fases como los pronosticos estan ordenados.
            for(int faseActual = 0; faseActual < fases.size(); faseActual++){
                    puntos += puntosFase(pronosticoActual.getPartido().getRondaPartido().getNumeroFase(), fases.get(faseActual).getRondas().size(), puntosExtraFase, puntosExtraRonda);
            }
        }
        return puntos;
    }
}

