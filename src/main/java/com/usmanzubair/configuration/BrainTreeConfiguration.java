package com.usmanzubair.configuration;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrainTreeConfiguration {
    @NotNull
    @JsonProperty
    private String environment;

    @NotNull
    @JsonProperty
    private String merchantId;

    @NotNull
    @JsonProperty
    private String publicKey;

    @NotNull
    @JsonProperty
    private String privateKey;

    public String getEnvironment() {
        return environment;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }
}
