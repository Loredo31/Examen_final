package mx.utng.Loredo.model.service;

import java.util.List;
import mx.utng.Loredo.model.entity.ProgramaLealtad;

public interface IProgramaLealtadService {
    List<ProgramaLealtad> list();
    void save(ProgramaLealtad programaLealtad);
    ProgramaLealtad getById(Long id);
    void delete(Long id);
}