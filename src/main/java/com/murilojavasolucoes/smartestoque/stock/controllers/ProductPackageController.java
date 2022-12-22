package com.murilojavasolucoes.smartestoque.stock.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murilojavasolucoes.smartestoque.common.core.DefaultController;
import com.murilojavasolucoes.smartestoque.stock.dtos.ProductPackageDto;
import com.murilojavasolucoes.smartestoque.stock.models.ProductPackage;
import com.murilojavasolucoes.smartestoque.stock.services.ProductPackageService;

@RestController
@RequestMapping("/product-package")
public class ProductPackageController extends DefaultController<ProductPackage, Integer, ProductPackageDto> {

  final ProductPackageService productPackageService;

  public ProductPackageController(ProductPackageService productPackageService) {
    super(productPackageService);
    this.productPackageService = productPackageService;
  }

  @Override
  public ProductPackage createModel() {
    return new ProductPackage();
  }
}
