package com.example.buddycatalogue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuddyDAO {
    private int id;
    private String name;
    private String phoneNumber;
}
