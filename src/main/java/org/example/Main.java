package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        // args[0] tiene que ser el archivo del pronostico y args[1] tiene que ser el archivo con la configuracion. Sino hay error.
        // TODAS LAS INSTANCIAS ESTAN CARGADAS DE FORMA ORDENADA, de lo contrario puede haber errores.
        //armado de instancias
        List<Persona> personas = new ArrayList<>(); //LISTA DE PERSONAS QUE SE VA A USAR PARA VER LOS PUNTOS
        List<Fase> fases = new ArrayList<>(); // lista con las fases
        int puntosRonda = 0; //poner valor tomado de la configuracion
        int puntosFase = 0; //poner valor tomado de la configuracion
        mostrarPuntosTotales(personas, fases, puntosRonda, puntosFase);
    }

    private static void mostrarPuntosTotales(List<Persona> personasJugando, List<Fase> fases, int puntosExtraRonda, int puntosExtraFase){
        // itero cada persona para mostrar su puntaje
        for(Persona personaActual : personasJugando){
            // muestro el resultado de esa persona utilizando la funcion de puntos totales
            System.out.println(personaActual.nombre + ": " + personaActual.puntosTotales(fases, puntosExtraFase, puntosExtraRonda));
        }
    }

    /* FUNCIONES PARA ARMADO DE INSTANCIAS, INCOMPLETO.
    private static List<String> infoPartido(String archivo, int partido) throws IOException {
        //sacamos una lista con la informacion del partido (al ser univocos no importa cual de los dos archivos procesar para sacar los equipos)
        //el parametro partido indica el numero de partido correspondiente (linea), debe existir ese partido sino da error.
        List<String> informacion = null;
        int partidoActual = 1;
        for (String linea : Files.readAllLines(Paths.get(archivo))){
            if(partido != partidoActual){
                partidoActual++;
                continue;
            }
            informacion = new ArrayList<>(List.of(linea.split(";")));
            break;
        }
        return informacion;
    }

    private static ResultadoEnum resultadoPronostico(List<String> datosPronostico){
        //retornamos el resultado segun el pronostico
        if (datosPronostico.get(1).equals("X")){
            return ResultadoEnum.GANA_EQUIPO1;
        } else if (datosPronostico.get(3).equals("X")) {
            return ResultadoEnum.GANA_EQUIPO2;
        }
        else {
            return ResultadoEnum.EMPATE;
        }
    }

    private static int cantidadPartidosRonda(String archivoResultados, int numeroRonda) throws IOException{
        //TODO TERMINAR: tiene que sacar los partidos de la ronda que reciba por parametro. ejemplo la 1.
        int partidos = 0;
        if (numeroRonda == )
        for(String linea : Files.readAllLines(Paths.get(archivoResultados))){
            partidos++;
        }
        return partidos;
    }
    private static List<Partido> listaDePartidosRonda(String archivoResultado, int numeroRonda) throws IOException{
        // creo instancias necesarias y defino cada partido para retornarlo en una lista.
        List<Partido> partidos = new ArrayList<>();
        // TODO REVISAR, TIENE QUE ENCONTRAR PRIMERO LA RONDA A LA QUE SE REFIERE EN numeroRonda Y DESPUES CREAR LAS INSTANCIAS
        for(int indice = 1; indice <= cantidadPartidosRonda(archivoResultado, numeroRonda); indice++){
            Equipo equipo1 = new Equipo();
            Equipo equipo2 = new Equipo();
            Partido partido = new Partido();
            List<String> datosPartido = infoPartido(archivoResultado, indice);
            equipo1.setNombre(datosPartido.get(0));
            equipo2.setNombre(datosPartido.get(3));
            int golesEquipo1 = Integer.parseInt(datosPartido.get(1));
            int golesEquipo2 = Integer.parseInt(datosPartido.get(2));
            partido.setEquipo1(equipo1);
            partido.setEquipo2(equipo2);
            partido.setGolesEquipo1(golesEquipo1);
            partido.setGolesEquipo2(golesEquipo2);
            partidos.add(partido);
        }
        return partidos;
    }
    private static void asignarPronosticos(String archivoPronostico, List<Pronostico> listaPronosticos, List<Partido> listaPartidos, int numeroRonda) throws IOException{
        //TODO REVISAR, HAY QUE ASIGNAR LOS PRONOSTICOS. COMO HACERLO? POR RONDA O CARGAMOS TODOS Y DESPUES LOS IDENTIFICAMOS?
        for(int indice = 1; indice <= cantidadPartidosRonda(archivoPronostico, numeroRonda); indice++){
            Pronostico pronostico = new Pronostico();
            pronostico.setPartido(listaPartidos.get(indice - 1));
            pronostico.setResultado(resultadoPronostico(infoPartido(archivoPronostico, indice)));
            //agregar a las personas
            listaPronosticos.add(pronostico);
        }
    }
     */
}