<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    if (request.getSession().getAttribute("usuario") == null) {
%>
<jsp:forward page="index.html">
    <jsp:param name="error" value="true"/>
</jsp:forward>
<%
    }
%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Bienvenido</title>
        <link rel="icon" href="data:;base64,iVBORw0KGgo=">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/background-table.css">
    </head>

    <body>
        <nav class="navbar navbar-light navbar-expand-lg fixed-top" id="mainNav">
            <div class="container"><a class="navbar-brand" href="#">UES</a><button data-toggle="collapse" data-target="#navbarResponsive" class="navbar-toggler" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
                <div
                    class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="#">INICIO</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="<%= request.getContextPath()%>/empleados">empleados</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="ingreso.jsp">cerrar sesión</a></li>
                        <li class="nav-item" role="presentation"></li>
                    </ul>
                </div>
            </div>
        </nav>
        <header class="masthead" style="background-image:url('assets/img/welcome.png');">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-lg-8 mx-auto">
                        <div class="site-heading">
                            <h1>¡Bienvenido!</h1><span class="subheading">Estamos alegres que regresaras.</span></div>
                    </div>
                </div>
            </div>
        </header>
        <div class="container">
            <h1 style="color: #000000">Usuario activo:</h1>
            <h2 class="text-center" style="color: #000000">${usuario}</h2>
        </div>
        <hr>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
<!--        <script src="assets/js/background.js"></script>-->
        <script src="assets/js/clean-blog.js"></script>
    </body>

</html>
</html>
