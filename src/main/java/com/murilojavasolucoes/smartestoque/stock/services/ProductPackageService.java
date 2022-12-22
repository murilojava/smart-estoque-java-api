package com.murilojavasolucoes.smartestoque.stock.services;

import org.springframework.stereotype.Service;

import com.murilojavasolucoes.smartestoque.common.core.DefaultService;
import com.murilojavasolucoes.smartestoque.stock.models.ProductPackage;
import com.murilojavasolucoes.smartestoque.stock.repositories.ProductPackageRepository;

@Service
public class ProductPackageService extends DefaultService<ProductPackage, Integer> {
  final ProductPackageRepository productPackageRepository;

  public ProductPackageService(ProductPackageRepository productPackageRepository) {
    super(productPackageRepository);
    this.productPackageRepository = productPackageRepository;
  }
}
