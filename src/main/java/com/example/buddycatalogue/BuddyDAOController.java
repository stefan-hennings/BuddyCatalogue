package com.example.buddycatalogue;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BuddyDAOController {
    BuddyDAO daniel = new BuddyDAO(1, "Daniel", "123");
    BuddyDAO julia = new BuddyDAO(2, "Julia", "1235");
    BuddyDAO patrik = new BuddyDAO(3, "Patrik", "663");
    BuddyDAO oscar = new BuddyDAO(4, "Oscar", "1247");
    BuddyDAO elias = new BuddyDAO(5, "Elias", "1616");
    BuddyDAO ivo = new BuddyDAO(6, "T-blade", "9999");
    List<BuddyDAO> allBuddies = new ArrayList<>(List.of(daniel, julia, patrik, oscar, elias, ivo));
    
    @RequestMapping("/buddy/all")
    public List<BuddyDAO> getAllBuddies() {
        return allBuddies;
    }
    
    @RequestMapping("/buddy/{id}")
    public BuddyDAO getBuddy(@PathVariable int id) {
        for (BuddyDAO buddy : allBuddies) {
            if (buddy.getId() == id) {
                return buddy;
            }
        }
        return null;
    }
    
    @RequestMapping("/buddy/{id}/delete")
    public Message deleteBuddy(@PathVariable int id) {
        int indexToDelete = -1;
        Message message = new Message();
        for (int i = 0; i < allBuddies.size(); i++) {
            if (allBuddies.get(i).getId() == id) {
                indexToDelete = i;
                message.setMessage(allBuddies.get(i).getName() + " deleted");
                message.setStatus(true);
                break;
            }
        }
        if (indexToDelete != -1) {
            allBuddies.remove(indexToDelete);
        } else {
            message.setMessage("Buddy not found");
            message.setStatus(false);
        }
        return message;
    }
    
    @PostMapping("/buddy/add")
    public Message addBuddy(@RequestBody BuddyDAO buddyToAdd){
        allBuddies.add(buddyToAdd);
        return new Message(buddyToAdd.getName() + " added", true);
    }
    
    @PostMapping("/buddy/update")
    public Message updateBuddy(@RequestBody BuddyDAO buddyToAdd){
        int buddyIndex = -1;
        for (int i = 0; i < allBuddies.size(); i++) {
            if (allBuddies.get(i).getId() == buddyToAdd.getId()) {
                allBuddies.set(i, buddyToAdd);
                return new Message(buddyToAdd.getName() + " updated", true);
            }
        }
        allBuddies.add(buddyToAdd);
        return new Message(buddyToAdd.getName() + " added", false);
    }
}
