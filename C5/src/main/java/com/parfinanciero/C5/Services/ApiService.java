package com.parfinanciero.C5.Services;

import com.parfinanciero.C5.Clients.GoalsClient;
import com.parfinanciero.C5.Clients.BillsClient;
import com.parfinanciero.C5.Clients.UsersClient;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
    private final GoalsClient goalsClient;
    private final BillsClient billsClient;
    private final UsersClient usersClient;

    public ApiService(GoalsClient goalsClient, BillsClient billsClient, UsersClient usersClient) {
        this.goalsClient = goalsClient;
        this.billsClient = billsClient;
        this.usersClient = usersClient;
    }

    public Object getAllGoals() {
        return goalsClient.getGoals();
    }

    public Object getAllBills() {
        return billsClient.getBills();
    }

    public Object getUser(Long id) {
        return usersClient.getUser(id);
    }
}