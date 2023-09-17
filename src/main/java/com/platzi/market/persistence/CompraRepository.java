package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.CompraCrudRepository;
import com.platzi.market.persistence.entities.Compra;

import java.time.LocalDateTime;
import java.util.List;

public class CompraRepository {

    public CompraCrudRepository compraCrudRepository;

    // OBTENER TODAS LAS COMPRAS DE UN CLIENTE
    public List<Compra> getByIdCliente(long idCliente){
        return compraCrudRepository.findByIdClienteOrderByIdCompraAsc(idCliente);
    }

    // OBTENER TODAS LAS VENTAS DE UNA FECHA
    public List<Compra> getByFechaCompra(LocalDateTime fecha){
        return compraCrudRepository.findByFecha(fecha);
    }

    // OBTENER TODAS LAS VENTAS DE UN CLIENTE DE UNA FECHA
    public List<Compra> getByFechaCompra(LocalDateTime fecha, long idCliente){
        return compraCrudRepository.findByFechaAndIdClienteOrderByIdCliente(fecha, idCliente);
    }

    // OBTENER TODAS LAS VENTAS DE UN CLIENTE DE UNA FECHA CON UN DETERMINADO TIPO DE PAGO
    public List<Compra> getByFechaCompra(LocalDateTime fecha, long idCliente, String medioPago){
        return compraCrudRepository.findByFechaAndIdClienteAndMedioPagoOrderByFechaAsc(fecha, idCliente, medioPago);
    }
}
