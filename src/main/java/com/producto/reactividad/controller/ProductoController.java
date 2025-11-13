package com.producto.reactividad.controller;

import com.producto.reactividad.model.Producto;
import com.producto.reactividad.service.ProductoService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/producto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON) // ✅ importante
public class ProductoController {
    @Inject
    ProductoService service;

    // ✅ Listar todos los productos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Listar todos los productos", description = "Obtiene la lista completa de productos desde MongoDB.")
    public Multi<Producto> listar() {
        return service.listar();
    }

    // ✅ Buscar producto por ID
    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar producto por ID", description = "Devuelve un producto según su ID.")
    public Uni<Producto> buscar(@PathParam("id") String id) {
        return service.buscar(id);
    }

    // ✅ Crear producto
    @POST
    @Operation(summary = "Crear producto", description = "Registra un nuevo producto en la base de datos.")
    public Uni<Producto> crear(Producto producto) {
        return service.crear(producto);
    }

    // ✅ Actualizar producto
    @PUT
    @Path("/{id}")
    @Operation(summary = "Actualizar producto", description = "Actualiza los datos de un producto existente por su ID.")
    public Uni<Producto> actualizar(@PathParam("id") String id, Producto producto) {
        return service.actualizar(id, producto);
    }

    // ✅ Eliminar producto
    @DELETE
    @Path("/{id}")
    @Operation(summary = "Eliminar producto", description = "Elimina un producto existente por su ID.")
    public Uni<Boolean> eliminar(@PathParam("id") String id) {
        return service.eliminar(id);
    }
}
