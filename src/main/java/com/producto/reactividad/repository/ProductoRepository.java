package com.producto.reactividad.repository;

import com.producto.reactividad.model.Producto;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductoRepository implements ReactivePanacheMongoRepository<Producto> {
}
