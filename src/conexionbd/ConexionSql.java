/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

import futbol.Jugador;
import java.sql.*;

/**
 *
 * @author Gonzalo
 */
public class ConexionSql {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";
    Connection conn = null;
    Statement stmt = null;
    static final String USER = "sa";
    static final String PASS = "";

    public void abrirConexion() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (conn.isClosed() != true) {
                System.out.println("Conexion abierta");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            if (conn.isClosed() != true) {
                conn.close();
                System.out.println("Conexion cerrada");
            } else {
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (this.stmt != null) {
                stmt.close();
            } else {
            }
        } catch (SQLException se2) {
            se2.printStackTrace();
        }
    }

    public void crearTablaJugador() {
        try {
            abrirConexion();
            this.stmt = conn.createStatement();
            String sql = "CREATE TABLE JUGADOR "
                    + "(id_jugador int IDENTITY(1,1), "
                    + " nombre_completo VARCHAR(255), "
                    + " dni INTEGER, "
                    + " numero INTEGER, "
                    + " posicion VARCHAR(3), "
                    + " PRIMARY KEY ( id_jugador ))";
            this.stmt.executeUpdate(sql);

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void cargarJugador(Jugador jugador) {

        try {
            abrirConexion();
            this.stmt = conn.createStatement();
            String sql = "INSERT INTO JUGADOR Values ("
                    + jugador.getId_persona()
                    + ","
                    + jugador.getNombreYApellido()
                    + ","
                    + jugador.getDni()
                    + ","
                    + jugador.getNumero()
                    + ","
                    + jugador.getPosicion()
                    + ")";
            System.out.println(sql);
            this.stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

    }

    public Jugador obtenerJugador(int id) {
        Jugador jugador = null;
        int jugadorID, dni, numero;
        String nombreYApellido, posicion;

        try {
            abrirConexion();
            String query = "SELECT id_jugador, nombre_completo, dni, numero, posicion  FROM usuario WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                jugadorID = rs.getInt("id_jugador");
                nombreYApellido = rs.getString("nombre_copleto");
                dni = rs.getInt("dni");
                numero = rs.getInt("numero");
                posicion = rs.getString("posicion");
                jugador = new Jugador(jugadorID, nombreYApellido, dni, numero, posicion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return jugador;
    }

}
