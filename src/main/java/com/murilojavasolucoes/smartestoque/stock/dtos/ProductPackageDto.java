package com.murilojavasolucoes.smartestoque.stock.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductPackageDto { // Usar o spring validation para validar a entrada da API

  private String name;

  private String abbreviation;

  private LocalDate createdAt;

  private LocalDate updatedAt;
}
