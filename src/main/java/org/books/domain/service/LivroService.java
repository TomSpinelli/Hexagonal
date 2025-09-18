package org.books.domain.service;

import java.util.List;

import org.books.infra.adapter.email.EmailService;
import org.books.domain.model.Livro;
import org.books.infra.adapter.repository.LivroRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final EmailService emailService;

    public LivroService(LivroRepository livroRepository, EmailService emailService) {
        this.livroRepository = livroRepository;
        this.emailService = emailService;
    }

    public Livro cadastrarLivro(Livro livro) {
        Livro livroRetorno = livroRepository.save(livro);
        emailService.sendEmail(livroRetorno);
        return livroRetorno;

    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarLivro(Long id){
        return livroRepository.findById(id);
    }
}
