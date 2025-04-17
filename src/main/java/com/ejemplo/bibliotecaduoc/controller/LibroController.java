package com.ejemplo.bibliotecaduoc.controller;

import com.ejemplo.bibliotecaduoc.model.Libro;
import com.ejemplo.bibliotecaduoc.services.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {
    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return service.getLibros();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {
        return service.saveLibro(libro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable int id) {
        Libro libro = service.getLibroId(id);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro) {
        libro.setId(id);
        return service.updateLibro(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable int id) {
        service.deleteLibro(id);
    }
}
