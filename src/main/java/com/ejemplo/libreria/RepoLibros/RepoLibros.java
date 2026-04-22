package com.ejemplo.libreria.RepoLibros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.ejemplo.libreria.Model.Libros;

@Repository
public class RepoLibros implements I_RepoLibros{
    private final List<Libros> libros = new ArrayList<>();
    //final es para que su referencia sea inmutable

    public RepoLibros(){
        libros.add(new Libros(1L,"Miguel de Cervantes", "El Quijote", LocalDate.of(1605, 1, 16)));
        libros.add(new Libros(2L, "Gabriel García Márquez", "Cien Años de Soledad", LocalDate.of(1967, 5, 30)));
        libros.add(new Libros(3L, "J.K. Rowling", "Harry Potter y la Piedra Filosofal", LocalDate.of(1997, 6, 26)));
        libros.add(new Libros(4L, "George Orwell", "1984", LocalDate.of(1949, 6, 8)));
        libros.add(new Libros(5L, "F. Scott Fitzgerald", "El Gran Gatsby", LocalDate.of(1925, 4, 10)));
    }

    @Override
    public List<Libros> findAll() {
        return libros;
    }

    @Override
    public Optional<Libros>findById(long idLibro) {
        return libros.stream()
        .filter(libros1 -> libros1.getIdLibro() == idLibro)
        .findFirst();
    }

    @Override
    public void save(Libros libro) {
        findById(libro.getIdLibro()).ifPresent(libros::remove);
        libros.add(libro);
    }

    @Override
    public void deleteById(long id){
        findById(id).ifPresent(libros::remove);
    }

    public Optional<Libros> BuscaId(long idLibro) {
        return findById(idLibro);

        
    }
}
