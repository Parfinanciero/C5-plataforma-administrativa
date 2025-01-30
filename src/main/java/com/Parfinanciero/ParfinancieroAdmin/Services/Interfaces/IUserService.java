package com.Parfinanciero.ParfinancieroAdmin.Services.Interfaces;

import com.Parfinanciero.ParfinancieroAdmin.Domain.Entities.User;

import java.util.List;

public interface IUserService {

    User create(User user);

    User update(Long UserId, User updatedUser);

    List<User> readAll() throws Exception;

    User getById(Long UserId) throws Exception;

    boolean getDeleteById(Long UserId);
}
