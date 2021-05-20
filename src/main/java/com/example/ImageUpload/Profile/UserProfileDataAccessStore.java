package com.example.ImageUpload.Profile;

import com.example.ImageUpload.DataStore.InMemoryUserProfileDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileDataAccessStore {
    private  final InMemoryUserProfileDataStore inMemoryUserProfileDataStore;

    @Autowired
    public UserProfileDataAccessStore(InMemoryUserProfileDataStore inMemoryUserProfileDataStore) {
        this.inMemoryUserProfileDataStore = inMemoryUserProfileDataStore;
    }

    List<UserProfile> getUserProfiles() {
        return inMemoryUserProfileDataStore.getUserProfiles();
    }
}
