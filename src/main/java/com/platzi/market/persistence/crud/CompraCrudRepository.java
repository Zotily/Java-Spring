package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entities.Compra;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(String idCliente);

//    List<Compra> findByIdClienteOrderByIdCompraAsc(int idCliente);
//    List<Compra> findByFecha(LocalDateTime fecha);
//    List<Compra> findByFechaAndIdClienteOrderByIdCliente(LocalDateTime fecha, int idCliente);
//    List<Compra> findByFechaAndIdClienteAndMedioPagoOrderByFechaAsc(LocalDateTime fecha, int idCLiente, String medioPago);
}
