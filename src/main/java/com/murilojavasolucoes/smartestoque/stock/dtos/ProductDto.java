package com.murilojavasolucoes.smartestoque.stock.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDto { // Usar o spring validation para validar a entrada da API

  private String code;

  private String barcode;

  private String name;

  private String description;

  private Integer productGroupId;

  private Integer productPackageId;

  private Boolean requiresQuantity = Boolean.FALSE;

  private BigDecimal minimalStock;

  private BigDecimal actualStock;

  private BigDecimal price;

  private BigDecimal cost;

  private Boolean active = Boolean.TRUE;

  private Boolean canChangeUnitPrice;

  private Boolean canChangeTotalPrice;

  private Boolean canChangeCost;

  private Boolean saveShoppingCost;

  private Boolean controlStock = true;

  private Boolean isService = false;

  private Boolean useInSales = Boolean.TRUE;

  private Boolean useInCost = Boolean.TRUE;

  private String reference = null;
}
