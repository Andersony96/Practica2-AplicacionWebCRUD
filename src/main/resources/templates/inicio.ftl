<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${titulo}</title>
</head>
<body>

<p>
<h3>Cantidad de Estudiantes: ${listaEstudiante?size}</h3>
<table style="border: 2px solid blue;">
    <tr><th>Matricula</th><th>Nombre</th><th>Apellido</th><th>Telefono</th></tr>
<#list listaEstudiante as estudiante>
    <tr>
       <td> ${estudiante.matricula?string["0"]}</td>
        <td>${estudiante.nombre}</td>
        <td>${estudiante.apellido}</td>
        <td>${estudiante.telefono}</td>
        <td><form action="/verEstudiante/${estudiante.matricula?string["0"]}" method="post">
            <button name="Ver" type="submit">Ver</button><br/>
        </form></td>
    </tr>
</#list>
</table>
</p>

<form action="/registrarEstudiante" method="get">
    <button name="Registrar" type="submit">Registrar</button><br/>
</form>



</body>
</html>