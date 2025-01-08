package com.example.scalerbackendmodule.server;

import com.stripe.exception.StripeException;

public interface PaymentService {

    String makePaymnet(String orderId, Long amount) throws StripeException;

}
