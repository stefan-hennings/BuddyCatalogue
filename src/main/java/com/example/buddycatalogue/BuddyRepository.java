package com.example.buddycatalogue;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BuddyRepository extends JpaRepository<Buddy, UUID> {
//    Buddy findById(Long id);
//    Buddy findByName(String name);
//    Buddy findByEmail(String email);
//    Buddy findByPhoneNumber(String phoneNumber);
    
    Optional<Buddy> findById(Long id);
    Optional<Buddy> findByName(String name);
    Optional<Buddy> findByEmail(String email);
    Optional<Buddy> findByPhoneNumber(String phoneNumber);
}
