package org.example;
public class Partido {
    //propiedades
    private Ronda rondaPartido; //necesitaba ser int o usar id partido

    //private int ID_Partido;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    //constructores
    public Partido(){

    }

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    //get y set
    public Ronda getRondaPartido() {
        return rondaPartido;
    }

    public void setRondaPartido(Ronda rondaPartido) {
        this.rondaPartido = rondaPartido;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    //metodos
    public ResultadoEnum resultado() {
        // EVALUA EL RESULTADO DEL PARTIDO SEGUN LOS GOLES
        if (this.golesEquipo1 > this.golesEquipo2){
            return ResultadoEnum.GANA_EQUIPO1;
        } else if (this.golesEquipo2 > this.golesEquipo1) {
            return ResultadoEnum.GANA_EQUIPO2;
        }
        else{
            return ResultadoEnum.EMPATE;
        }
    }
}
