/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Gonzalo, Lucas, Alex
 */
public class Torneo {

    private String nombre;
    private List<Equipo> equipos;

    public Torneo(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
    }
    public void agregarEquipo(Equipo e){
        this.equipos.add(e);
    }
    public ArrayList<Partido> encuentros() {
        Partido p1 = new Partido(this.equipos.get(0), this.equipos.get(1));
        Partido p2 = new Partido(this.equipos.get(2), this.equipos.get(3));
        ArrayList<Partido> encuentros = new ArrayList();
        encuentros.add(p1);
        encuentros.add(p2);
        return encuentros;
    }

    public void jugar() {
        for (Partido p : encuentros()) {
            p.setDisputado();
            p.sumarPuntos();
        }
        orden();
    }

    public void orden() {
        Collections.sort(this.equipos, new Comparator<Equipo>() {
            @Override
            public int compare(Equipo e1, Equipo e2) {
                return new Integer(e2.getPuntos()).compareTo(new Integer(e1.getPuntos()));
            }
        });

    }

    @Override
    public String toString() {
        return "Torneo " + " Nombre: " + nombre + ", equipos: " + equipos 
                +"Ganador: "+ this.equipos.get(0).toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

 

}
