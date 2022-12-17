package com.murilojavasolucoes.smartestoque.stock.dtos;

import lombok.Data;

@Data
public class ProductGroupDto { // Usar o spring validation para validar a entrada da API

  private String name;

  private Boolean useInSales;

  private Boolean useInShops;

  private Boolean controlStock;
}
