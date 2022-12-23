package com.murilojavasolucoes.smartestoque.movement.models;

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

import com.murilojavasolucoes.smartestoque.common.util.SmartEstoqueDateUtil;
import com.murilojavasolucoes.smartestoque.stock.models.Product;

import lombok.Data;

@Data
@Entity
@Table(name = "movement_item")
public class MovementItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String productCode;

  private String productBarcode;

  private String productName;

  @ManyToOne(cascade = { CascadeType.REFRESH })
  @JoinColumn(name = "product_id")
  private Product product;

  private Boolean generateStockMovement = Boolean.TRUE;

  @Column(precision = 16, scale = 4)
  private BigDecimal quantity;

  @Column(precision = 16, scale = 2)
  private BigDecimal unitPrice;

  @Column(precision = 16, scale = 2)
  private BigDecimal totalPrice;

  @Column(precision = 16, scale = 2)
  private BigDecimal discount;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = SmartEstoqueDateUtil.newDateTime();
    updatedAt = SmartEstoqueDateUtil.newDateTime();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = SmartEstoqueDateUtil.newDateTime();
  }
}
