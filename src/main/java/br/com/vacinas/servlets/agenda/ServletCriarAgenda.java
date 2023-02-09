package br.com.vacinas.servlets.agenda;

import br.com.vacinas.dao.impl.AgendaDAOImpl;
import br.com.vacinas.dao.impl.UsuarioDAOImpl;
import br.com.vacinas.dao.impl.VacinaDAOImpl;
import br.com.vacinas.config.ConnectionFactory;
import br.com.vacinas.model.Agenda;
import br.com.vacinas.model.enums.SituacaoEnum;
import br.com.vacinas.model.Usuario;
import br.com.vacinas.model.Vacina;

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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet("/addAgenda")
public class ServletCriarAgenda extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        UsuarioDAOImpl dao = new UsuarioDAOImpl(connection);
        VacinaDAOImpl vacinaDAOImpl = new VacinaDAOImpl(connection);

        List<Usuario> usuarios = dao.findAll();
        List<Vacina> vacinas = vacinaDAOImpl.findAll();

        request.setAttribute("usuarios", usuarios);
        request.setAttribute("vacinas", vacinas);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addAgenda.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        AgendaDAOImpl agendaDAOImpl = new AgendaDAOImpl(connection);
        VacinaDAOImpl vacinaDAOImpl = new VacinaDAOImpl(connection);

        String dataStr = request.getParameter("data");
        String hora = request.getParameter("hora");
        String situacaoStr = request.getParameter("situacaoEnum");
        String observacoes = request.getParameter("observacoes");
        String vacina_id = request.getParameter("vacina_id");
        String usuario_id = request.getParameter("usuario_id");

        SituacaoEnum situacaoEnum = SituacaoEnum.valueOf(situacaoStr);
        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Vacina vacina = vacinaDAOImpl.getById(Long.parseLong(vacina_id));

        Agenda agenda = new Agenda(null, data, hora, situacaoEnum, null, observacoes);
        agendaDAOImpl.save(agenda);

        agendaDAOImpl.saveAgendaUsuario(Long.parseLong(usuario_id), agendaDAOImpl.getAgendaInserida());
        agendaDAOImpl.salvaVacinaAgendada(Long.parseLong(vacina_id), agendaDAOImpl.getAgendaInserida());

        for (Integer i = 1; i <= vacina.getDoses() - 1; i++) {

            Date novaData = this.convertToDateViaSqlDate(data);

            novaData = this.calcularData(vacina.getPeriodicidade(), vacina.getIntervalo(), novaData);

            data = this.convertToLocalDateViaSqlDate(novaData);

            agenda = new Agenda(null, data, hora, situacaoEnum, null, observacoes);
            agendaDAOImpl.save(agenda);

            agendaDAOImpl.saveAgendaUsuario(Long.parseLong(usuario_id), agendaDAOImpl.getAgendaInserida());
            agendaDAOImpl.salvaVacinaAgendada(Long.parseLong(vacina_id), agendaDAOImpl.getAgendaInserida());
        }

        response.sendRedirect("listaAgenda");
    }

    protected Date calcularData(Integer periodicidade, Integer intervalo, Date data) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);

        if (periodicidade == 1) {
            calendar.add(Calendar.DAY_OF_MONTH, intervalo);
            data = calendar.getTime();
        }

        if (periodicidade == 2) {
            calendar.add(Calendar.DAY_OF_WEEK, intervalo);
            data = calendar.getTime();
        }

        if (periodicidade == 3) {
            calendar.add(Calendar.MONTH, intervalo);
            data = calendar.getTime();
        }

        if (periodicidade == 4) {
            calendar.add(Calendar.YEAR, intervalo);
            data = calendar.getTime();
        }

        return data;
    }

    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

}