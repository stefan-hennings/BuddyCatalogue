package com.example.buddycatalogue;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuddyRepository extends JpaRepository<Buddy, UUID> {
    Buddy findById(Long id);
    Buddy findByName(String name);
//    Buddy findByEMail(String eMail);
    Buddy findByEmail(String email);
    Buddy findByPhoneNumber(String phoneNumber);
    
//    Optional<Buddy> findById(UUID id);
//    Optional<Buddy> findByName(String name);
//    Optional<Buddy> findByEMail(String eMail);
//    Optional<Buddy> findByPhoneNumber(String phoneNumber);
}
