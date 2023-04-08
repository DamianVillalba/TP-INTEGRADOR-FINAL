package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        // args[0] tiene que ser el archivo del pronostico y args[1] tiene que ser el archivo del resultado. Sino hay error.
        //armado de instancias
        List<Pronostico> pronosticos = new ArrayList<>();
        List<Partido> partidos = new ArrayList<>();
        armadoDeInstancias(args[0], args[1], pronosticos, partidos);
        //creo la ronda con los datos ya incorporados
        Ronda ronda1 = new Ronda("1", partidos);
        //resultado con los pronosticos de cada partido evaluado
        System.out.println("Puntaje del pronostico: " + ronda1.puntos(pronosticos));
    }

    private static List<String> infoArchivo(String archivo, int partido) throws IOException {
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

    private static int cantidadPartidos(String archivo) throws IOException{
        int partidos = 0;
        for(String linea : Files.readAllLines(Paths.get(archivo))){
            partidos++;
        }
        return partidos;
    }
    private static void armadoDeInstancias(String archivoPronostico, String archivoResultado, List<Pronostico> listaPronosticos, List<Partido> listaPartidos) throws IOException{
        // creo instancias de pronostico y defino los partidos para cada uno, agregandolos a la lista correspondiente.
        for(int indice = 1; indice <= cantidadPartidos(archivoPronostico); indice++){
            Equipo equipo1 = new Equipo();
            Equipo equipo2 = new Equipo();
            Partido partido = new Partido();
            Pronostico pronostico = new Pronostico();
            List<String> datosPartido = infoArchivo(archivoResultado, indice);
            equipo1.setNombre(datosPartido.get(0));
            equipo2.setNombre(datosPartido.get(3));
            int golesEquipo1 = Integer.parseInt(datosPartido.get(1));
            int golesEquipo2 = Integer.parseInt(datosPartido.get(2));
            partido.setEquipo1(equipo1);
            partido.setEquipo2(equipo2);
            partido.setGolesEquipo1(golesEquipo1);
            partido.setGolesEquipo2(golesEquipo2);
            pronostico.setPartido(partido);
            pronostico.setResultado(resultadoPronostico(infoArchivo(archivoPronostico, indice)));
            listaPronosticos.add(pronostico);
            listaPartidos.add(partido);
        }
    }
}