

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
    </head>
    <body>
        <h1>Log In</h1>
        <form id="formulario_login" method="post" action="Logar" >
            <input type="text" class="entradaLogin" name="login" required> 
            <input type="password" class="entradaSenha" name="senha" required>  
            <button type="submit" class="botaoEntrar" id="btnEntrar">Log in</button> 
        </form>
        <script type="text/javascript" src="javascript/index.js"></script>
    </body>
</html>
