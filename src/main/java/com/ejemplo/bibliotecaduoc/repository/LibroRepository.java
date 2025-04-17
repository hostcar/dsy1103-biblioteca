package com.ejemplo.bibliotecaduoc.repository;

import com.ejemplo.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {
    private final List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public Libro guardar(Libro libro) {
        listaLibros.add(libro);
        return libro;
    }

    public Libro actualizar(Libro libro) {
        Integer id = null;
        int posicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == libro.getId()) {
                id = libro.getId();
                posicion = i;
                break;
            }
        }

        if (id == null) {
            return null;
        } else {
            Libro libroActualizado = new Libro();
            libroActualizado.setId(id);
            libroActualizado.setIsbn(libro.getIsbn());
            libroActualizado.setTitulo(libro.getTitulo());
            libroActualizado.setAutor(libro.getAutor());
            libroActualizado.setEditorial(libro.getEditorial());

            listaLibros.set(posicion, libroActualizado);
            return libroActualizado;
        }
    }

    public void eliminar(int id) {
        Libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }
    }

}
