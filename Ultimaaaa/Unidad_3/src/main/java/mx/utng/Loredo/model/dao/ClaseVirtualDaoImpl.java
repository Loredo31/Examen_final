package mx.utng.Loredo.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.Loredo.model.entity.ClaseVirtual;

@Repository
public class ClaseVirtualDaoImpl implements IClaseVirtualDao{
    
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<ClaseVirtual> list() {
        return em.createQuery("from ClaseVirtual").getResultList();
    }

    @Override
    public void save(ClaseVirtual claseVirtual) {
        if(claseVirtual.getId() != null && claseVirtual.getId() >0){
            em.merge(claseVirtual);
        }else{
            em.persist(claseVirtual);
        }
    }

    @Override
    public ClaseVirtual getById(Long id) {
        return em.find(ClaseVirtual.class, id);
    }

    @Override
    public void delete(Long id) {
        ClaseVirtual claseVirtual = getById(id);
        em.remove(claseVirtual);
    }
}
