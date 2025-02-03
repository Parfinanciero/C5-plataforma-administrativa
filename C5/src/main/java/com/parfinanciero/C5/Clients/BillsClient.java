package com.parfinanciero.C5.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "billsClient" , url = "http://localhost:8083")

public interface BillsClient {
    @GetMapping("/bills")
    Object getBills();

    @PostMapping("/bills")
    Object createBill(@RequestBody Object bill);

}
