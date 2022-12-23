package com.murilojavasolucoes.smartestoque.finance.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murilojavasolucoes.smartestoque.common.core.DefaultController;
import com.murilojavasolucoes.smartestoque.finance.dtos.PaymentMethodDto;
import com.murilojavasolucoes.smartestoque.finance.models.PaymentMethod;
import com.murilojavasolucoes.smartestoque.finance.services.PaymentMethodService;

@RestController
@RequestMapping("/payment-method")
public class PaymentMethodController extends DefaultController<PaymentMethod, Integer, PaymentMethodDto> {

  final PaymentMethodService paymentMethodService;

  public PaymentMethodController(PaymentMethodService paymentMethodService) {
    super(paymentMethodService);
    this.paymentMethodService = paymentMethodService;
  }

  @Override
  public PaymentMethod createModel() {
    return new PaymentMethod();
  }
}
