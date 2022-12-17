package com.murilojavasolucoes.smartestoque.estoque.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murilojavasolucoes.smartestoque.estoque.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

  public Optional<Product> findByCode(String code);
  
  public Optional<Product> findByBarcode(String barcode);

  public List<Product> findByName(String name);
}
