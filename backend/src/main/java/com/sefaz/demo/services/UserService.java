package com.sefaz.demo.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sefaz.demo.domain.user.User;
import com.sefaz.demo.domain.withdrawal.Withdrawal;
import com.sefaz.demo.dtos.UserDTO;
import com.sefaz.demo.domain.transaction.Transaction;
import com.sefaz.demo.repositories.UserRepository;
import com.sefaz.demo.repositories.WithdrawalRepository;

// service concentra as regras de negocio
@Service
public class UserService {
    // tem acesso ao userRepo para pegar os usuarios e fazer a manipulaçao
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        // finalizar logica de vali;ao dps

        // sender.getBalance() < amount) -> bigdecimal nao suporta <= = > =>
        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Usuario nao tem saldo suficiente");
        }
    }

    public void validateDeposit(BigDecimal amount) throws Exception {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("O valor deve ser maior que zero"); 
        }
    }

    public void validateWithdrawal(User receiver, BigDecimal amount) throws Exception {
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            throw new Exception("Sua conta deve ter mais que 0 para a açao ser efetuada"); 
        }

        if (receiver.getBalance().compareTo(amount) <= 0) {
            throw new Exception("Voce nao possui esse valor em conta!"); 
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
        // resolver de forma melhor
        User user = this.userRepository.findUserById(id).orElseThrow(() -> new Exception("User not found"));
        Withdrawal with = this.withdrawalRepository.findWithById(id).orElseThrow(() -> new Exception("User not found"));
        

        System.out.println("no delete" + user);
        System.out.println("no delete" + with);
        withdrawalRepository.delete(with);
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
