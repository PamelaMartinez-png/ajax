package com.upiiz.ajax.Services;

import com.upiiz.ajax.Entities.ProductoEntity;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    //metodos - menu
    List<ProductoEntity> listado();
    Optional<ProductoEntity> productoPorId (Long id);
    ProductoEntity agregarProducto (ProductoEntity producto);
    ProductoEntity actualizarProducto(Long id,ProductoEntity producto);
    void eliminarProducto (Long id);

}
