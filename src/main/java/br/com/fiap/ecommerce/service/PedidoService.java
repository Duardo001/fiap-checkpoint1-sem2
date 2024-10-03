package br.com.fiap.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ecommerce.model.Pedido;
import br.com.fiap.ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> list() {
        return pedidoRepository.findAll();
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public boolean existsById(long id) {
        return pedidoRepository.existsById(id);
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    // public Pedido update(Pedido pedido) {
    //     Optional<Pedido> itemOpcional = pedidoRepository.findById(pedido.getId());
    //     if (itemOpcional.isPresent()) {
    //         Pedido pedidoExistente = itemOpcional.get();
    //         pedidoExistente.setStatus(pedido.getStatus());
    //         pedidoExistente.setDataPedido(pedido.getDataPedido());
    //         return pedidoRepository.save(pedidoExistente);
    //     } else {
    //         throw new RuntimeException("Id não encontrado");
    //     }
    // }
}
