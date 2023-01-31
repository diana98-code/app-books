package com.distribuida.servicios;

import com.distribuida.db.Author;

import javax.transaction.Transactional;
import java.util.List;

public interface AuthorService {
    List<Author> encontrarTodos();
    Author encontrarAutor(Long id);
    void guardarAutor(Author author);
    void actualizarAutor(Long id, Author author) throws Exception;
    void borrarAutor(Long id);

}
