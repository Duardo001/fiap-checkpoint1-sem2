package br.com.fiap.ecommerce.dtos.PedidoDtos;


import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.model.Pedido;

public class PedidoRequestUpdateDto {

    private String status;

    private static final ModelMapper modelMapper = new ModelMapper();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pedido toModel(Long id) {
        Pedido pedido = modelMapper.map(this, Pedido.class);
        pedido.setId(id);
        pedido.setStatus(this.status);
        return pedido;
    }
}
