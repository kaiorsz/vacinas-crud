package br.com.vacinas.servlets.vacina;

import br.com.vacinas.dao.impl.VacinaDAOImpl;
import br.com.vacinas.config.ConnectionFactory;
import br.com.vacinas.model.Vacina;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addVacina")
public class ServletCriarVacina extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addVacina.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        VacinaDAOImpl vacinaDAOImpl = new VacinaDAOImpl(connection);

        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        String dosesStr = request.getParameter("doses");
        String periodicidadeStr = request.getParameter("periodicidade");
        String intervaloStr = request.getParameter("intervalo");

        Integer doses = Integer.parseInt(dosesStr);
        Integer periodicidade = Integer.parseInt(periodicidadeStr);
        Integer intervalo = Integer.parseInt(intervaloStr);

        if (doses < 1) {
            periodicidade = null;
        }

        Vacina vacina = new Vacina(null, titulo, descricao, doses, periodicidade, intervalo);

        vacinaDAOImpl.save(vacina);

        response.sendRedirect("listaVacinas");
    }
}