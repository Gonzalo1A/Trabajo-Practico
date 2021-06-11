/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author Gonzalo, Lucas, Alex
 */
public class Torneo {
    
    private String Nombre;
    private List<Equipo> equipos;

    public Torneo() {
       this.equipos = new ArrayList<>();
    }
    
    public List<Partido> encuentros(){
        Partido p1 = new Partido(this.equipos.get(0), this.equipos.get(3));
        Partido p2 = new Partido(this.equipos.get(1), this.equipos.get(2));
        ArrayList<Partido> encuentros = new ArrayList();
        encuentros.add(p1);
        encuentros.add(p2);
        return  encuentros;
    }
    public void jugar(){
        for(Partido p : encuentros()){
            p.setDisputado(true);
            p.sumarPuntos();
        }
    }
    
    public static void burbuja() {
  
        for( int i = 0; i<4-1;i++){
            for ( int j = 0; j < 4 - i - 1; j++) {
                if (this.equipos.get(j+1).getPuntos() < this.equipos.get(j).getPuntos()) {
                    int aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }
}
    
    public List<Partido> posiciones(){
        ArrayList<Equipo> ganadores = new  ArrayList();
        ArrayList<Equipo> perdedores = new ArrayList();
        for(Equipo e : this.equipos){
            if(e.getPuntos()>1){
                ganadores.add(e);
            }
            else{
                perdedores.add(e);
            }
        }
        
    }
    
//    public Partido nuevo(List<Partido> fase,Date fecha){
//         int contador = 0;
//         Equipo ganador1 = null;
//         Equipo ganador2 = null;
//        for(Partido p : fase){
//            if(contador==0){
//              ganador1 = p.ganador();
//                contador+=1;
//            }
//            else{
//                ganador2 = p.ganador();
//                break;
//            }
//        }
//        fase.remove(0);
//        fase.remove(1);
//        Partido partido = new Partido(ganador1, ganador2, fecha);
//        return partido;
//    }
    
//    public void agregarOctavos
//    public List<Partido> cuartos(){
//        for(Partido p : octavos){
//            Equipo ganador = p.ganador();
//            
//        }
//        Partido partido = new Partido(local, visitante, resultado, fecha);
//    }
}
