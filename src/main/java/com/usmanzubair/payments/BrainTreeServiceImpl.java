package com.usmanzubair.payments;

import java.math.BigDecimal;
import java.util.List;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import com.braintreegateway.Plan;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import com.usmanzubair.configuration.BrainTreeConfiguration;

public class BrainTreeServiceImpl implements BrainTreeService {

    private BrainTreeConfiguration brainTreeConfiguration;
    private static BraintreeGateway gateway;

    public BrainTreeServiceImpl(BrainTreeConfiguration brainTreeConfiguration) {
        this.brainTreeConfiguration = brainTreeConfiguration;

        gateway = new BraintreeGateway(
                Environment.parseEnvironment(brainTreeConfiguration.getEnvironment()),
                this.brainTreeConfiguration.getMerchantId(),
                this.brainTreeConfiguration.getPublicKey(),
                this.brainTreeConfiguration.getPrivateKey()
        );
    }

    @Override
    public List<Plan> getAvailablePlans() {
        return gateway.plan().all();
    }

    @Override
    public String getClientToken() {
        return gateway.clientToken().generate();
    }

    @Override
    public Result<Transaction> sale(String paymentMethodNonce) {
        TransactionRequest request = new TransactionRequest()
                .amount(new BigDecimal("10.00"))
                .paymentMethodNonce(paymentMethodNonce)
                .options()
                .done();

        Result<Transaction> result = gateway.transaction().sale(request);

        return result;
    }
}
