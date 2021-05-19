package com.example.DataStore;

import com.example.Profile.UserProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
