package com.example.m_pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.m_pedidos.model.entities.Pedido;
import com.example.m_pedidos.model.request.ActualizarPedido;
import com.example.m_pedidos.model.request.AgregarPedido;
import com.example.m_pedidos.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido obtenerPedidoPorId(Integer id_pedido) {
        Pedido pedido = pedidoRepository.findById(id_pedido).orElse(null);
        if (pedido == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Pedido no encontrado.");
        }
        return pedido;
    }

    public Pedido agregarPedido(AgregarPedido pedidoParaAgregar){
        Pedido pedidoNuevo = new Pedido();
        pedidoNuevo.setNombre_producto(pedidoParaAgregar.getNombre_producto());
        pedidoNuevo.setCantidad_producto(pedidoParaAgregar.getCantidad_producto());
        pedidoNuevo.setEstado_pedido(pedidoParaAgregar.getEstado_pedido());
        pedidoNuevo.setTotal(pedidoParaAgregar.getTotal());
        return pedidoRepository.save(pedidoNuevo);
    }

    public String eliminarPedido(int id_pedido){
        if (pedidoRepository.existsById(id_pedido)){
            pedidoRepository.deleteById(id_pedido);
            return "Pedido eliminado.";            
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Pedido no encontrado.");
        }
    }

    public Pedido actualizarPedido(int id_pedido, ActualizarPedido pedidoParaActualizar){
        Pedido pedido = pedidoRepository.findById(id_pedido).orElse(null);
        if (pedido == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Pedido no encontrado.");
    }else{
        pedido.setNombre_producto(pedidoParaActualizar.getNombre_producto());
        pedido.setCantidad_producto(pedidoParaActualizar.getCantidad_producto());
        pedido.setEstado_pedido(pedidoParaActualizar.getEstado_pedido());
        pedido.setTotal(pedidoParaActualizar.getTotal());
        return pedidoRepository.save(pedido);
        }
    }

}