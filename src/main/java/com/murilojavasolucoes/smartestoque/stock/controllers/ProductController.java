package com.murilojavasolucoes.smartestoque.stock.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murilojavasolucoes.smartestoque.common.core.DefaultController;
import com.murilojavasolucoes.smartestoque.stock.dtos.ProductDto;
import com.murilojavasolucoes.smartestoque.stock.models.Product;
import com.murilojavasolucoes.smartestoque.stock.services.ProductGroupService;
import com.murilojavasolucoes.smartestoque.stock.services.ProductPackageService;
import com.murilojavasolucoes.smartestoque.stock.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController extends DefaultController<Product, Integer, ProductDto> {

  final ProductService productService;
  final ProductGroupService productGroupService;
  final ProductPackageService productPackageService;

  public ProductController(ProductService productService, ProductGroupService productGroupService,
      ProductPackageService productPackageService) {
    super(productService);
    this.productService = productService;
    this.productGroupService = productGroupService;
    this.productPackageService = productPackageService;
  }

  @Override
  public Product createModel() {
    return new Product();
  }

  @Override
  public Product buildModel(ProductDto dto) {
    Product product = super.buildModel(dto);

    if (dto.getProductGroupId() != null)
      product.setProductGroup(this.productGroupService.findById(dto.getProductGroupId()).orElseThrow());

    if (dto.getProductPackageId() != null)
      product.setProductPackage(this.productPackageService.findById(dto.getProductPackageId()).orElseThrow());

    return product;
  }
}
