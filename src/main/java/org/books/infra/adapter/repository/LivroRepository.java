package org.books.infra.adapter.repository;


import org.books.domain.model.Livro;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {}
