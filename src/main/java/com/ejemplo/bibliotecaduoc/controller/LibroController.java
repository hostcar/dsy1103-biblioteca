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
    public ResponseEntity<List<Libro>> listarLibros(
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) Integer fechaPublicacion,
            @RequestParam(required = false) String autor
    ) {
        List<Libro> listaLibros = service.getLibros(isbn, fechaPublicacion, autor);
        if (listaLibros == null || listaLibros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaLibros);
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

    @GetMapping("/total")
    public int totalLibros() {
        return 10;
    }
}
