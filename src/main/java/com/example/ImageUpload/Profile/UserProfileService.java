package com.example.ImageUpload.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfileService {

    private final UserProfileDataAccessStore userProfileDataAccessStore;

    @Autowired
    public UserProfileService(UserProfileDataAccessStore userProfileDataAccessStore) {
        this.userProfileDataAccessStore = userProfileDataAccessStore;
    }

    List<UserProfile> getUserProfiles() {
        return this.userProfileDataAccessStore.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        /**
         * TODO - CHECK FILE is Image
         * CHECK is not Empty
         * if user exist
         * STORE Image
         * Grab metadata
         */
    }
}
