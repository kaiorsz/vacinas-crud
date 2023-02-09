<html lang="pt">
    <head>
        <meta charset="UTF-8" />
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <%@
        page contentType="text/html; charset=UTF-8" %>
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
        />
    </head>
    <body>
    <h2 class="justify-content-center">Adicionar Agenda</h2>
        <form action="addAgenda" method="post">
            <div class="justify-content-center">
                <div class="col-md-6">
                    Data:
                    <input class="form-control" type="date" name="data" required /> Hora:
                    <input class="form-control" type="time" name="hora" required />
                    Situação:
                    <select class="form-control" name="situacaoEnum">
                        <option value="Agendado">Agendado</option>
                        <option value="Cancelado">Cancelado</option>
                        <option value="Realizado">Realizado</option>
                    </select>
                    Observacoes:
                    <input
                        class="form-control"
                        type="text"
                        name="observacoes"
                        required
                    />
                    Usuário:
                    <select name="usuario_id" class="form-control">
                        <c:forEach items="${usuarios}" var="usuario">
                            <option value="${usuario.id}">
                                ${usuario.nome}
                            </option>
                        </c:forEach>
                    </select>
                    Vacina:
                    <select name="vacina_id" class="form-control">
                        <c:forEach items="${vacinas}" var="vacina">
                            <option value="${vacina.id}">${vacina.titulo}</option>
                        </c:forEach>
                    </select>
                    <br />
           <input class="form-control btn btn-primary" type="submit" style="width: 10%;" value="Enviar">
             <br>
             <br>
             <a href="painel" class="form-control btn btn-primary" style="width: 10%;background-color: red">
              Voltar
             </a>

                </div>
            </div>
        </form>
    </body>
</html>
