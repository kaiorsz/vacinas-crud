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

@WebServlet("/adicionarAlergia")
public class ServletCriarAlergia extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adicionar-alergia.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        AlergiaDAOImpl alergiaDAOImpl = new AlergiaDAOImpl(connection);

        String nome = request.getParameter("nome");

        Alergia alergia = new Alergia(null, nome);

        alergiaDAOImpl.save(alergia);

        response.sendRedirect("listarAlergias");


    }

}
