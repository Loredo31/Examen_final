package mx.utng.Loredo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.Loredo.model.dao.IPedidoOnlineDao;

import mx.utng.Loredo.model.entity.PedidoOnline;

@Service
public class PedidoOnlineServiceImpl implements IPedidoOnlineService{
   @Autowired
    private IPedidoOnlineDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<PedidoOnline> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(PedidoOnline pedidoOnline) {
        dao.save(pedidoOnline);
    }

    @Transactional(readOnly = true)
    @Override
    public PedidoOnline getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    } 
}
