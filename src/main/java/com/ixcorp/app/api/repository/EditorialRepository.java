package com.ixcorp.app.api.repository;

import com.ixcorp.app.api.domain.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository  extends JpaRepository<Editorial,Long> {
}
