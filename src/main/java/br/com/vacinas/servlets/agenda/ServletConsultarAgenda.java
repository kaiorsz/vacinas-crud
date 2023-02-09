package br.com.vacinas.servlets.agenda;

import br.com.vacinas.dao.impl.AgendaDAOImpl;
import br.com.vacinas.config.ConnectionFactory;
import br.com.vacinas.model.Agenda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/consultaAgenda")
public class ServletConsultarAgenda extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        AgendaDAOImpl agendaDAOImpl = new AgendaDAOImpl(connection);

        Agenda agenda = agendaDAOImpl.getById(Long.valueOf(idStr));

        request.setAttribute("agenda", agenda);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/painel.jsp");
        dispatcher.forward(request, response);
    }


}