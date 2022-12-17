package com.murilojavasolucoes.smartestoque.stock.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murilojavasolucoes.smartestoque.common.core.DefaultController;
import com.murilojavasolucoes.smartestoque.stock.dtos.ProductGroupDto;
import com.murilojavasolucoes.smartestoque.stock.models.ProductGroup;
import com.murilojavasolucoes.smartestoque.stock.services.ProductGroupService;

@RestController
@RequestMapping("/product-group")
public class ProductGroupController extends DefaultController<ProductGroup, Integer, ProductGroupDto> {

  final ProductGroupService productGroupService;

  public ProductGroupController(ProductGroupService productGroupService) {
    super(productGroupService);
    this.productGroupService = productGroupService;
  }

  @Override
  public ProductGroup createModel() {
    return new ProductGroup();
  }
}
