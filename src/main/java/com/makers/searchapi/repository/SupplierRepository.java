package com.makers.searchapi.repository;

import com.makers.searchapi.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer>, JpaSpecificationExecutor<Supplier> {
}
