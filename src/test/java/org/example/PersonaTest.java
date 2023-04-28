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
        // FUNCIONA MAL.
        assertEquals(2, persona1.puntosRondaFase(fase1.getNumeroFase(), fase1.getRondas().get(0).getNumeroRonda(), 2));
        assertEquals(1, persona2.puntosRondaFase(fase1.getNumeroFase(), fase1.getRondas().get(0).getNumeroRonda(), 2));
    }

    @Test
    void puntosFase() {
    }

    @Test
    void puntosTotales() {

    }
}