/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;

/**
 *
 * @author Gonzalo
 */
public class Partido {

    private Equipo local;
    private Equipo visitante;
    private Resultado resultado;
    private Date fecha;

    public Partido(Equipo local, Equipo visitante, Date fecha) {
        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
    }

    public void golLocal() {
        resultado.golLocal();
    }

    public void golVisitante() {
        resultado.getGolVisitante();
    }

    public Equipo ganador() {
        int a = this.resultado.getGolLocal();
        int b = this.resultado.getGolVisitante();
        if (a > b) {
            return this.local;
        } else {
            return this.visitante;
        }
    }
//    public void setGanador(){
//        setResultado().setGanador(true);
//    }
}
