/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class Fase {

    private List<Partido> octavos;
    private List<Partido> cuartos;
    private List<Partido> semis;
    private List<Partido> finals;

    public Fase(List octavos) {
        this.octavos = octavos;
        this.cuartos = new ArrayList<>();
        this.semis = new ArrayList<>();
        this.finals = new ArrayList<>();
    }
    
    
    
}
