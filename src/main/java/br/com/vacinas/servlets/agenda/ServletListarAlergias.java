package br.com.vacinas.servlets.agenda;

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
import java.util.List;

@WebServlet("/listarAlergias")
public class ServletListarAlergias extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        AlergiaDAOImpl dao = new AlergiaDAOImpl(connection);
        List<Alergia> alergias = dao.findAll();

        request.setAttribute("alergias", alergias);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-alergias.jsp");
        dispatcher.forward(request, response);

    }


}
