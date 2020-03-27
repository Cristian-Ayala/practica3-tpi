<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    request.getSession().invalidate();
%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Inicio de Sesión</title>
        <link rel="icon" href="data:;base64,iVBORw0KGgo=">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">        
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/background-table.css">
    </head>

    <body>
        <nav class="navbar navbar-light navbar-expand-lg fixed-top" id="mainNav">
            <div class="container"><a class="navbar-brand" href="index.html">UES</a><button data-toggle="collapse" data-target="#navbarResponsive" class="navbar-toggler" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
                <div
                    class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation"></li>
                    </ul>
                </div>
            </div>
        </nav>
        <header class="masthead" style="background-image:url('assets/img/secure.jpg');">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-lg-8 mx-auto">
                        <div class="site-heading">
                            <h1 style="background-image: linear-gradient( 109.6deg,  rgba(227,236,62,0.79) 11.2%, rgba(230,29,58,1) 91.3% );">Inicio de sesión</h1><span class="subheading">Registrate para poder acceder a la mejor aplicación.</span></div>
                    </div>
                </div>
            </div>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-lg-8 mx-auto">
                    <div class="alert alert-danger" role="alert" style="display:${request.getParameter("error").equals("true")?('inherit'):('none')};" name="<%=request.getParameter("error")%>">
                        Debes ingresar primero.
                    </div>
                    <h1 style="color:#000000">Ingresa tus datos:</h1>
                    <form id="contactForm" name="sentMessage" method="POST" action="usuarios">
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls"><label>Usuario</label><input name="txtUsuario" class="form-control"  autocomplete="username" type="text"  required placeholder="Usuario"><small class="form-text text-danger help-block"></small></div>
                        </div>
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls"><label>Contraseña</label><input name="txtContrasenia" class="form-control" type="password" autocomplete="current-password" required placeholder="Contraseña"><small class="form-text text-danger help-block"></small></div>
                        </div>
                        <div class="control-group"></div>
                        <div id="success"></div>
                        <div class="form-group"><button class="btn btn-primary" id="sendMessageButton" type="submit">Iniciar</button></div>
                    </form>
                    <div class="alert alert-danger" role="alert" style="display:${(estado=='FAIL')?('inherit'):('none')}">
                        Contraseña o usuario incorrectos.
                    </div>
                </div>
            </div>
        </div>
        <hr>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
<!--        <script src="assets/js/background.js"></script>-->
        <script src="assets/js/clean-blog.js"></script>
    </body>

</html>