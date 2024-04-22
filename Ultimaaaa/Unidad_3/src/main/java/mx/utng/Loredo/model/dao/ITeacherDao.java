package mx.utng.Loredo.model.dao;

import java.util.List;

import mx.utng.Loredo.model.entity.Teacher;

public interface ITeacherDao {
    List<Teacher> list();
    void save(Teacher teacher);
    Teacher getById(Long id);
    void delete(Long id);
}
