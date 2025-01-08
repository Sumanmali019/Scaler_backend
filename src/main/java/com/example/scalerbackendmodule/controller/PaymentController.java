package com.example.scalerbackendmodule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.scalerbackendmodule.dto.PaymentGatwayDTO;
import com.example.scalerbackendmodule.server.PaymentService;
import com.stripe.exception.StripeException;

@RestController
public class PaymentController {

  private PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping("/patment")
  public ResponseEntity<String> createPaymentLink(@RequestBody PaymentGatwayDTO paymentGatwayDTO)
      throws StripeException {
    String paymnetlink = paymentService.makePaymnet(paymentGatwayDTO.getOrderId(), paymentGatwayDTO.getAmount());
    return new ResponseEntity<>(paymnetlink, HttpStatus.OK);

  }
}
