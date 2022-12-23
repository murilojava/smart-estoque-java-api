package com.murilojavasolucoes.smartestoque.movement.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.murilojavasolucoes.smartestoque.common.util.SmartEstoqueDateUtil;

import lombok.Data;

@Data
@Entity
@Table(name = "movement")
public class Movement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 15)
  private MovementTypeEnum movementType;

  private LocalDateTime movementDate;

  private LocalDateTime itensAmount;

  private LocalDateTime discount;

  private LocalDateTime total;

  @OneToMany(cascade = { CascadeType.ALL })
  @JoinColumn(name = "movement_id")
  private List<MovementItem> itens = new ArrayList<>();

  @OneToMany(cascade = { CascadeType.ALL })
  @JoinColumn(name = "movement_id")
  private List<MovementPayment> payments = new ArrayList<>();

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
