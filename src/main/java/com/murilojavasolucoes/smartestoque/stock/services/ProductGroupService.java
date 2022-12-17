package com.murilojavasolucoes.smartestoque.stock.services;

import org.springframework.stereotype.Service;

import com.murilojavasolucoes.smartestoque.common.core.DefaultService;
import com.murilojavasolucoes.smartestoque.stock.models.ProductGroup;
import com.murilojavasolucoes.smartestoque.stock.repositories.ProductGroupRepository;

@Service
public class ProductGroupService extends DefaultService<ProductGroup, Integer> {
  final ProductGroupRepository productGroupRepository;

  public ProductGroupService(ProductGroupRepository productGroupRepository) {
    super(productGroupRepository);
    this.productGroupRepository = productGroupRepository;
  }
}
