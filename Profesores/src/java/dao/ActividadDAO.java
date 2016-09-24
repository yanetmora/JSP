/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Actividad;

/**
 *
 * @author yanet
 */
public interface ActividadDAO {
    void agregarActividad (Actividad actividad);
    void borrarActividad (int cveUniversidad);
    void cambiarActividad (Actividad actividad);
    List<Actividad> desplegarActividad();
    Actividad elegirActividad(int cveUniversidad);
}
