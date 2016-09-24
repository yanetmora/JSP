<%-- 
    Document   : lista_actividades
    Created on : 23/09/2016, 03:10:42 PM
    Author     : yanet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>  
                <tr>
                    <th>clave Universidad</th>
                    <th>Descripcion</th>
                    <th>Lugar</th>
                    <th>Fecha de Inicio</th>
                    <th>Fecha de Finalizacion</th>
                    <th>Horas Totales</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${actividades}" var="actividad" 
                       >
                <tr>
                    <td>${actividad.cveUniversidad}</td>
                    <td>${actividad.descripcion}</td>
                    <td>${actividad.lugar}</td>
                    <td>${actividad.fechaInicio}</td>
                    <td>${actividad.fechaFin}</td>
                    <td>${actividad.totalHoras}</td>
                    <td><a href="ActividadController?action=cambiar&cveUniversidad=${actividad.cveUniversidad}">Cambiar</a>
                    </td>
                    <td><a href="ActividadController?action=borrar&cveUniversidad=${actividad.cveUniversidad}">Borrar</a></td>
                </tr>  
            </c:forEach> 
        </tbody>
    </table>
    <p>
        <a href="ActividadController?action=agregar">
            Agregar actividad
        </a>
    </p>
</body>
</html>
