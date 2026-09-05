package com.example.m_pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.m_pedidos.model.entities.Pedido;
import com.example.m_pedidos.model.request.ActualizarPedido;
import com.example.m_pedidos.model.request.AgregarPedido;
import com.example.m_pedidos.service.PedidoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("pedidos")
@RestController
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("")
    public List<Pedido> obtenerPedidos() {
        return pedidoService.obtenerPedidos();
    }
    
    @GetMapping("/{idPedido}")
    public Pedido getMethodName(@PathVariable int idPedido) {
        return pedidoService.obtenerPedidoPorId(idPedido);
    }
    
    @PostMapping("")
    public Pedido agregarPedido(@RequestBody AgregarPedido pedidoParaAgregar) {
        return pedidoService.agregarPedido(pedidoParaAgregar);
    }
    
    @PutMapping("/{id}")
    public Pedido actualizarPedido(
            @PathVariable Integer id,
            @RequestBody @Valid ActualizarPedido pedidoActualizado) {
        return pedidoService.actualizarPedido(id, pedidoActualizado);
    }

    @DeleteMapping("/{idPedido}")
    public String eliminarPedido(@PathVariable int idPedido){
        return pedidoService.eliminarPedido(idPedido);
        
    }
    

}
