package mx.utng.Loredo.model.service;

import java.util.List;
import mx.utng.Loredo.model.entity.PedidoOnline;

public interface IPedidoOnlineService {
    List<PedidoOnline> list();
    void save(PedidoOnline pedidoOnline);
    PedidoOnline getById(Long id);
    void delete(Long id);
}