package com.bank.account.customer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * the refresh does not work with record, because its immutable, using class config instead with getters / setters
 */
//@ConfigurationProperties(prefix = "global.params")
//@RefreshScope
public record GlobalConfig(int p1, int p2) {
}
