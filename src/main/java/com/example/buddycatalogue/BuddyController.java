package com.example.buddycatalogue;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/newBuddy")
public class BuddyController {
    
    private final BuddyRepository buddyRepository;
    
    @RequestMapping("/add")
    public String addBuddy(@RequestParam String name, @RequestParam String phoneNumber, @RequestParam String email) {
        System.out.println("here");
        buddyRepository.save(new Buddy()
                .setName(name)
                .setPhoneNumber(phoneNumber)
                .setEmail(email));
        return name + " was saved";
    }
    
    @GetMapping()
    public List<Buddy> getAll() {
        return buddyRepository.findAll();
    }
}
