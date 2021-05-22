package com.example.ImageUpload.DataStore;

import com.example.ImageUpload.Profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class InMemoryUserProfileDataStore {

    private  static List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("a114815e-60a0-4782-b8f8-b8be50505b1d"), "alexgarcia", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("9fb778c9-96eb-40e8-a915-e3c6a2f4fe5d"), "marksmith", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
