package br.com.vacinas.dao.interfaces;

import br.com.vacinas.model.Vacina;

import java.util.List;

public interface VacinaDAO {

    Vacina save(Vacina vacina);
    void delete(Long id);
    List<Vacina> findAll();
    Vacina getById(Long id);
}
