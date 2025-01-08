package com.example.scalerbackendmodule.server;

import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;

@Service
public class StringPaymnetGatewayImplementation implements PaymentService {
    @Override
    public String makePaymnet(String orderId, Long amount) throws StripeException {
        // 1. cretae priceCreatePara - INR, amount, orderID

        Stripe.apiKey = "sk_test_51Qf2uCRpbbQx9BNkg1446yXzxyfJ4BNX9jAycpsrz54vdUg4qUU2KNRVdEMX1PxZtTDVtHz7MKZNsE6eynaT8VDr006rk4I1tA";

        PriceCreateParams params = PriceCreateParams.builder()
                .setCurrency("INR")
                .setUnitAmount(amount)
                .setProductData(
                        PriceCreateParams.ProductData.builder().setName(orderId).build())
                .build();

        Price price = Price.create(params);

        // 2. Creating the payment link

        PaymentLinkCreateParams Linkparams = PaymentLinkCreateParams.builder()
                .addLineItem(
                        PaymentLinkCreateParams.LineItem.builder()
                                .setPrice(price.getId())
                                .setQuantity(1L)
                                .build())
                .build();

        PaymentLink paymentLink = PaymentLink.create(Linkparams);
        return paymentLink.getUrl();
    }
}
