package br.com.vacinas.servlets.alergia;

import br.com.vacinas.dao.impl.AlergiaDAOImpl;
import br.com.vacinas.dao.impl.AlergiaUsuarioDAOImpl;
import br.com.vacinas.dao.impl.UsuarioDAOImpl;
import br.com.vacinas.config.ConnectionFactory;
import br.com.vacinas.model.Alergia;
import br.com.vacinas.model.AlergiaUsuario;
import br.com.vacinas.model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/adicionarAlergiasUsuario")
public class ServletCriarAlergiasUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Connection connection = ConnectionFactory.getConnection();

            AlergiaDAOImpl dao = new AlergiaDAOImpl(connection);
            List<Alergia> alergias = dao.findAll();

            request.setAttribute("alergias", alergias);


            String idStr = request.getParameter("id");

            UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl(connection);
            Usuario usuario = usuarioDAOImpl.getById(Long.valueOf(idStr));

            request.setAttribute("usuario", usuario);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/adicionar-alergias-usuario.jsp");
            dispatcher.forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        AlergiaUsuarioDAOImpl dao = new AlergiaUsuarioDAOImpl(connection);

        String id_alergia = request.getParameter("alergia");
        String id_usuario = request.getParameter("usuario");

        AlergiaUsuario alergiaUsuario = new AlergiaUsuario(Long.valueOf(id_alergia), Long.valueOf(id_usuario), "");

        dao.saveAlergiasUsuario(alergiaUsuario);

        response.sendRedirect("listarUsuarios");

    }


}
