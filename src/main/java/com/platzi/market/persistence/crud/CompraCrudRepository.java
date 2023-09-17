package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entities.Compra;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CompraCrudRepository extends CrudRepository<Compra, Long> {

    List<Compra> findByIdClienteOrderByIdCompraAsc(long idCliente);
    List<Compra> findByFecha(LocalDateTime fecha);
    List<Compra> findByFechaAndIdClienteOrderByIdCliente(LocalDateTime fecha, long idCliente);
    List<Compra> findByFechaAndIdClienteAndMedioPagoOrderByFechaAsc(LocalDateTime fecha, long idCLiente, String medioPago);
}
