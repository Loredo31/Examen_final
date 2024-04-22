package mx.utng.Loredo.model.dao;

import java.util.List;

import mx.utng.Loredo.model.entity.Student;;

public interface IStudentDao {
    List<Student> list();
    void save(Student student);
    Student getById(Long id);
    void delete(Long id);
    
} 
