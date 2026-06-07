package com.upiiz.ajax.Controllers;

import com.upiiz.ajax.Entities.CategoriaEntity;
import com.upiiz.ajax.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    //LEER
    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> listadoCategoriasAJAX() {
        return ResponseEntity.ok(categoriaService.listadoCategorias());
    }

    //LEER POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriaEntity>> categoriaByIdAJAX(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.categoriaPorId(id));
    }

    //CREAR
    @PostMapping
    public ResponseEntity<CategoriaEntity> crearCategoriaAJAX(@RequestBody CategoriaEntity categoria) {
        return ResponseEntity.ok(categoriaService.agregarCategoria(categoria));
    }

    //ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaEntity> actualizarCategoriaAJAX(@PathVariable Long id, @RequestBody CategoriaEntity categoria) {
        return ResponseEntity.ok(categoriaService.actualizarCategoria(id, categoria));
    }

    //BORRAR
    @DeleteMapping("/{id}")
    public void eliminarCategoriaAJAX(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
    }
}