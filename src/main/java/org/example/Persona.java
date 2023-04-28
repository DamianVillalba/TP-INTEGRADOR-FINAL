package org.example;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    //atributos
    String nombre;
    List<Pronostico> pronosticosPersona;
    List<Partido> partidosAcertados;

    //constructores
    public Persona(String nombre){
        this.nombre = nombre;
        this.pronosticosPersona = new ArrayList<>();
        this.partidosAcertados = new ArrayList<>();
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
    private void agregarPartidoSiNoEsta(Partido partido){
        //consulta si no esta el partido, si es asi lo agrega.
        if(!partidosAcertados.contains(partido)){
            this.partidosAcertados.add(partido);
        }
    }

    private int aciertosPartidos(Pronostico pronostico, Ronda rondaPartido){
        int aciertos = 0;
        //itero sobre los partidos de la ronda para buscar los aciertos
        for (int partidoActualRonda = 0; partidoActualRonda < rondaPartido.getPartidos().size(); partidoActualRonda++){
            //consulto si el partido del pronostico es un partido de la ronda y si el resultado es el mismo.
            //si es asi, suma un punto y agrega ese partido a la lista de partidos acertados si no esta.
            if(rondaPartido.getPartidos().contains(pronostico.getPartido()) &&
                    rondaPartido.getPartidos().get(partidoActualRonda).resultado() == pronostico.getResultado()){
                aciertos++;
                agregarPartidoSiNoEsta(pronostico.getPartido());
            }
        }
        return aciertos;
    }

    private int agregarPuntosRondaAcertada(Ronda ronda, int puntosExtra){
        int puntos = 0;
        //consulta si en los partidos acertados estan todos los partidos de la ronda ingresada
        if (this.partidosAcertados.containsAll(ronda.getPartidos())){
                puntos+=puntosExtra;
        }
        return puntos;
    }

    public int puntosRondaFase(Ronda ronda, int puntosExtra){
        int aciertos = 0;
        //Itero sobre los pronosticos para calcular los aciertos
        for(Pronostico pronosticoActual : this.pronosticosPersona){
                aciertos += aciertosPartidos(pronosticoActual, ronda);
        }
        return aciertos + agregarPuntosRondaAcertada(ronda, puntosExtra);
    }

    //ACIERTOS FASE
    private boolean acertoResultadosFase(Fase fase){
        boolean flag = true;
        // itero sobre las rondas de la fase para ver si en alguna le erro al resultado
        for(int nroRonda = 0; nroRonda < fase.getRondas().size(); nroRonda++){
            // consulto si en los partidos que acerto estan los partidos de cada ronda.
            // En caso de no tener algun partido de alguna ronda, cambia el valor de la bandera a falso y termina el ciclo
            if(!this.partidosAcertados.containsAll(fase.getRondas().get(nroRonda).getPartidos())){
                flag = false;
                break;
            }
        }
        return flag;
    }

    private int puntosExtraFase(Fase fase, int puntosExtra){
        int puntos = 0;
        //Consulto si acerto todos los resultados de la fase, en caso de ser asi se agregan los puntos extra
        if(acertoResultadosFase(fase)){
            puntos+=puntosExtra;
        }
        return puntos;
    }

    public int puntosFase(Fase fase, int puntosExtraFase, int puntosExtraRonda){
        int puntos = 0;
        //Itero sobre las rondas de la fase para sacar los aciertos de cada una
        for(int nroRonda = 0; nroRonda < fase.getRondas().size(); nroRonda++){
            // sumo los aciertos posibles de la ronda actual de la fase ingresada.
            puntos+= puntosRondaFase(fase.getRondas().get(nroRonda), puntosExtraRonda);
        }
        // retorno los aciertos de la fase + los puntos extra si acerto el resultado del equipo correspondiente en la fase.
        System.out.println("puntos finales de fase: " + fase.getNumeroFase() + " es: " + (puntos + puntosExtraFase(fase, puntosExtraFase)));
        return puntos + puntosExtraFase(fase, puntosExtraFase);

    }

    //puntos totales
    public int puntosTotales(List<Fase> fases, int puntosExtraFase, int puntosExtraRonda){
        int puntos = 0;
        // itero las fases para sacar el puntaje de cada una.
        for(Fase faseActual : fases){
            puntos += puntosFase(faseActual, puntosExtraFase, puntosExtraRonda);
        }
        System.out.println("final: " + puntos);
        return puntos;
    }
}

