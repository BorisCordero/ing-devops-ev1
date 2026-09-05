package com.example.m_pedidos.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PedidoCreacionTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void debeResponder201AlCrearPedido() throws Exception {

        String pedido = """
                {
                    "nombre_producto": "Teclado",
                    "cantidad_producto": 2,
                    "estado_pedido": "PENDIENTE",
                    "total": 29990
                }
                """;

        mockMvc.perform(post("/pedidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pedido))
                .andExpect(status().isCreated());
    }
}