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

    public List<Libro> getLibros(String isbn, Integer fechaPublicacion, String autor) {
        List<Libro> listaOriginal = repository.obtenerLibros();
        List<Libro> listafiltrada = listaOriginal;
        if (isbn != null) {
            listafiltrada = listaOriginal.stream().filter(l -> l.getIsbn().equals(isbn)).toList();
        }
        if (fechaPublicacion != null) {
            listafiltrada = listafiltrada.stream().filter(l -> l.getFechaPublicacion() == fechaPublicacion).toList();
        }
        if (autor != null) {
            listafiltrada = listafiltrada.stream().filter(l -> l.getAutor().equals(autor)).toList();
        }
        return listafiltrada;
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
        repository.eliminar(id);
        return "libro eliminado";
    }

}
