package br.com.vacinas.dao.interfaces;
import br.com.vacinas.model.AlergiaUsuario;

import java.util.List;


public interface AlergiaUsuarioDAO {

    AlergiaUsuario saveAlergiasUsuario(AlergiaUsuario alergiaUsuario);

    List<AlergiaUsuario> getAlergiasByUsuarioId(Long id);
}