package com.murilojavasolucoes.smartestoque.finance.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.murilojavasolucoes.smartestoque.common.util.SmartEstoqueDateUtil;

import lombok.Data;

@Data
@Entity
@Table(name = "payment_method")
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private Boolean useInSales;

	private Boolean useInShops;

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
