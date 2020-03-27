$(window).on("load", function () {
    document.getElementById("elimineition").removeChild(document.getElementById("elimineition").firstChild);
    document.getElementById("name").value = "";
});

function editOrRem(idBoton) {
    if (idBoton.substring(0, 6) === "remove") {
        document.getElementById("empleadix").innerHTML = document.getElementById(idBoton).parentNode.previousElementSibling.previousElementSibling.previousElementSibling.innerHTML;
        document.getElementById("empleadixID").value = document.getElementById(idBoton).parentNode.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.innerHTML;
//        Seteando las variables a ""
        document.getElementById("editId").value = "";
        document.getElementById("editNombre").value = "";
        document.getElementById("editApellido").value = "";
        document.getElementById("editTel").value = "";
        document.getElementById("name").value ="";
    } else {
        document.getElementById("editId").value = document.getElementById(idBoton).parentNode.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.innerHTML;
        document.getElementById("editNombre").value = document.getElementById(idBoton).parentNode.previousElementSibling.previousElementSibling.previousElementSibling.innerHTML;
        document.getElementById("editApellido").value = document.getElementById(idBoton).parentNode.previousElementSibling.previousElementSibling.innerHTML;
        document.getElementById("editTel").value = document.getElementById(idBoton).parentNode.previousElementSibling.innerHTML;
        //        Seteando las variables a ""
        document.getElementById("empleadix").innerHTML = "";
        document.getElementById("empleadixID").value = "";
        document.getElementById("name").value ="";
    }
}
