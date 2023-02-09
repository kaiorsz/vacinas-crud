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

    <h2 class="justify-content-center">Lista de Usuarios</h2>
    <div class="justify-content-center">
        <div class="col-auto">

            <table class="table table-striped">
                <thead class="thead-striped">
                <tr style="border: outset">
                    <th scope="col">Nome</th>
                    <th scope="col">Data Nascimento</th>
                    <th scope="col">Sexo</th>
                    <th scope="col">Logradouro</th>
                    <th scope="col">Numero</th>
                    <th scope="col">Setor</th>
                    <th scope="col">Cidade</th>
                    <th scope="col">UF</th>
                    <th scope="col">Alergias</th>
                    <th scope="col">Ações</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="usuario" items="${usuarios}">
                    <tr>
                        <td>${usuario.getNome()}</td>
                        <td><input class="form-control" type="date" name="data" disabled
                                   value="${usuario.data_nascimento}"></td>
                        <td>${usuario.getSexo()}</td>
                        <td>${usuario.getLogradouro()}</td>
                        <td>${usuario.getNumero()}</td>
                        <td>${usuario.getSetor()}</td>
                        <td>${usuario.getCidade()}</td>
                        <td>${usuario.getUf()}</td>
                        <td>
                            <select class="form-control">
                                <c:forEach items="${listaAlergias}" var="alergia">
                                    <c:if test="${alergia.id_usuario == usuario.id}">
                                        <option value="${alergia.id_alergia}">${alergia.nome_alergia}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <a class="btn btn-outline-primary btn-sm my-2"
                               href="adicionaAlergiasUsuario?id=${usuario.id}">Adicionar Alergias</a>
                            <br/>
                            <a class="btn btn-outline-success btn-sm my-2" href="consultaUsuario?id=${usuario.id}">Consultar
                                Usuario</a>
                            <br/>
                            <a class="btn btn-outline-danger btn-sm my-2" href="removeUsuario?id=${usuario.id}">Remover
                                Usuário</a>
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
