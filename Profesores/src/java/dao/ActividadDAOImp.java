/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Actividad;
import model.Profesor;
import util.UtilDB;

/**
 *
 * @author yanet
 */
public class ActividadDAOImp implements ActividadDAO {

    private Connection connection;

    public ActividadDAOImp() {
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarActividad(Actividad actividad) {
        try {
            String query = "INSERT INTO actividades "
                    + "(descripcion, lugar, fecha_inicio, fecha_fin, total_horas)"
                    + "VALUES (?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, actividad.getDescripcion());
            ps.setString(2, actividad.getLugar());
            ps.setString(3, actividad.getFechaInicio());
            ps.setString(4, actividad.getFechaFin());
            ps.setInt(5, actividad.getTotalHoras());
           // ps.executeUpdate();
           ps.executeQuery();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarActividad(int cveUniversidad) {
        try {
            String query = "DELETE FROM actividades WHERE cve_universidad =?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, cveUniversidad);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarActividad(Actividad actividad) {
        try {
            String query = "UPDATE actividades SET descripcion =?, lugar =?, "
                    + "fecha_inicio =?, fecha_fin =?, total_horas =?"
                    + "WHERE cve_universidad =?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, actividad.getDescripcion());
            ps.setString(2, actividad.getLugar());
            ps.setString(3, actividad.getFechaInicio());
            ps.setString(4, actividad.getFechaFin());
            ps.setInt(5, actividad.getTotalHoras());
            ps.setInt(6, actividad.getCveUniversidad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Actividad> desplegarActividad() {
        List<Actividad> actividades = new ArrayList<Actividad>();
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(
                    "SELECT * FROM actividades");
            while (rs.next()) {
                Actividad actividad = new Actividad(
                        rs.getInt("cve_universidad"),
                        rs.getString("descripcion"),
                        rs.getString("lugar"),
                        rs.getString("fecha_inicio"),
                        rs.getString("fecha_fin"),
                        rs.getInt("total_horas"));
                actividades.add(actividad);
            }
       
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actividades;

    }

    @Override
    public Actividad elegirActividad(int cveUniversidad) {
        Actividad actividad = null;
        try {
           PreparedStatement ps = 
                    connection.prepareStatement(
                            "SELECT * FROM actividades"
                                    + " WHERE cve_universidad=?");
            ps.setInt(1, cveUniversidad);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                actividad = new Actividad(
                        rs.getInt("cve_universidad"),
                        rs.getString("descripcion"),
                        rs.getString("lugar"),
                        rs.getString("fecha_inicio"),
                        rs.getString("fecha_fin"),
                        rs.getInt("total_horas"));
            }
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actividad;
    }
}
