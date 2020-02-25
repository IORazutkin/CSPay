package com.iorazutkin.cspay.rest;

import com.iorazutkin.cspay.domain.Apartment;
import com.iorazutkin.cspay.domain.House;
import com.iorazutkin.cspay.domain.User;
import com.iorazutkin.cspay.repo.ApartmentRepo;
import com.iorazutkin.cspay.repo.HouseRepo;
import com.iorazutkin.cspay.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserRepo userRepo;
    private ApartmentRepo apartmentRepo;
    private HouseRepo houseRepo;

    public UserController(UserRepo userRepo, ApartmentRepo apartmentRepo, HouseRepo houseRepo) {
        this.userRepo = userRepo;
        this.apartmentRepo = apartmentRepo;
        this.houseRepo = houseRepo;
    }

    private User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        House house = houseRepo.findByCityAndStreetAndHouse(
                user.getCity(), user.getStreet(), user.getHouse());
        if (house == null) {
            house = houseRepo.save(new House(user.getCity(), user.getStreet(), user.getHouse()));
        }

        Apartment apartment = apartmentRepo.findByHouseIdAndNumber(house, user.getApartmentNumber());
        if (apartment == null) {
            apartment = apartmentRepo.save(new Apartment(user.getApartmentNumber(), house));
        }

        user.setApartmentId(apartment);

        return user;
    }

    @GetMapping
    public User getUser(@AuthenticationPrincipal User user) {
        return user;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            return null;
        }
        return userRepo.save(createUser(user));
    }
}