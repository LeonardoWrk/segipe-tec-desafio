package com.sefaz.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sefaz.demo.domain.user.User;
import com.sefaz.demo.dtos.UserDTO;
import com.sefaz.demo.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//endpoint q esse controller fica ouvindo
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController()
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    //indicar pro spring q ele temq injetar o boby como parametro para receber
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @PostMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) throws Exception{
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("message", "Conta excluída com sucesso.");
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) throws Exception {
      User editUser =  userService.editUser(id, userDTO);
       return new ResponseEntity<>(editUser,  HttpStatus.CREATED);
    }
    
    
}
