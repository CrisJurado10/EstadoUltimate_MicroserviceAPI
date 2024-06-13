package com.evalueytor.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.evalueytor.empresa.models.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
