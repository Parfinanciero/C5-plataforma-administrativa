package com.parfinanciero.C5.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "goalsClient", url = "http://localhost:8083")
public interface GoalsClient {

    @GetMapping("/goals")
    Object getGoals();

    @PostMapping("/goals")
    Object createGoal(@RequestBody Object goal);
}
