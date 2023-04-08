package org.example;
public class Pronostico {
    //propiedades
    private Partido partido;
    private ResultadoEnum resultado;

    //constructores
    public Pronostico(){

    }
    public Pronostico(Partido partido, ResultadoEnum resultado){
        this.partido = partido;
        this.resultado = resultado;
    }

    //get y set

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }
}
