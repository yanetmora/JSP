<%-- 
    Document   : actividad
    Created on : 23/09/2016, 03:09:01 PM
    Author     : yanet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="ActividadController" method="post">
            <fieldset>
                <legend>Formulario de registro</legend>
                
                <div>
                <label for="cveUniversidad">cveUniversidad:</label>
                <input type="text" name="cveUniversidad:"
                       value="${actividad.cveUniversidad}"
                       readonly="readonly" 
                       placeholder="cve de la universidad"/>
                </div>
                
                <div>
                <label for="descripcion">Descripcion:</label>
                <input type="text" name="descripcion"
                       value="${actividad.descripcion}"
                       placeholder="Descripcion"/>
                </div>
                 
                <div>
                <label for="lugar">Lugar</label>
                <input type="text" name="lugar"
                       value="${actividad.lugar}"
                       placeholder="Lugar"/>
                </div>
                
                <div>
                <label for="fechaInicio">FechaInicio</label>
                <input type="text" name="fechaInicio"
                       value="${actividad.fechaInicio}"
                       placeholder="fechaInicio"/>
                </div>
                       
                <div>
                <label for="fechaFin">FechaFin</label>
                <input type="text" name="fechaFin"
                       value="${actividad.fechaFin}"
                       placeholder="fechaFin"/>
                </div>
                       
                <div>
                <label for="totalHoras">Total de horas</label>
                <input type="number" name="totalHoras"
                       value="${actividad.totalHoras}"
                       placeholder="totalHoras"/>
                </div>
                
                 <div>
                     <input type="submit" 
                       value="Guardar" />
                </div>
            </fieldset>
            
        </form>
    </body>
</html>
