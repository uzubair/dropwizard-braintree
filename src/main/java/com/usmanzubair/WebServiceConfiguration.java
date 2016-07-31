package com.usmanzubair;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.usmanzubair.configuration.BrainTreeConfiguration;
import com.yammer.dropwizard.config.Configuration;

public class WebServiceConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty
    private BrainTreeConfiguration braintree = new BrainTreeConfiguration();

    public BrainTreeConfiguration getBrainTreeConfiguration() {
        return braintree;
    }
}
