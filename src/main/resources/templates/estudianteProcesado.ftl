<!DOCTYPE html>
<html>
<head>
    <title>${titulo}</title>
</head>
<body>
<h3>Informacion del Estudiante</h3>
<table>
    <tbody>
    <tr><td>Matricula: </td><td>${estudiante.matricula?string["0"]}</td></tr>
    <tr><td>Nombre: </td><td>${estudiante.nombre}</td></tr>
    <tr><td>Apellido: </td><td>${estudiante.apellido}</td></tr>
    <tr><td>Telefono: </td><td>${estudiante.telefono}</td></tr>
    </tbody>
</table>

<form action="/inicio" method="get">
    <button name="Inicio" type="submit">Inicio</button>
</form>

<form action="/modificarEstudiante/${estudiante.matricula?string["0"]}" method="post">
    <button name="Modificar" type="submit">Modificar</button>
</form>

<form action="/estudianteEliminado/${estudiante.matricula?string["0"]}" method="post">
    <button name="Eliminar" type="submit">Eliminar</button>
</form>

</body>
</html>