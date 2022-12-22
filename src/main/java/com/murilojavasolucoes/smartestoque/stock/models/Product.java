package com.murilojavasolucoes.smartestoque.stock.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String code;

  private String barcode;

  private String name;

  private String description;

  @ManyToOne(cascade = { CascadeType.REFRESH })
  @JoinColumn(name = "product_group_id")
  private ProductGroup productGroup;

  @ManyToOne(cascade = { CascadeType.REFRESH })
  @JoinColumn(name = "product_package_id")
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

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
