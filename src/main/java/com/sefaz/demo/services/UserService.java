package com.sefaz.demo.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sefaz.demo.domain.transaction.Transaction;
import com.sefaz.demo.domain.user.User;
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
    //para nao usar o userepo no transaction service
    public User findUserById(Long id) throws Exception{
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuario nao encontrado"));
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }
}
