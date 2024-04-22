package mx.utng.Loredo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.Loredo.model.dao.IProgramaLealtadDao;

import mx.utng.Loredo.model.entity.ProgramaLealtad;

@Service
public class ProgramaLealtadServiceImpl implements IProgramaLealtadService{
   @Autowired
    private IProgramaLealtadDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<ProgramaLealtad> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ProgramaLealtad programaLealtad) {
        dao.save(programaLealtad);
    }

    @Transactional(readOnly = true)
    @Override
    public ProgramaLealtad getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    } 
}
