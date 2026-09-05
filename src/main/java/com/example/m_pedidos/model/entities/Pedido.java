package com.example.m_pedidos.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;

    @Column(nullable = false)
    private String nombre_producto;

    @Column(nullable = false)
    private int cantidad_producto;

    @Column(nullable = false)
    private String estado_pedido;

    @Column(nullable = false)
    private double total;

}
