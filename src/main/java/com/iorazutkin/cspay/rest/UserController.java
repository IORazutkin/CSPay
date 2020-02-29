package com.iorazutkin.cspay.rest;

import com.iorazutkin.cspay.domain.*;
import com.iorazutkin.cspay.repo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserRepo userRepo;
    private ApartmentRepo apartmentRepo;
    private HouseRepo houseRepo;
    private ReceiptRepo receiptRepo;
    private ServiceRepo serviceRepo;

    public UserController(UserRepo userRepo, ApartmentRepo apartmentRepo,
                          HouseRepo houseRepo, ReceiptRepo receiptRepo,
                          ServiceRepo serviceRepo) {
        this.userRepo = userRepo;
        this.apartmentRepo = apartmentRepo;
        this.houseRepo = houseRepo;
        this.receiptRepo = receiptRepo;
        this.serviceRepo = serviceRepo;
    }

    private User createUser(User user) {
        House house = houseRepo.findByCityAndStreetAndHouse(
                user.getCity(), user.getStreet(), user.getHouse());
        Apartment apartment;
        if (house == null) {
            house = new House(user.getCity(), user.getStreet(), user.getHouse());
            apartment = new Apartment(user.getApartmentNumber(), house);
        } else {
            apartment = apartmentRepo.findByHouseAndNumber(house, user.getApartmentNumber());
            if (apartment == null) {
                apartment = new Apartment(user.getApartmentNumber(), house);
            }
        }

        user.setApartment(apartment);

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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user =  userRepo.save(createUser(user));
        Receipt receipt = new Receipt(user.getApartment(), LocalDate.now().withDayOfMonth(1));
        serviceRepo.findAll().forEach(service -> {
            receipt.addReceiptService(new ReceiptService(service, null, 0f));
        });
        receiptRepo.save(receipt);
        return user;
    }

    @PutMapping("/profile")
    public User userUpdate(@AuthenticationPrincipal User userFromDb,
                           @RequestBody User user) {
        if (!userFromDb.getId().equals(user.getId()) &&
                userRepo.findByUsername(user.getUsername()) != null) {
            return null;
        }
        BeanUtils.copyProperties(user, userFromDb, "id", "password");

        return userRepo.save(createUser(userFromDb));
    }

    @PutMapping("/password")
    public User passwordUpdate(@AuthenticationPrincipal User user,
                               @RequestParam String oldPassword,
                               @RequestParam String newPassword) {
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            return null;
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        return userRepo.save(user);
    }

    @PutMapping("/card")
    public User cardUpdate(@AuthenticationPrincipal User user,
                           @RequestBody Card card) {
        card.setCvv(passwordEncoder.encode(card.getCvv()));
        if (user.getCard() == null) {
            user.setCard(new Card(card.getNumber(), card.getDate(), card.getCvv()));
        } else {
            card.setId(user.getCard().getId());
        }

        return userRepo.save(user);
    }
}