package com.usmanzubair;

import com.usmanzubair.resource.PaymentResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class WebService extends Service<WebServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new WebService().run(args);
    }

    @Override
    public void initialize(Bootstrap<WebServiceConfiguration> bootstrap) {
        bootstrap.setName("dropwizard-braintree");
        bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    }

    @Override
    public void run(WebServiceConfiguration conf, Environment env) throws Exception {
        env.addResource(new PaymentResource(conf.getBrainTreeConfiguration()));
    }
}
