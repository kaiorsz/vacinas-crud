package br.com.vacinas.servlets.agenda;

import br.com.vacinas.dao.impl.AgendaDAOImpl;
import br.com.vacinas.config.ConnectionFactory;
import br.com.vacinas.model.Agenda;
import br.com.vacinas.model.enums.SituacaoEnum;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("darBaixaAgenda")
public class ServletDarBaixaAgenda extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        AgendaDAOImpl agendaDAOImpl = new AgendaDAOImpl(connection);

        Agenda agenda = agendaDAOImpl.getById(Long.valueOf(idStr));

        request.setAttribute("agenda", agenda);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/dar-baixa-agenda.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");
        String dataSituacaoStr = request.getParameter("data_situacao");
        String situacaoStr = request.getParameter("situacao");

        LocalDate data = LocalDate.parse(dataSituacaoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        SituacaoEnum situacaoEnum = SituacaoEnum.valueOf(situacaoStr);

        AgendaDAOImpl agendaDAOImpl = new AgendaDAOImpl(connection);

        Agenda agenda = agendaDAOImpl.getById(Long.valueOf(idStr));
        agenda.setData_situacao(data);
        agenda.setSituacao(situacaoEnum);

        agendaDAOImpl.update(agenda);

        response.sendRedirect("listarAgendas");


    }


}
