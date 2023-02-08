package br.com.vacinas.dao.interfaces;

import br.com.vacinas.model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    Usuario save(Usuario user);
    void delete(Long id);
    List<Usuario> findAll();
    Usuario getById(Long id);

}
