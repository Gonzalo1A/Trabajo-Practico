/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol;

import conexionbd.ConexionSql;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gonzalo
 */
public class Principal {

    private static final ConexionSql bd = new ConexionSql();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Partido> encuentros = new ArrayList<>();
        Torneo torneo = new Torneo("Clown Cup");
        String nombre, nombreEquipo, color, posicion;
        int opcion, id_jugador = 0, dni, numeroCamiseta, torneosDt;

        do {
            
            System.out.println("Opciones:");
            System.out.println("\t1) Inscribir Jugador (se necesitan al menos 10)");
            System.out.println("\t2) Generar Equipos (se necesitan minimo 2)");
            System.out.println("\t3) Generar proximos Encuentros");
            System.out.println("\t4) Jugar Partidos");
            System.out.println("\t5) Obtener Tabla de posiciones");
            System.out.println("\t9) Finalizar Torneo");
            System.out.print("Ingrese opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Jugador jugador = null;
                    
                    System.out.println("Nuevo jugador");
                    System.out.println("Ingrese el nombre y apellido del jugador");
                    nombre = sc.next();
                    System.out.println("Ingreser Dni del jugador");
                    dni = sc.nextInt();
                    System.out.println("Ingrese numero de camiseta");
                    numeroCamiseta = sc.nextInt();
                    System.out.println("Ingrese posicion (DEL, ARQ, DEF )");
                    posicion = sc.next();
                    id_jugador += 1;
                    jugador = new Jugador(id_jugador, nombre, dni, numeroCamiseta, posicion);
                    bd.cargarJugador(jugador);
                    break;
                case 2:
                    System.out.println("Nuevo Equipo");
                    System.out.println("Ingrese el nombre del Equipo: ");
                    nombreEquipo = sc.next();
                    System.out.println("Ingrese el color del Equipo: ");
                    color = sc.next();
                    System.out.println("Ingrese el nombre completo del director tecnico: ");
                    nombre = sc.next();
                    System.out.println("Ingrese el DNI director tecnico: ");
                    dni = sc.nextInt();
                    System.out.println("Cuantos torneos gano? ");
                    torneosDt = sc.nextInt();
                    List<Jugador> plantilla = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Ingrese el id del jugador (1,2,3...");
                        id_jugador = sc.nextInt();
                        plantilla.add(bd.obtenerJugador(id_jugador));
                    }
                    System.out.println("");
                    DirectorTecnico dt = new DirectorTecnico(nombre, dni, torneosDt);
                    Equipo equipo = new Equipo(nombreEquipo, color, dt, plantilla);
                    torneo.agregarEquipo(equipo);
                    break;
                case 3:
                    if (!(torneo.getEquipos().size() % 2 == 0)) {
                        System.out.println("No hay suficientes equipos, por favor anote mas esuqipos antes de continuar");
                        break;
                    }
                    encuentros = torneo.encuentros();
                    System.out.println("Los proximos encuentros son: ");
                    for (Partido partido : encuentros) {
                        System.out.println(partido);
                    }
                    break;
                case 4:
                    if (!(torneo.getEquipos().size() % 2 == 0)) {
                        System.out.println("No hay suficientes equipos, por favor anote mas esuqipos antes de continuar");
                        break;
                    }
                    for (Partido partido : encuentros) {
                        System.out.println(partido);
                        while (partido.getDisputado()) {
                            System.out.println("Ingrese numero 1 o 2 \n1: gol local \n2: gol visitante");
                            int aux = sc.nextInt();
                            if (aux < 1 || aux > 2) {
                                System.out.println("Solo 1 y 2 se puede ingresar");
                                break;
                            }
                            if (aux == 1) {
                                partido.haceGolLocal();
                            } else {
                                partido.haceGolVisitante();
                            }
                            System.out.println("Si termino el partido ingrese 9 si no presione 0");
                            aux = sc.nextInt();
                            if (aux == 9) {
                                partido.setDisputado();
                            }
                        }
                    }
                    torneo.orden();
                    break;
                case 5:
                    System.out.println("Tabala de posiciones");
                    System.out.println(torneo.getEquipos());
                    break;
                case 9:
                    System.out.println("Fin del torneo");
                    System.out.println(torneo);
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 9);
    }

}
