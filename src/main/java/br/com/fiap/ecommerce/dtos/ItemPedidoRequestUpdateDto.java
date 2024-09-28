package br.com.fiap.ecommerce.dtos;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.model.ItemPedido;
import br.com.fiap.ecommerce.model.Produto;

public class ItemPedidoRequestUpdateDto {
    
     private Long id_pedido;
    private Long id_produto;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;
    private static final ModelMapper modelMapper = new ModelMapper();

    public Long getId_pedido() {
        return id_pedido;
    }
    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }
    public Long getId_produto() {
        return id_produto;
    }
    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }
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
        ItemPedido result = modelMapper.map(this, ItemPedido.class);
        result.setId(id);
        return result;
    }   

}   
