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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/adicionarUsuario")
public class ServletCriarUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adicionar-usuario.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl(connection);

        String nome = request.getParameter("nome");
        String data_nascimentoStr = request.getParameter("data_nascimento");
        String sexo = request.getParameter("sexo");
        String logradouro = request.getParameter("logradouro");
        String numeroStr = request.getParameter("numero");
        String setor = request.getParameter("setor");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");

        LocalDate data_nascimento = LocalDate.parse(data_nascimentoStr,  DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Integer numero = Integer.parseInt(numeroStr);

        Usuario usuario = new Usuario(null, nome, data_nascimento, sexo, logradouro, numero, setor, cidade, uf);

        usuarioDAOImpl.save(usuario);

        response.sendRedirect("listarUsuarios");
    }


}
