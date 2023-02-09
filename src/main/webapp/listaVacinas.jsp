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
<h2 class="justify-content-center">Lista de Vacinas</h2>
<div class="justify-content-center">
    <div class="col-auto">

        <table class="table table-striped">
            <thead class="thead-striped">
            <tr style="border:outset">
                <th scope="col">Titulo</th>
                <th scope="col">Descrição</th>
                <th scope="col">Doses</th>
                <th scope="col">Periodicidade</th>
                <th scope="col">Intervalo</th>
                <th scope="col">Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="vacina" items="${vacinas}">
                <tr>
                    <td>${vacina.getTitulo()}</td>
                    <td>${vacina.getDescricao()}</td>
                    <td>${vacina.getDoses()}</td>
                    <td>${vacina.getPeriodicidade()}</td>
                    <td>${vacina.getIntervalo()}</td>
                    <td><a class="btn btn-outline-success btn-sm my-2" href="consultaVacina?id=${vacina.id}">Consultar
                        Vacina</a>
                        <br/>
                        <a class="btn btn-outline-danger btn-sm my-2" href="removeVacina?id=${vacina.id}">Remover
                            Vacina</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <a href="painel" class="btn btn-outline-primary btn-small my-2">
            Voltar
        </a>
    </div>
</body>
</html>
