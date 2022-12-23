package com.murilojavasolucoes.smartestoque.finance.services;

import org.springframework.stereotype.Service;

import com.murilojavasolucoes.smartestoque.common.core.DefaultService;
import com.murilojavasolucoes.smartestoque.finance.models.PaymentMethod;
import com.murilojavasolucoes.smartestoque.finance.repositories.PaymentMethodRepository;

@Service
public class PaymentMethodService extends DefaultService<PaymentMethod, Integer> {
  final PaymentMethodRepository paymentMethodRepository;

  public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
    super(paymentMethodRepository);
    this.paymentMethodRepository = paymentMethodRepository;
  }
}
