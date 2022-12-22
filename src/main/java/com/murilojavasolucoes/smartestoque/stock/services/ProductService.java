package com.murilojavasolucoes.smartestoque.stock.services;

import org.springframework.stereotype.Service;

import com.murilojavasolucoes.smartestoque.common.core.DefaultService;
import com.murilojavasolucoes.smartestoque.stock.models.Product;
import com.murilojavasolucoes.smartestoque.stock.repositories.ProductRepository;

@Service
public class ProductService extends DefaultService<Product, Integer> {
  final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    super(productRepository);
    this.productRepository = productRepository;
  }
}
