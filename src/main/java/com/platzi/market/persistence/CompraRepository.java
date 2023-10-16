package com.platzi.market.persistence;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PurchaseRepository;
import com.platzi.market.persistence.crud.CompraCrudRepository;
import com.platzi.market.persistence.entities.Compra;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }

    // OBTENER TODAS LAS COMPRAS DE UN CLIENTE
//    public List<Compra> getByIdCliente(int idCliente){
//        return compraCrudRepository.findByIdClienteOrderByIdCompraAsc(idCliente);
//    }
//
//    // OBTENER TODAS LAS VENTAS DE UNA FECHA
//    public List<Compra> getByFechaCompra(LocalDateTime fecha){
//        return compraCrudRepository.findByFecha(fecha);
//    }
//
//    // OBTENER TODAS LAS VENTAS DE UN CLIENTE DE UNA FECHA
//    public List<Compra> getByFechaCompra(LocalDateTime fecha, int idCliente){
//        return compraCrudRepository.findByFechaAndIdClienteOrderByIdCliente(fecha, idCliente);
//    }
//
//    // OBTENER TODAS LAS VENTAS DE UN CLIENTE DE UNA FECHA CON UN DETERMINADO TIPO DE PAGO
//    public List<Compra> getByFechaCompra(LocalDateTime fecha, int idCliente, String medioPago){
//        return compraCrudRepository.findByFechaAndIdClienteAndMedioPagoOrderByFechaAsc(fecha, idCliente, medioPago);
//    }
}
