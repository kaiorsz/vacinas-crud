package br.com.vacinas.servlets.alergia;

import br.com.vacinas.dao.impl.AlergiaDAOImpl;
import br.com.vacinas.config.ConnectionFactory;
import br.com.vacinas.model.Alergia;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/consultaAlergia")
public class ServletConsultarAlergia extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        AlergiaDAOImpl alergiaDAOImpl = new AlergiaDAOImpl(connection);

        Alergia alergia = alergiaDAOImpl.getById(Long.valueOf(idStr));

        request.setAttribute("alergia", alergia);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaAlergias.jsp");
        dispatcher.forward(request, response);
    }


}