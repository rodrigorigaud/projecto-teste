<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Adicionar Novo Usuario</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=data]').datepicker();
        });
    </script>

    <form method="POST" action='ControleUsuario' name="frmAddUser">
        ID Usuario : <input type="text" readonly="readonly" name="idusuario" value="${user.idusuario}" /> <br /> 
        Primeiro Nome : <input type="text" name="primeironome" value="${user.primeironome}" /> <br /> 
        Ultimo Nome : <input type="text" name="ultimonome" value="${user.ultimonome}" /> <br /> 
        DATA : <input type="text" name="data" value="${user.data}" /> <br /> 
        Email : <input type="text" name="email" value="${user.email}" /> <br /> <input type="submit" value="Submit" />
    </form>
</body>
</html>