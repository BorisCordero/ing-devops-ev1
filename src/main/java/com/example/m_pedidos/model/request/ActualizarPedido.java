package com.example.m_pedidos.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ActualizarPedido {

    @NotBlank
    private String nombre_producto;

    @NotNull
    @Positive
    private int cantidad_producto;

    @NotBlank
    private String estado_pedido;

    @NotNull
    @Positive
    private double total;

}
