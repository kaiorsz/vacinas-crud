package br.com.vacinas.servlets.usuario;

import br.com.vacinas.dao.impl.AlergiaUsuarioDAOImpl;
import br.com.vacinas.dao.impl.UsuarioDAOImpl;
import br.com.vacinas.config.ConnectionFactory;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/listarUsuarios")
public class ServletListarUsuarios extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        UsuarioDAOImpl dao = new UsuarioDAOImpl(connection);
        AlergiaUsuarioDAOImpl alergiaUsuarioDaoImpl = new AlergiaUsuarioDAOImpl(connection);

        List<Usuario> usuarios = dao.findAll();
        List<AlergiaUsuario> listaAlergias = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            List<AlergiaUsuario> result = alergiaUsuarioDaoImpl.getAlergiasByUsuarioId(usuario.getId());
            listaAlergias.addAll(result);
        }

        request.setAttribute("listaAlergias", listaAlergias);
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-usuarios.jsp");
        dispatcher.forward(request, response);

    }


}
