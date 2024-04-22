package mx.utng.Loredo.model.dao;

import java.util.List;
import mx.utng.Loredo.model.entity.PedidoOnline;

public interface IPedidoOnlineDao {
    List<PedidoOnline> list();
    void save(PedidoOnline pedidoOnline);
    PedidoOnline getById(Long id);
    void delete(Long id);
}
