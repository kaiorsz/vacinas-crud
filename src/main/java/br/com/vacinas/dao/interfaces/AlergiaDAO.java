package br.com.vacinas.dao.interfaces;

import br.com.vacinas.model.Alergia;

import java.util.List;

public interface AlergiaDAO {

    Alergia save(Alergia alergia);

    void delete(Long id);

    List<Alergia> findAll();

    Alergia getById(Long id);
}
