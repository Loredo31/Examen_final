package mx.utng.Loredo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.Loredo.model.dao.IClaseVirtualDao;

import mx.utng.Loredo.model.entity.ClaseVirtual;

@Service
public class ClaseVirtualServiceImpl implements IClaseVirtualService{
   @Autowired
    private IClaseVirtualDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<ClaseVirtual> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ClaseVirtual claseVirtual) {
        dao.save(claseVirtual);
    }

    @Transactional(readOnly = true)
    @Override
    public ClaseVirtual getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    } 
}
