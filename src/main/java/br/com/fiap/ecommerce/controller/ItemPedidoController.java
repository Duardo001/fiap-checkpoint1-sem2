package br.com.fiap.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ecommerce.dtos.ItemPedidoDtos.ItemPedidoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ItemPedidoDtos.ItemPedidoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ItemPedidoDtos.ItemPedidoResponseDto;
import br.com.fiap.ecommerce.model.ItemPedido;
import br.com.fiap.ecommerce.service.ItemPedidoService;

@RestController
@RequestMapping("/itenspedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDto>> list() {
        List<ItemPedidoResponseDto> dtos = itemPedidoService.list()
                .stream()
                .map(e -> new ItemPedidoResponseDto().toDto(e))
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ItemPedidoResponseDto> create(@RequestBody ItemPedidoRequestCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        new ItemPedidoResponseDto().toDto(
                                itemPedidoService.save(dto.toModel())));
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemPedidoResponseDto> update(
            @PathVariable Long id,
            @RequestBody ItemPedidoRequestUpdateDto dto) {
        if (!itemPedidoService.existsById(id)) {
            throw new RuntimeException("Id inexistente");
        }
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(id);
        itemPedido.setQuantidade(dto.getQuantidade());
        itemPedido.setValorTotal(dto.getValorTotal());
        ItemPedido atualizaItemPedido = itemPedidoService.update(itemPedido);

        return ResponseEntity.ok()
                .body(new ItemPedidoResponseDto().toDto(atualizaItemPedido));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!itemPedidoService.existsById(id)) {
            throw new RuntimeException("Id inexistente");
        }
        itemPedidoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemPedidoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(
                        itemPedidoService
                                .findById(id)
                                .map(e -> new ItemPedidoResponseDto().toDto(e))
                                .orElseThrow(() -> new RuntimeException("Id inexistente")));
    }

}
