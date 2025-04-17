package com.ejemplo.bibliotecaduoc.services;

import com.ejemplo.bibliotecaduoc.model.Libro;
import com.ejemplo.bibliotecaduoc.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public List<Libro> getLibros() {
        return repository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro) {
        return repository.guardar(libro);
    }

    public Libro getLibroId(int id) {
        return repository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro) {
        return repository.actualizar(libro);
    }

    public String deleteLibro(int id) {
        Libro libro = repository.buscarPorId(id);
        return "libro eliminado: " + libro.toString();
    }

}
