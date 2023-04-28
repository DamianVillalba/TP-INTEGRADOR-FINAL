package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    void puntosRondaFase() {

        // Equipos:
        Equipo equipo1 = new Equipo("A");
        Equipo equipo2 = new Equipo("B");

        // Ronda 1, partidos y pronósticos:
        Partido partido1 = new Partido(equipo1, equipo2, 2, 1);
        Partido partido2 = new Partido(equipo1, equipo2, 1, 2);
        List<Partido> partidos = new ArrayList<>();
        partidos.add(partido1);
        partidos.add(partido2);
        Ronda ronda1 = new Ronda(1, 1, partidos);
        partidos.get(0).setRondaPartido(ronda1);
        partidos.get(1).setRondaPartido(ronda1);
        Pronostico pronosticoLucas1 = new Pronostico(partido1, ResultadoEnum.GANA_EQUIPO1);
        Pronostico pronosticoFede1 = new Pronostico(partido1, ResultadoEnum.EMPATE);


        // Ronda 2, partidos y pronósticos:

        List<Partido> partidos2 = new ArrayList<>();
        partidos2.add(partido1);
        partidos2.add(partido2);
        Ronda ronda2 = new Ronda(1, 1, partidos2);
        partidos2.get(0).setRondaPartido(ronda2);
        partidos2.get(1).setRondaPartido(ronda2);


        Pronostico pronosticoLucas2 = new Pronostico(partido2, ResultadoEnum.GANA_EQUIPO2);
        Pronostico pronosticoFede2 = new Pronostico(partido2, ResultadoEnum.GANA_EQUIPO2);


        // Fase 1, rondas:
        List<Ronda> rondas = new ArrayList<>();
        rondas.add(ronda1);
        Fase fase1 = new Fase(1, rondas);

        // Personas con su respectivo pronóstico:
        Persona persona1 = new Persona("Lucas");
        persona1.agregarPronostico(pronosticoLucas1);
        persona1.agregarPronostico(pronosticoLucas2);
        Persona persona2 = new Persona("Fede");
        persona2.agregarPronostico(pronosticoFede1);
        persona2.agregarPronostico(pronosticoFede2);


        // Pruebas:
        assertEquals(4, persona1.puntosRondaFase(fase1.getRondas().get(0), 2));
        assertEquals(1, persona2.puntosRondaFase(fase1.getRondas().get(0), 2));

    }

    @Test
    void puntosFase() {
        // Equipos:
        Equipo equipo1 = new Equipo("A");
        Equipo equipo2 = new Equipo("B");

        // Ronda 1, partidos y pronósticos:
        Partido partido1 = new Partido(equipo1, equipo2, 2, 1);
        Partido partido2 = new Partido(equipo1, equipo2, 1, 2);
        List<Partido> partidos = new ArrayList<>();
        partidos.add(partido1);
        partidos.add(partido2);
        Ronda ronda1 = new Ronda(1, 1, partidos);
        partidos.get(0).setRondaPartido(ronda1);
        partidos.get(1).setRondaPartido(ronda1);
        Pronostico pronosticoLucas1 = new Pronostico(partido1, ResultadoEnum.GANA_EQUIPO1);
        Pronostico pronosticoFede1 = new Pronostico(partido1, ResultadoEnum.EMPATE);


        // Ronda 2, partidos y pronósticos:

        List<Partido> partidos2 = new ArrayList<>();
        partidos2.add(partido1);
        partidos2.add(partido2);
        Ronda ronda2 = new Ronda(1, 2, partidos2);
        partidos2.get(0).setRondaPartido(ronda2);
        partidos2.get(1).setRondaPartido(ronda2);
        Pronostico pronosticoLucas2 = new Pronostico(partido2, ResultadoEnum.GANA_EQUIPO1);
        Pronostico pronosticoFede2 = new Pronostico(partido2, ResultadoEnum.GANA_EQUIPO2);


        // Fase 1, rondas:
        List<Ronda> rondas = new ArrayList<>();
        rondas.add(ronda1);
        rondas.add(ronda2);
        Fase fase1 = new Fase(1, rondas);

        // Personas con su respectivo pronóstico:
        Persona persona1 = new Persona("Lucas");
        persona1.agregarPronostico(pronosticoLucas1);
        persona1.agregarPronostico(pronosticoLucas2);
        Persona persona2 = new Persona("Fede");
        persona2.agregarPronostico(pronosticoFede1);
        persona2.agregarPronostico(pronosticoFede2);


        // Pruebas:
        System.out.println("Prueba Lucas");
        assertEquals(12, persona1.puntosFase(fase1, 4, 2));
        //da 12 porque acerto en todas. En los aciertos de la fase da 8 (8 + 4 = 12) ya que se jugaron 4 partidos (4 puntos, 1 punto por cada) en 2 rondas
        // las cuales se acertaron los dos partidos de cada una ( puntos extras rondas: ronda1 = 2 + ronda2 = 2 da 4)
        System.out.println("\nPrueba Fede");
        assertEquals(2, persona2.puntosFase(fase1,4, 2));
        //da 2 porque solo acierta en 1 partido de cada ronda, por ende no tiene puntos extra ni de ronda ni de fase.
    }

    @Test
    void puntosTotales() {
        // Equipos:
        Equipo equipo1 = new Equipo("A");
        Equipo equipo2 = new Equipo("B");

        // Ronda 1, partidos y pronósticos:
        Partido partido1 = new Partido(equipo1, equipo2, 2, 1);
        Partido partido2 = new Partido(equipo1, equipo2, 1, 2);
        List<Partido> partidos = new ArrayList<>();
        partidos.add(partido1);
        partidos.add(partido2);
        Ronda ronda1 = new Ronda(1, 1, partidos);
        partidos.get(0).setRondaPartido(ronda1);
        partidos.get(1).setRondaPartido(ronda1);
        Pronostico pronosticoLucas1 = new Pronostico(partido1, ResultadoEnum.GANA_EQUIPO1);
        Pronostico pronosticoFede1 = new Pronostico(partido1, ResultadoEnum.EMPATE);


        // Ronda 2 exactamente igual que la ronda 1:

        List<Partido> partidos2 = new ArrayList<>();
        partidos2.add(partido1);
        partidos2.add(partido2);
        Ronda ronda2 = new Ronda(1, 2, partidos2);
        partidos2.get(0).setRondaPartido(ronda2);
        partidos2.get(1).setRondaPartido(ronda2);
        Pronostico pronosticoLucas2 = new Pronostico(partido2, ResultadoEnum.GANA_EQUIPO1);
        Pronostico pronosticoFede2 = new Pronostico(partido2, ResultadoEnum.EMPATE);


        // Fase 1, rondas:
        List<Ronda> rondas = new ArrayList<>();
        rondas.add(ronda1);
        rondas.add(ronda2);
        Fase fase1 = new Fase(1, rondas);

        // Fase 2 es exactamente igual que la fase 1 rondas:
        Fase fase2 = new Fase(2, rondas);
        List<Fase> fases = new ArrayList<>();
        fases.add(fase1);
        fases.add(fase2);

        // Personas con su respectivo pronóstico:
        Persona persona1 = new Persona("Lucas");
        persona1.agregarPronostico(pronosticoLucas1);
        persona1.agregarPronostico(pronosticoLucas2);
        Persona persona2 = new Persona("Fede");
        persona2.agregarPronostico(pronosticoFede1);
        persona2.agregarPronostico(pronosticoFede2);


        // Pruebas:
        System.out.println("Prueba Lucas");
        assertEquals(24, persona1.puntosTotales(fases, 4, 2));
        //devuelve 24 porque al ser 2 fases completamente iguales el resultado es el doble del resultado de puntosFase()
        System.out.println("\nPrueba Fede");
        assertEquals(0, persona2.puntosTotales(fases, 4, 2));

    }
}