package mx.utng.Loredo.model.service;

import java.util.List;
import mx.utng.Loredo.model.entity.ClaseVirtual;

public interface IClaseVirtualService {
    List<ClaseVirtual> list();
    void save(ClaseVirtual claseVirtual);
    ClaseVirtual getById(Long id);
    void delete(Long id);
}