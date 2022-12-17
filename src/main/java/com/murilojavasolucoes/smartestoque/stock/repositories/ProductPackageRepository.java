package com.murilojavasolucoes.smartestoque.stock.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murilojavasolucoes.smartestoque.stock.models.ProductPackage;

@Repository
public interface ProductPackageRepository extends JpaRepository<ProductPackage, Integer> {

  public Optional<ProductPackage> findByName(String name);

  public Optional<ProductPackage> findByAbbreviation(String abbreviation);

}
