package br.com.vacinas.servlets.vacina;

import br.com.vacinas.dao.impl.VacinaDAOImpl;
import br.com.vacinas.config.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/removerVacina")
public class ServletRemoverVacina extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        VacinaDAOImpl vacinaDAOImpl = new VacinaDAOImpl(connection);

        vacinaDAOImpl.delete(Long.valueOf(idStr));

        response.sendRedirect("listarVacinas");

    }

}