package br.com.vacinas.servlets.agenda;
import br.com.vacinas.dao.impl.AgendaDAOImpl;
import br.com.vacinas.config.ConnectionFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/removerAgenda")
public class ServletRemoverAgenda extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        AgendaDAOImpl agendaDAOImpl = new AgendaDAOImpl(connection);

        agendaDAOImpl.delete(Long.valueOf(idStr));

        response.sendRedirect("listarAgendas");
    }

}