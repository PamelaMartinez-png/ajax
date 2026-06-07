package com.upiiz.ajax.Repositories;

import com.upiiz.ajax.Entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {

}