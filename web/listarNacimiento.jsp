<%-- 
    Document   : agregarNacimiento
    Created on : 06-08-2022, 18:11:29
    Author     : 696
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nacimientos</title>
    </head>
    <body>
         <c:import url="opciones.jsp"/>
          <h1>Registro Nacimientos</h1>
         <c:if test="${not empty sessionScope.registro.listaNacimientos}">
            <table name="tablaDatos" align="left" border="1" cellpadding="3" >
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Peso</th>
                    <th>Prematuro</th>
                    <th>Sexo</th>
                    <th>Fecha Nacimiento</th>
                    <th>Centro</th>
                    
                </tr> 
                <c:forEach var="n" items="${sessionScope.registro.listaNacimientos}">

                    <tr><td> <c:out value="${n.id}"/> </td>
                        <td> <c:out value="${n.nombre}"/> </td>
                        <td> <c:out value="${n.peso}"/> </td>
                        <td> <c:out value="${n.prematuro}"/> </td>
                        <td> <c:out value="${n.sexo}"/> </td>
                        <td> <fmt:formatDate value="${n.fechaNacimiento}" pattern="dd/MM/yy HH:mm:ss"/></td>
                        
                        <td> <c:out value="${n.centro}"/> </td>
                        <td><c:url var="urlEliminar" value="/listarNacimientoServlet"/>
                            
                        <form action="${urlEliminar}" method="POST">
                         <input type="hidden" name="id" value="${n.id}" />
                         <input type="submit" value="Eliminar" />
                        </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <BR/><BR/><BR/>
        <c:if test="${not empty mensaje}">
            <h2><c:out value="${mensaje}"/></h2>
        </c:if>
    </body>
</html>

