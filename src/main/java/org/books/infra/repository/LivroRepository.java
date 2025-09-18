package org.books.infra.repository;


import org.books.domain.Livro;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {}
