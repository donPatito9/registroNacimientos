<%-- 
    Document   : index
    Created on : 06-08-2022, 18:11:05
    Author     : 696
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Centro Medico</title>
    </head>
    <body>
        <c:import url="opciones.jsp" />
        <h1>Registro Nacimiento</h1>
        <c:url var="urlForm" value="/agregarNacimientoServlet"/>
        <form action="${urlForm}" method="post">
            
            Id: <input type="text" name="id"required/></br></br>
            
            Nombre: <input type="text" name="nombre"required/></br></br>
            
            Peso: <input type="text" name="peso"/required></br></br>
            
            Prematuro: <input type="radio" name="prematuro"value="si"/>Si<input type="radio" name="prematuro"value="no"/>No</br></br>
            
            Sexo: <input type="radio" name="sexo"value='M'/>Masculino<input type="radio" name="sexo"value='F'/>Femenino</br></br>
            
            Centro: <select name="centro"required>
                <option value="selected">Seleccione</option>
                <option value="1">Centro 1</option>
                <option value="2">Centro 2</option>
                <option value="centro 3">Centro 3</option>
                <option value="centro 4">Centro 4</option>
                <option value="centro 5">Centro 5</option>
                <option value="6">Centro 6</option>
                <option value="7">Centro 7</option>
                <option value="8">Centro 8</option>
                 <option value="9">Centro 9</option>
                <option value="10">Centro 10</option>   
            </select></br></br></br>
            
            <input type="submit" value="Enviar"/>
            <input type="reset" value="Limpiar"/>
        </form>
        <c:if test="${not empty respuesta}">
            <h2> <c:out value="${respuesta}" /></h2>
        </c:if></br> 

        <c:if test="${not empty error}">
            <ul>
                <c:forEach var="e" items="${error}">
                    <li><c:out value="${err}"/></li>  
                </c:forEach>
            </ul>
        </c:if>    
    </body>
</html>
