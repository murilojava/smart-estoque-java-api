package com.murilojavasolucoes.smartestoque.finance.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murilojavasolucoes.smartestoque.finance.models.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

  public Optional<PaymentMethod> findByName(String name);
}
