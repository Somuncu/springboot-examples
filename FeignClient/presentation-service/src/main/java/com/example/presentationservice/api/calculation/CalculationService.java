package com.example.presentationservice.api.calculation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "calculation-service")
public interface CalculationService {

        @GetMapping("/{price}/{productType}")
        Double showTotalPrice(@PathVariable double price, @PathVariable String productType);
}
