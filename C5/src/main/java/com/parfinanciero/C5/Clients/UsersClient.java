package com.parfinanciero.C5.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="usersClient" , url ="http://localhost:8083")
public interface UsersClient {
    @GetMapping("/users/{id}")
    Object getUser(@PathVariable("id") Long id);

    @PostMapping("/users")
    Object creteUser(@RequestBody Object user);
}
