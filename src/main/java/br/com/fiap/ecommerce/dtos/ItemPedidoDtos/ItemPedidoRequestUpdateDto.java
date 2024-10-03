package br.com.fiap.ecommerce.dtos.ItemPedidoDtos;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import br.com.fiap.ecommerce.model.ItemPedido;

public class ItemPedidoRequestUpdateDto {

    private BigDecimal quantidade;
    private BigDecimal valorTotal;
    private static final ModelMapper modelMapper = new ModelMapper();


    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ItemPedido toModel(Long id) {
        ItemPedido itemPedido = modelMapper.map(this, ItemPedido.class);
        itemPedido.setId(id);
        itemPedido.setQuantidade(this.quantidade);
        itemPedido.setValorTotal(this.valorTotal);
        return itemPedido;
    }

    // static {
    //     modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    //     modelMapper.typeMap(ItemPedidoRequestUpdateDto.class, ItemPedido.class).addMappings(mapper -> {
    //         mapper.map(ItemPedidoRequestUpdateDto::getIdPedido, ItemPedido::setIdPedido);
    //         mapper.map(ItemPedidoRequestUpdateDto::getIdProduto, ItemPedido::setIdProduto);
    //         mapper.map(ItemPedidoRequestUpdateDto::getQuantidade, ItemPedido::setQuantidade);
    //         mapper.map(ItemPedidoRequestUpdateDto::getValorTotal, ItemPedido::setValorTotal);
    //     });
    // }
    

}
