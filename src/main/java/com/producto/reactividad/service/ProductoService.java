package com.producto.reactividad.service;

import com.producto.reactividad.model.Producto;
import com.producto.reactividad.repository.ProductoRepository;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;

@ApplicationScoped
public class ProductoService {

    @Inject
    ProductoRepository repository;

    // Listar todos los productos
    public Multi<Producto> listar() {
        return repository.streamAll();
    }

    // Buscar producto por ID
    public Uni<Producto> buscar(String id) {
        return repository.findById(new ObjectId(id));
    }

    // Crear producto
    public Uni<Producto> crear(Producto producto) {
        return repository.persist(producto).replaceWith(producto);
    }

    // Actualizar producto
    public Uni<Producto> actualizar(String id, Producto producto) {
        return repository.findById(new ObjectId(id))
                .onItem().ifNotNull().transformToUni(p -> {
                    p.nombre = producto.nombre;
                    p.precio = producto.precio;
                    p.stock = producto.stock;
                    return repository.update(p).replaceWith(p);
                });
    }

    // Eliminar producto
    public Uni<Boolean> eliminar(String id) {
        return repository.deleteById(new ObjectId(id));
    }
}
