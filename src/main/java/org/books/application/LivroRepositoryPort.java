package org.books.application;

import org.books.domain.Livro;
import java.util.List;

public interface LivroRepositoryPort {

    Livro save(Livro livro);

    List<Livro> findAll();

    Livro findById();
}
