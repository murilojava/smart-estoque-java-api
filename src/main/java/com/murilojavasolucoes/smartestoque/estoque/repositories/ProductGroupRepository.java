package com.murilojavasolucoes.smartestoque.estoque.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murilojavasolucoes.smartestoque.estoque.models.ProductGroup;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Integer> {

  public Optional<ProductGroup> findByName(String name);
}
