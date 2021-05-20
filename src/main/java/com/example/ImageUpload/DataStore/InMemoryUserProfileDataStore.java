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
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "alexgarcia", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "marksmith", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
