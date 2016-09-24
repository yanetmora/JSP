
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de profesores</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Experiencia</th>
                    <th>Carrera</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${profesores}" var="profesor">
                    <tr>
                        <td>${profesor.idProfesor}</td>
                        <td>${profesor.nombre}</td>
                        <td>${profesor.experiencia}</td>
                        <td>${profesor.carrera}</td>
                        <td>
                            <a href="ProfesorController?action=cambiar&idProfesor=${profesor.idProfesor}">Cambiar</a>
                        </td>
                        <td>
                            <a href="ProfesorController?action=borrar&idProfesor=${profesor.idProfesor}">Borrar</a>
                        </td>
                    
                    </tr>
                </c:forEach>
            </tbody>    
        </table>
        
        <p>
            <a href="ProfesorController?action=agregar">Agregar profesor</a>
        </p>
    </body>
</html>