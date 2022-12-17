package com.murilojavasolucoes.smartestoque.stock.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product_group")
public class ProductGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private Boolean useInSales;

	private Boolean useInShops;

	private Boolean controlStock;

	private LocalDate createdAt;

  private LocalDate updatedAt;
}
