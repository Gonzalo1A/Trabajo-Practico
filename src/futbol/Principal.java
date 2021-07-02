/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonzalo
 */
public class Principal {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    // JDBC driver name and database URL
    public static void main(String[] args) throws IOException {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        Scanner texto = new Scanner(System.in);
        Torneo agenda = new Torneo("Clown Cup");
        String nombre, nombreDirectorTecnico, color, dni, calle, localidad, fecha, tipo;
        long t;
        int altura, num, opcion, dniDirectorTecnico, torneosDt;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE JUGADOR "
                    + "(id_jugador int IDENTITY(1,1), "
                    + " nombre_completo VARCHAR(255), "
                    + " dni INTEGER, "
                    + " numero INTEGER, "
                    + " posicion VARCHAR(3), "
                    + " PRIMARY KEY ( id_jugador ))"
                    + "INSERT INTO PERSONA VALUES ('', 'PEDRO', 'PEREZ', 67)";
            //stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                } else {

                }
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                } else {

                }
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        }

        do {
            System.out.println("Opciones:");
            System.out.println("\t1) Inscribir Equipos");
            System.out.println("\t9) Salir de la agenda");
            System.out.print("Ingrese opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Nuevo Equipo");
                    System.out.println("Ingrese el nombre del Equipo: ");
                    nombre = sc.next();
                    System.out.println("Ingrese el color del Equipo: ");
                    color = sc.next();
                    System.out.println("Ingrese el nombre completo del director tecnico: ");
                    nombreDirectorTecnico = sc.next();
                    System.out.println("Ingrese el DNI director tecnico: ");
                    dniDirectorTecnico = sc.nextInt();
                    System.out.println("Cuantos torneos gano? ");
                    torneosDt = sc.nextInt();
                    DirectorTecnico dt = new DirectorTecnico(nombre, dniDirectorTecnico, torneosDt);
                    try {
                        Class.forName(JDBC_DRIVER);
                        System.out.println("Connecting to database...");
                        conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        System.out.println("Creating table in given database...");
                        stmt = conn.createStatement();
                        String sql = "CREATE TABLE JUGADOR "
                                + "(id_jugador INTEGER not NULL, "
                                + " nombre_completo VARCHAR(255), "
                                + " dni INTEGER, "
                                + " numero INTEGER, "
                                + " posicion VARCHAR(3), "
                                + " PRIMARY KEY ( id_jugador ))";

                        stmt.close();
                        conn.close();
                    } catch (SQLException se) {
                        //Handle errors for JDBC
                        se.printStackTrace();
                    } catch (Exception e) {
                        //Handle errors for Class.forName
                        e.printStackTrace();
                    } finally {
                        //finally block used to close resources
                        try {
                            if (stmt != null) {
                                stmt.close();
                            } else {

                            }
                        } catch (SQLException se2) {
                        } // nothing we can do
                        try {
                            if (conn != null) {
                                conn.close();
                            } else {

                            }
                        } catch (SQLException se) {
                            se.printStackTrace();
                        } //end finally try
                    }
                    Equipo equipo = new Equipo(nombre, color, dt, plantilla);
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 9);
    }

}
