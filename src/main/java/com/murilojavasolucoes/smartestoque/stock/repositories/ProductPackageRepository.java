package com.murilojavasolucoes.smartestoque.estoque.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murilojavasolucoes.smartestoque.estoque.models.ProductPackage;

@Repository
public interface ProductPackageRepository extends JpaRepository<ProductPackage, Integer> {

  public Optional<ProductPackage> findByName(String name);

  public Optional<ProductPackage> findByAbbreviation(String abbreviation);

}
