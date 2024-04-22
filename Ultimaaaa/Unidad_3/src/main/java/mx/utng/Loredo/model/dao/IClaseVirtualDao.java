package mx.utng.Loredo.model.dao;

import java.util.List;
import mx.utng.Loredo.model.entity.ClaseVirtual;

public interface IClaseVirtualDao {
    List<ClaseVirtual> list();
    void save(ClaseVirtual claseVirtual);
    ClaseVirtual getById(Long id);
    void delete(Long id);
}
