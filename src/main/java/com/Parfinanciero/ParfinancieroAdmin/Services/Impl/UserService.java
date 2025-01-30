package com.Parfinanciero.ParfinancieroAdmin.Services.Impl;

import com.Parfinanciero.ParfinancieroAdmin.Domain.Entities.User;
import com.Parfinanciero.ParfinancieroAdmin.Domain.Infrastructure.Persistence.UserRepository;
import com.Parfinanciero.ParfinancieroAdmin.Services.Interfaces.IUserService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        try{
            User userCreated = User.builder()
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .password(user.getPassword())
                    .email(user.getEmail())
                    .build();
            return userRepository.save(userCreated);

        } catch (Exception e) {
            throw new RuntimeException("ERROR: USER CAN´T BE CREATED", e);
        }
    }

    @Override
    public User update(Long userId, User updatedUser) {

        try{
            Optional<User> existingUser = userRepository.findById(userId);

            if (existingUser.isPresent()) {
                User userToUpdate = existingUser.get();

                userToUpdate.setName(updatedUser.getName());
                userToUpdate.setLastName(updatedUser.getLastName());
                userToUpdate.setPassword(updatedUser.getPassword());
                userToUpdate.setEmail(userToUpdate.getEmail());

                return userRepository.save(userToUpdate);
            }else {
                throw new RuntimeException("ERROR: User not found for update");
            }
        } catch (Exception e) {
            throw new RuntimeException("ERROR: could not be update the user", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> readAll() throws Exception {

        try{
            return userRepository.findAll();

        }catch (DataAccessException e){
            throw new Exception("ERROR: Admin not have obtain from DATABASE");
        }

    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long UserId) throws Exception {

        try{
            Optional<User> user = userRepository.findById(UserId);

            if (user.isPresent()){
                return user.get();
            } else {
                throw new RuntimeException("ERROR: User not found with this ID" + UserId);
            }

        } catch (Exception e) {
            throw new RuntimeException("ERROR: Could not retrieve user with this ID" + UserId, e);
        }

    }

    @Override
    public boolean getDeleteById(Long UserId) {

        try{
            userRepository.deleteById(UserId);
            if(userRepository.findById(UserId) != null){
                return true;
            }
            return false;

        } catch (Exception e) {
            throw new RuntimeException("ERROR: User was not delete by ID");
        }

    }
}
