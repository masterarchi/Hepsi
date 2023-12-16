package org.atmbanking;

import org.atmbanking.entity.User;
import org.atmbanking.repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        UserRepository userRepository = new UserRepository();
        userRepository.login("mehmet@gmail.com","12345");
        System.out.println("hoş geldiniz"+user.getEmail());
    }
}