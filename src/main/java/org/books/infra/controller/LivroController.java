package org.books.infra.controller;


import org.books.domain.Livro;
import org.books.domain.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        return livroService.cadastrarLivro(livro);
    }

    @GetMapping
    public List<Livro> listarTodosOsLivros() {
        return livroService.listarLivros();
    }

    @GetMapping("/{id}")
    public Livro buscarLivroPorId(Long id){

        Optional<Livro> livroOptional = livroService.buscarLivro(id);

        if (livroOptional.isPresent()) {
            return livroOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
        }
    }
}
