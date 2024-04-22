package mx.utng.Loredo.model.dao;

import java.util.List;
import mx.utng.Loredo.model.entity.ProgramaLealtad;

public interface IProgramaLealtadDao {
    List<ProgramaLealtad> list();
    void save(ProgramaLealtad programaLealtad);
    ProgramaLealtad getById(Long id);
    void delete(Long id);
}
