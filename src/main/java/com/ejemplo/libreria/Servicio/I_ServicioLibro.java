package com.ejemplo.libreria.Servicio;
import java.util.List;
import java.util.Optional;
import com.ejemplo.libreria.Model.Libros;

public interface I_ServicioLibro {
    List<Libros>ObtenerTodos();
    Optional<Libros>obtenerPorId(long id);
    Libros guardar(Libros libro);
    void eliminarPorId(long id);
    String buscaLibroPorTitulo(String titulo);

}
