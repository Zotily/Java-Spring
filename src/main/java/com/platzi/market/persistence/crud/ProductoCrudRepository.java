package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository <Producto, Long> {

    /* MANERA NATIVA */
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)

    /* MANERA CON QUERY METHODS */
    List<Producto> findByIdCategoriaOrderByNombreAsc(long idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(long cantidadStock, boolean estado);
}
