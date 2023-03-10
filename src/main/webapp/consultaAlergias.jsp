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
    <h2 class="justify-content-center">Lista de Alergias</h2>
    <div class="justify-content-center">
        <div class="col-auto">

            <table class="table table-striped" >
                <thead class="thead-striped">
                <tr style="border: outset">
                    <th scope="col">Nome</th>
                    <th scope="col">Ações</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="alergia" items="${alergias}">
                    <tr>
                        <td>${alergia.getNome()}</td>
                        <td>
                            <a class="btn btn-outline-primary btn-small my-2" href="consultaAlergia?id=${alergia.id}">Consultar
                                Alergia</a>
                            <br/>
                            <a class="btn btn-outline-danger btn-small my-2" href="removeAlergia?id=${alergia.id}">Remover
                                Alergia</a>
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
