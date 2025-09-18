package org.books.application.port;

import org.books.domain.model.Livro;
import java.util.List;

public interface LivroRepositoryPort {

    Livro save(Livro livro);

    List<Livro> findAll();

    Livro findById();
}
