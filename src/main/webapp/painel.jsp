<html>
<head>
    <meta charset="UTF-8"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@
            page contentType="text/html; charset=UTF-8" %>
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
    />
</head>
<body>

<div style="border: solid;width: 60%;margin: 2em">

    <h2 class="justify-content-center" style="text-align-last: center;">MENU</h2>

    <table class="table table-striped">
        <thead class="">
        <tr>
            <th scope="col">Vacinas</th>
            <th scope="col">Usuarios</th>
            <th scope="col">Alergias</th>
            <th scope="col">Agendas</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <a class="btn btn-outline-primary btn-sm my-2" style="background-color: cadetblue;color: white;border-color: cadetblue;" href="listaVacinas">Consultar Vacinas</a>
                <br/>
                <br/>
                <br/>
                <a class="btn btn-outline-primary btn-sm my-2" style="background-color: cadetblue;color: white;border-color: cadetblue;" href="addVacina">Adicionar Vacina</a>

            </td>
            <td>
                <a class="btn btn-outline-primary btn-sm my-2" style="background-color: cadetblue;color: white;border-color: cadetblue;" href="listaUsuarios">Consultar Usuários</a>
                <br/>
                <br/>
                <br/>
                <a class="btn btn-outline-primary btn-sm my-2" style="background-color: cadetblue;color: white;border-color: cadetblue;" href="addUsuario">Adicionar Usuário</a>
            </td>
            <td>
                <a class="btn btn-outline-primary btn-sm my-2" style="background-color: cadetblue;color: white;border-color: cadetblue;" href="listaAlergias">Consultar Alergias</a>
                <br/>
                <br/>
                <br/>
                <a class="btn btn-outline-primary btn-sm my-2" style="background-color: cadetblue;color: white;border-color: cadetblue;" href="adicionaAlergia">Adicionar Alergia</a>
            </td>
            <td>
                <a class="btn btn-outline-primary btn-sm my-2" style="background-color: cadetblue;color: white;border-color: cadetblue;" href="listaAgenda">Consultar Agenda</a>
                <br/>
                <br/>
                <br/>
                <a class="btn btn-outline-primary btn-sm my-2" style="background-color: cadetblue;color: white;border-color: cadetblue;" href="addAgenda">Adicionar Agenda</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>

</html>