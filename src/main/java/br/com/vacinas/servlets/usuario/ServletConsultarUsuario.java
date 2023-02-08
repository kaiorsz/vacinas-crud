package br.com.vacinas.servlets.usuario;

import br.com.vacinas.dao.impl.UsuarioDAOImpl;
import br.com.vacinas.config.ConnectionFactory;
import br.com.vacinas.model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/consultarUsuario")
public class ServletConsultarUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl(connection);

        Usuario usuario = usuarioDAOImpl.getById(Long.valueOf(idStr));

        request.setAttribute("usuario", usuario);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/consultar-usuario.jsp");
        dispatcher.forward(request, response);

    }


}