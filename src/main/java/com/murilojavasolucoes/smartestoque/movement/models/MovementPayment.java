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
import com.murilojavasolucoes.smartestoque.finance.models.PaymentMethod;

import lombok.Data;

@Data
@Entity
@Table(name = "movement_payment")
public class MovementPayment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(cascade = { CascadeType.REFRESH })
  @JoinColumn(name = "payment_method_id")
  private PaymentMethod paymentMethod;

  @Column(precision = 16, scale = 2)
  private BigDecimal value;

  @Column(precision = 16, scale = 2)
  private BigDecimal change;

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
