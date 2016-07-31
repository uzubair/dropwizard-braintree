package com.usmanzubair.payments;

import com.braintreegateway.Plan;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;

import java.util.List;

public interface BrainTreeService {
    List<Plan> getAvailablePlans();

    String getClientToken();

    Result<Transaction> sale(String paymentMethodNonce);
}
