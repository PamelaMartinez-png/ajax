package com.upiiz.ajax.Services;

import com.upiiz.ajax.Entities.CategoriaEntity;
import com.upiiz.ajax.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> listadoCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<CategoriaEntity> categoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public CategoriaEntity agregarCategoria(CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public CategoriaEntity actualizarCategoria(Long id, CategoriaEntity categoria) {
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}