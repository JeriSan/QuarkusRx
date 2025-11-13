package com.producto.reactividad.model;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import org.bson.types.ObjectId;

public class Producto extends ReactivePanacheMongoEntity {
    public String nombre;
    public Double precio;
    public Integer stock;
}
