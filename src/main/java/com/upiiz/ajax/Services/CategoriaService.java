package com.upiiz.ajax.Services;

import com.upiiz.ajax.Entities.CategoriaEntity;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<CategoriaEntity> listadoCategorias();
    Optional<CategoriaEntity> categoriaPorId(Long id);
    CategoriaEntity agregarCategoria(CategoriaEntity categoria);
    CategoriaEntity actualizarCategoria(Long id, CategoriaEntity categoria);
    void eliminarCategoria(Long id);
}