package com.appsdevloperblog.photoapp.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import reactor.core.publisher.Mono;

@Configuration
public class GlobalFIltersConfiguration {
	
	final Logger logger = LoggerFactory.getLogger(GlobalFIltersConfiguration.class);

	@Order(1)
	@Bean
	public GlobalFilter preFilter2() {
		return(exchange, chain)-> {
			logger.info("Second global pre-filter is executed...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(()-> {
				logger.info("Second global post-filter was executed...");
			}));
		};
	}
	
	@Order(2)
	@Bean
	public GlobalFilter preFilter3() {
		return(exchange, chain)-> {
			logger.info("Third global pre-filter is executed...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(()-> {
				logger.info("Third global post-filter was executed...");
			}));
		};
	}
	
	@Order(3)
	@Bean
	public GlobalFilter preFilter4() {
		return(exchange, chain)-> {
			logger.info("Fourth global pre-filter is executed...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(()-> {
				logger.info("Fourth global post-filter was executed...");
			}));
		};
	}
}
