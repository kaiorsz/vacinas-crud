package br.com.vacinas.dao.interfaces;

import br.com.vacinas.model.Agenda;

import java.util.List;


public interface AgendaDAO {

    Agenda save(Agenda agenda);
    void delete(Long id);
    List<Agenda> findAll();
    Agenda getById(Long id);

    Agenda update(Agenda agenda);

    void saveAgendaUsuario(Long id_usuario, Long id_agenda);

    Long getAgendaInserida();

    Long getAgendaUsuario(Long id_agenda);

    Long getVacinaAgenda(Long id_agenda);

    void saveVacinaAgenda(Long id_vacina, Long id_agenda);
}
