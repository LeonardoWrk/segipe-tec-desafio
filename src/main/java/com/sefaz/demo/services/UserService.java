package com.sefaz.demo.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sefaz.demo.domain.transaction.Transaction;
import com.sefaz.demo.domain.user.User;
import com.sefaz.demo.dtos.UserDTO;
import com.sefaz.demo.repositories.UserRepository;

// service concentra as regras de negocio
@Service
public class UserService {
    // tem acesso ao userRepo para pegar os usuarios e fazer a manipulaçao
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        // finalizar logica de vali;ao dps

        // sender.getBalance() < amount)
        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Usuario nao tem saldo suficiente");
        }
    }

    // para nao usar o userepo no transaction service
    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuario nao encontrado"));
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public void deleteUser(Long id) throws Exception {
        User user = userRepository.findUserById(id).orElseThrow(() -> new Exception("User not found"));
        userRepository.delete(user);
    }

    public User editUser(Long id, UserDTO data) throws Exception{
        User editUser = userRepository.findUserById(id).orElseThrow(() -> new Exception("User not found"));

        editUser.setFirstName(data.firstName());
        editUser.setLastName(data.lastName());
        editUser.setDocument(data.document());
        editUser.setEmail(data.email());
        editUser.setPassword(data.password());
        editUser.setBalance(data.balance());

        this.saveUser(editUser);
        return editUser;
    }
    // List<objet/list type>
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }
}
