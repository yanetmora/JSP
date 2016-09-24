/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ActividadDAO;
import dao.ActividadDAOImp;
import dao.ProfesorDAO;
import dao.ProfesorDAOImp;
import javax.servlet.annotation.WebServlet;
import model.Actividad;
import model.Profesor;

/**
 *
 * @author Yanet
 */
@WebServlet (name = "ActividadController", urlPatterns = {"/ActividadController"})
public class ActividadController extends HttpServlet{
 private final String LISTA_ACTIVIDADES = "/lista_actividades.jsp";
    private final String AGREGAR_CAMBIAR = "/actividad.jsp";
    private ActividadDAO dao;
    
    public ActividadController(){
        dao = new ActividadDAOImp();
    }
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_ACTIVIDADES;
            int cveUniversidad = Integer.parseInt(
            request.getParameter("cveUniversidad"));
            dao.borrarActividad(cveUniversidad);
            request.setAttribute("actividades", dao.desplegarActividad());
        }else if(action.equalsIgnoreCase("cambiar")){
            forward = AGREGAR_CAMBIAR;
            int cveUniversidad = Integer.parseInt(
            request.getParameter("cveUniversidad"));
           Actividad actividad = dao.elegirActividad(cveUniversidad);
             dao.cambiarActividad(actividad);
            request.setAttribute("actividad", actividad);
        } else if(action.equalsIgnoreCase("agregar")){
            forward = AGREGAR_CAMBIAR;
        } else{
            forward = LISTA_ACTIVIDADES;
            request.setAttribute("actividades",
                    dao.desplegarActividad());
        }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Actividad actividad = new Actividad();
        actividad.setDescripcion(request.getParameter("descripcion"));
        actividad.setLugar(request.getParameter("lugar"));
        actividad.setFechaInicio(request.getParameter("fechaInicio"));
        actividad.setFechaFin(request.getParameter("fechaFin"));
        actividad.setTotalHoras(Integer.parseInt(request.getParameter("totalHoras")));
        
        String cveUniversidad = request.getParameter("cveUniversidad");
        
        if(cveUniversidad==null || cveUniversidad.isEmpty()){
            dao.agregarActividad(actividad);
        }else{
            actividad.setCveUniversidad(
                    Integer.parseInt(cveUniversidad));
            dao.cambiarActividad(actividad);
        }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_ACTIVIDADES);
        request.setAttribute("actividades", 
                dao.desplegarActividad());
        view.forward(request, response);
    }
   
}
