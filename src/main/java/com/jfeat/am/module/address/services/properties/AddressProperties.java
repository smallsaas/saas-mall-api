package com.jfeat.am.module.address.services.properties;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "address")
public class AddressProperties {

    @Value("10")
    private Integer maxAddressCount;

    public Integer getMaxAddressCount() {
        return maxAddressCount;
    }

    public void setMaxAddressCount(Integer maxAddressCount) {
        this.maxAddressCount = maxAddressCount;
    }
}
