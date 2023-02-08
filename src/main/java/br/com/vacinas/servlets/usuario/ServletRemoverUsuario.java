package br.com.vacinas.servlets.usuario;

import br.com.vacinas.dao.impl.UsuarioDAOImpl;
import br.com.vacinas.config.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/removerUsuario")
public class ServletRemoverUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl(connection);

        usuarioDAOImpl.delete(Long.valueOf(idStr));

        response.sendRedirect("listarUsuarios");

    }

}
