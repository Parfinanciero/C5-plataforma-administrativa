package com.Parfinanciero.ParfinancieroAdmin.Domain.Infrastructure.Persistence;

import com.Parfinanciero.ParfinancieroAdmin.Domain.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <User, Long> {
}
