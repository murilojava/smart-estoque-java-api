package com.murilojavasolucoes.smartestoque.estoque.models;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String code;

  private String barcode;

  private String name;

  private String description;

  @ManyToOne(cascade = { CascadeType.REFRESH })
  @JoinColumn(name = "grupo_id")
  private ProductGroup grupo;

  @ManyToOne(cascade = { CascadeType.REFRESH })
  @JoinColumn(name = "embalagem_id")
  private ProductPackage productPackage;

  private Boolean requiresQuantity = Boolean.FALSE;

  @Column(precision = 16, scale = 4)
  private BigDecimal minimalStock;

  @Column(precision = 16, scale = 4)
  private BigDecimal actualStock;

  @Column(precision = 16, scale = 3)
  private BigDecimal price;

  @Column(precision = 16, scale = 3)
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
