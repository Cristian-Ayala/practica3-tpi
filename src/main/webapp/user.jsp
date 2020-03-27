<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    if (request.getSession().getAttribute("usuario") == null) {
//        request.setAttribute("error", true);
        request.getRequestDispatcher("/ingreso.jsp").forward(request, response);
    } else {
    }
%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>CRUD de Usuarios</title>
        <link rel="icon" href="data:;base64,iVBORw0KGgo=">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic">
        <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/background-table.css">
    </head>

    <body id="top">
        <nav class="navbar navbar-light navbar-expand-lg fixed-top" id="mainNav">
            <div class="container"><a class="navbar-brand" href="#">UES</a><button data-toggle="collapse" data-target="#navbarResponsive" class="navbar-toggler" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
                <div
                    class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="<%= request.getContextPath()%>/empleados.jsp">INICIO</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="<%= request.getContextPath()%>/empleados">empleados</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="index.html">cerrar sesión</a></li>
                        <li class="nav-item" role="presentation"></li>
                    </ul>
                </div>
            </div>
        </nav>
        <header class="masthead" style="background-image:url('assets/img/user-jsp.png');">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-lg-8 mx-auto">
                        <div class="site-heading">
                            <h1>Usuarios CRUD</h1>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <div id="center" style="display: inline-flex;">
            <div id="divForm" style="padding-left: 30px;max-width: 30%;display: inline-block;vertical-align: top;margin-right: 50px;">
                <h2 class="post-title">Agrega un nuevo usuario:</h2>
                <form id="contactForm" method="POST" action="<%= request.getContextPath()%>/userServlet">
                    <div class="control-group">
                        <div class="form-group floating-label-form-group controls"><label>Nombres</label><input class="form-control" type="text" id="nombre" name="nombre" required="" placeholder="Nombres"><small class="form-text text-danger help-block"></small></div>
                    </div>
                    <div class="control-group">
                        <div class="form-group floating-label-form-group controls"><label>Apellidos</label><input class="form-control" type="text" id="apellido" name="apellido" required="" placeholder="Apellidos"><small class="form-text text-danger help-block"></small></div>
                    </div>
                    <div class="control-group">
                        <div class="form-group floating-label-form-group controls"><label>Edad</label><input class="form-control" type="text" id="edad" name="edad" required="" placeholder="Edad"><small class="form-text text-danger help-block"></small></div>
                    </div>
                    <div class="control-group">
                        <div class="form-group floating-label-form-group controls"><label>Usuario</label><input class="form-control" type="text" id="usuario" name="usuario" required="" placeholder="Usuario"><small class="form-text text-danger help-block"></small></div>
                    </div>
                    <div class="control-group">
                        <div class="form-group floating-label-form-group controls"><label>Contraseña</label><input class="form-control" type="text" id="contrasenia" name="contrasenia" required="" placeholder="Contraseña"><small class="form-text text-danger help-block"></small></div>
                    </div>
                    <div id="success"></div>
                    <div class="form-group"><button class="btn btn-primary" id="sendMessageButton" type="submit" style="margin-top: 30px;">CRear</button></div>
                </form>

                <div class="alert alert-success" role="alert" style="display:${request.getParameter("correcto").equals("true")?('inherit'):('none')};" name="<%=request.getParameter("correcto")%>"><span>¡Se agregó el empleado con éxito!</span></div>

            </div><div id="gradient" style="border-radius:0.5rem!important;border:1px solid #dee2e6!important;">
                <section>
                    <!--for demo wrap-->
                    <h1>Usuarios:</h1>
                    <div class="tbl-header">
                        <table cellpadding="0" cellspacing="0" border="0">
                            <thead>
                                <tr>
                                    <th>Nombres</th>
                                    <th>Apellidos</th>
                                    <th>Edad</th>
                                    <th>Usuario</th>
                                    <th>Operaciones</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                    <div class="tbl-content" id="elimineition">
                        <table cellpadding="0" cellspacing="0" border="0">
                            <tbody>
                                <c:forEach items="${listaUsuarios}" var="user" varStatus="loop">
                                    <tr>
                                        <td style="display:none">${user.idUsuario}</td>
                                        <td>${user.nombres}</td>
                                        <td>${user.apellidos}</td>
                                        <td>${user.edad}</td>
                                        <td>${user.usuario}</td>
                                        <td style="display:inline-flex;">              
                                            <button class="add"  id="remove${loop.index}" onclick="editOrRem(this.id)" style="margin-right:10px" data-toggle="modal" data-target="#modal-1">
                                                <i class="fa fa-trash"></i>
                                            </button>
                                            <button class="warningButtom" id="edit${loop.index}" onclick="editOrRem(this.id)" data-toggle="modal" data-target="#modal-2">
                                                <i class="fa fa-pencil"></i>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>>
                            </tbody>
                        </table>
                    </div>
                </section>
            </div></div>
        <div class="modal fade" role="dialog" tabindex="-1" id="modal-1">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Confirmar</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                    <div class="modal-body">
                        <form method="POST" action="<%= request.getContextPath()%>/userServlet">
                            <h8>¿Está segur@ de querer eliminar a "</h8><h8 id="elimEmpleado" name="elimEmpleado"></h8><h8>" de la lista de usuarios?</h8>
                            <input type="hidden" id="elimEmpleadoID" name="elimEmpleadoID">
                            <div class="modal-footer"><button class="btn btn-light" type="button" data-dismiss="modal">Cerrar</button><button class="btn btn-danger" type="submit">Eliminar</button></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" role="dialog" tabindex="-1" id="modal-2">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Modicar</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                    <div class="modal-body">
                        <div id="divForm-1">
                            <form id="contactForm-1"  method="POST" action="<%= request.getContextPath()%>/userServlet">
                                <input type="hidden" id="editId" name="editId" value="">
                                <div class="control-group">
                                    <div class="form-group floating-label-form-group controls floating-label-form-group-with-value"><label>Nombres</label><input class="form-control" type="text" id="txtNombre" name="txtNombre" required="" placeholder="Nombres"><small class="form-text text-danger help-block"></small></div>
                                </div>
                                <div class="control-group">
                                    <div class="form-group floating-label-form-group controls floating-label-form-group-with-value"><label>Apellidos</label><input class="form-control" type="text" id="txtApellido" name="txtApellido" required="" placeholder="Apellidos"><small class="form-text text-danger help-block"></small></div>
                                </div>
                                <div class="control-group">
                                    <div class="form-group floating-label-form-group controls floating-label-form-group-with-value"><label>Edad</label><input class="form-control" type="text" id="txtEdad" name="txtEdad" required="" placeholder="Edad"><small class="form-text text-danger help-block"></small></div>
                                </div>
                                <div class="control-group">
                                    <div class="form-group floating-label-form-group controls floating-label-form-group-with-value"><label>Usuario</label><input class="form-control" type="text" id="txtUsuario" name="txtUsuario" required="" placeholder="Usuario"><small class="form-text text-danger help-block"></small></div>
                                </div>
                                <div class="control-group">
                                    <div class="form-group floating-label-form-group controls"><label>Contraseña</label><input class="form-control" type="text" id="txtContrasenia" name="txtContrasenia" required="" placeholder="Contraseña"><small class="form-text text-danger help-block"></small></div>
                                </div>
                                <div class="modal-footer"><button class="btn btn-light" type="button" data-dismiss="modal">cerrar</button><button class="btn btn-primary" type="submit">confirmar</button></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/background.js"></script>
        <script src="assets/js/usuarios.js"></script>
        <script src="assets/js/clean-blog.js"></script>
    </body>

</html>