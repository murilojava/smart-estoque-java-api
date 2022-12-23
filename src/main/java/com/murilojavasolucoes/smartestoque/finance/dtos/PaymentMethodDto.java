package com.murilojavasolucoes.smartestoque.finance.dtos;

import lombok.Data;

@Data
public class PaymentMethodDto { // Usar o spring validation para validar a entrada da API

  private String name;

  private Boolean useInSales;

  private Boolean useInShops;
}
