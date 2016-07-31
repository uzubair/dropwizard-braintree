package com.usmanzubair.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.braintreegateway.Plan;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.usmanzubair.configuration.BrainTreeConfiguration;
import com.usmanzubair.payments.BrainTreeService;
import com.usmanzubair.payments.BrainTreeServiceImpl;

@Path(value = "/payment")
public class PaymentResource {
    private final BrainTreeConfiguration brainTreeConfiguration;
    private BrainTreeService brainTreeService;

    public PaymentResource(BrainTreeConfiguration brainTreeConfiguration) {
        this.brainTreeConfiguration = brainTreeConfiguration;
        brainTreeService = new BrainTreeServiceImpl(brainTreeConfiguration);
    }

    @GET
    @Path(value = "/plans")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlans() {
        final Plan plan = brainTreeService.getAvailablePlans().get(0);

        return Response.ok(plan).build();
    }

    @GET
    @Path(value = "/token")
    public String getClientToken() {
        return brainTreeService.getClientToken();
    }

    @POST
    @Path(value = "/sale")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sale(String nonce) {
        final Result<Transaction> result = brainTreeService.sale(nonce);
        // TODO: return valid response and handle error case
        return Response.ok("{}").build();
    }
}
