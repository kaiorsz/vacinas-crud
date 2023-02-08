package br.com.vacinas.servlets.alergia;

import br.com.vacinas.dao.impl.AlergiaDAOImpl;
import br.com.vacinas.config.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/removerAlergia")
public class ServletRemoverAlergia extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        AlergiaDAOImpl alergiaDAOImpl = new AlergiaDAOImpl(connection);

        alergiaDAOImpl.delete(Long.valueOf(idStr));

        response.sendRedirect("listarAlergias");

    }

}
