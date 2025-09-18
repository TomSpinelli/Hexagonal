package org.books.domain;

import java.util.List;
import org.books.infra.repository.LivroRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro cadastrarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarLivro(Long id){
        return livroRepository.findById(id);
    }
}
