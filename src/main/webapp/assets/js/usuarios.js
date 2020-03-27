$(window).on("load", function () {
    document.getElementById("elimineition").removeChild(document.getElementById("elimineition").firstChild);
    document.getElementById("nombre").value = "";
});

function editOrRem(idBoton) {
    if (idBoton.substring(0, 6) === "remove") {
        document.getElementById("elimEmpleado").innerHTML = document.getElementById(idBoton).parentNode.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.innerHTML;
        document.getElementById("elimEmpleadoID").value = document.getElementById(idBoton).parentNode.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.innerHTML;
        console.log(document.getElementById("elimEmpleado").innerHTML);
        console.log(document.getElementById("elimEmpleadoID").value);
        //        Seteando las variables a ""
        document.getElementById("txtNombre").value = "";
        document.getElementById("nombre").value = "";
    } else {
        document.getElementById("editId").value = document.getElementById(idBoton).parentNode.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.innerHTML;
        document.getElementById("txtNombre").value = document.getElementById(idBoton).parentNode.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.innerHTML;
        document.getElementById("txtApellido").value = document.getElementById(idBoton).parentNode.previousElementSibling.previousElementSibling.previousElementSibling.innerHTML;
        document.getElementById("txtEdad").value = document.getElementById(idBoton).parentNode.previousElementSibling.previousElementSibling.innerHTML;
        document.getElementById("txtUsuario").value = document.getElementById(idBoton).parentNode.previousElementSibling.innerHTML;
        document.getElementById("txtContrasenia").value = "";

        //        Seteando las variables a ""
        document.getElementById("elimEmpleado").innerHTML = "";
        document.getElementById("elimEmpleadoID").value = "";
        document.getElementById("nombre").value = "";
    }
}
