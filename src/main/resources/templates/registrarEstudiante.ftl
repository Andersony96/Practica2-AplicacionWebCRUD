<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>${titulo}</title>
</head>

<body>
<h2><strong>Registro de Estudiante</strong></h2>

<form action="/creandoEstuadiante/" method="post">
    Matricula:<br>
    <input name="matricula" type="number"/><br/>
    Nombre:<br>
    <input type="text" name="nombre"><br/>
    Apellido:<br>
    <input type="text" name="apellido"><br/>
    Telefono:<br>
    <input type="text" name="telefono"><br/>
    <button name="Registrar" type="submit">Registrar</button>
</form>
<form action="/inicio" method="get">
    <button name="Cancelar" type="submit">Cancelar</button>
</form>

</body>
</html>