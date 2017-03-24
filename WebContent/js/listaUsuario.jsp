<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Usuarios</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>ID Usuario</th>
                <th>Primeiro Nome</th>
                <th>Ultimo Nome</th>
                <th>Data</th>
                <th>Email</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${usuarios}" var="user">
                <tr>
                    <td><c:out value="${user.idusuario}" /></td>
                    <td><c:out value="${user.primeironome}" /></td>
                    <td><c:out value="${user.ultimonome}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.data}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><a href="ControleUsuario?action=edit&idusuario=<c:out value="${user.idusuario}"/>">Update</a></td>
                    <td><a href="ControleUsuario?action=delete&idusuario=<c:out value="${user.idusuario}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ControleUsuario?action=insert">Adicionar Usuario</a></p>
</body>
</html>