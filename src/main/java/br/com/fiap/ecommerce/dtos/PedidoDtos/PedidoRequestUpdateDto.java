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
		Pedido result = modelMapper.map(this, Pedido.class);
        result.setId(id);
        return result;
    }  
}
