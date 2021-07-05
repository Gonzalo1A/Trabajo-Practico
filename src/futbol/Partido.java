/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol;

/**
 *
 * @author Gonzalo
 */
public class Partido {

    private Equipo local;
    private Equipo visitante;
    private Resultado resultado;
    private boolean disputado;

    public Partido(Equipo local, Equipo visitante) {
        this.local = local;
        this.visitante = visitante;
        this.disputado = false;
        resultado = new Resultado();
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void getGolesLocal() {
        resultado.haceGolLocal();
    }

    public void getGolesVisitante() {
        resultado.getGolVisitante();
    }

    public void haceGolLocal() {
        resultado.haceGolLocal();
    }

    public void haceGolVisitante() {
        resultado.haceGolVisitante();
    }

    public boolean getDisputado() {
        return disputado;
    }

    public void setDisputado() {
        this.disputado = true;
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

    public void sumarPuntos() {
        ganador().sumarPuntos(1);
    }

    @Override
    public String toString() {
        return "El Equipo: " + this.local.getNombre() + " se enfrenta al equipo: "
                + this.visitante.getNombre() + "\n";
    }

}
