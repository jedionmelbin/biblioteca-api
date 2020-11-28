package com.ixcorp.app.api.repository;

import com.ixcorp.app.api.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {

}
