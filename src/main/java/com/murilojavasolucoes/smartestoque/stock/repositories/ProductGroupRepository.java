package com.murilojavasolucoes.smartestoque.stock.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murilojavasolucoes.smartestoque.stock.models.ProductGroup;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Integer> {

  public Optional<ProductGroup> findByName(String name);
}
