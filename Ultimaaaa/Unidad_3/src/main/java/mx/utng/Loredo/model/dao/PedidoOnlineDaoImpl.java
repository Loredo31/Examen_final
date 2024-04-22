package mx.utng.Loredo.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.Loredo.model.entity.PedidoOnline;

@Repository
public class PedidoOnlineDaoImpl implements IPedidoOnlineDao{
    
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<PedidoOnline> list() {
        return em.createQuery("from PedidoOnline").getResultList();
    }

    @Override
    public void save(PedidoOnline pedidoOnline) {
        if(pedidoOnline.getId() != null && pedidoOnline.getId() >0){
            em.merge(pedidoOnline);
        }else{
            em.persist(pedidoOnline);
        }
    }

    @Override
    public PedidoOnline getById(Long id) {
        return em.find(PedidoOnline.class, id);
    }

    @Override
    public void delete(Long id) {
        PedidoOnline pedidoOnline = getById(id);
        em.remove(pedidoOnline);
    }
}
