package com.example.buddycatalogue;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    
    @GetMapping("/{id}")
    public Buddy getBuddyById(@PathVariable Long id) {
        return buddyRepository.findById(id).orElseThrow();
    }
}
