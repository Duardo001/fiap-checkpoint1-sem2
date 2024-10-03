package br.com.fiap.ecommerce.dtos.PedidoDtos;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.model.Pedido;

public class PedidoRequestUpdateDto {

    private String status;
    private LocalDate dataPedido;

    private static final ModelMapper modelMapper = new ModelMapper();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Pedido toModel(Long id) {
        Pedido pedido = modelMapper.map(this, Pedido.class);
        pedido.setId(id);
        pedido.setStatus(this.status);
        pedido.setDataPedido(this.dataPedido);
        return pedido;
    }
}
