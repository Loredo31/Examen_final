package mx.utng.Loredo.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.Loredo.model.entity.ProgramaLealtad;

@Repository
public class ProgramaLealtadDaoImpl implements IProgramaLealtadDao{
    
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<ProgramaLealtad> list() {
        return em.createQuery("from ProgramaLealtad").getResultList();
    }

    @Override
    public void save(ProgramaLealtad programaLealtad) {
        if(programaLealtad.getId() != null && programaLealtad.getId() >0){
            em.merge(programaLealtad);
        }else{
            em.persist(programaLealtad);
        }
    }

    @Override
    public ProgramaLealtad getById(Long id) {
        return em.find(ProgramaLealtad.class, id);
    }

    @Override
    public void delete(Long id) {
        ProgramaLealtad programaLealtad = getById(id);
        em.remove(programaLealtad);
    }
}
