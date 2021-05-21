package com.example.ImageUpload.Profile;

import com.example.ImageUpload.Bucket.BucketName;
import com.example.ImageUpload.FileStore.FileStore;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class UserProfileService {

    private final UserProfileDataAccessStore userProfileDataAccessStore;
    private final FileStore fileStore;

    @Autowired
    public UserProfileService(UserProfileDataAccessStore userProfileDataAccessStore, FileStore fileStore) {
        this.userProfileDataAccessStore = userProfileDataAccessStore;
        this.fileStore = fileStore;
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
        isFileEmpty(file);

        isFileTypeImage(file);

        UserProfile user = getUserProfileIfNoError(userProfileId);


        Map<String, String> metaData = extractMetaData(file);

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserProfileID());
        String filename = String.format("%s-%s", file.getName(), UUID.randomUUID());
        try {
            fileStore.save(path, filename, Optional.of(metaData), file.getInputStream());
        } catch (IOException error) {
            throw  new IllegalStateException(error);
        }


    }

    private Map<String, String> extractMetaData(MultipartFile file) {
        Map<String, String> metaData = new HashMap<>();
        metaData.put("Content-Type", file.getContentType());
        metaData.put("Content-Length", String.valueOf(file.getSize()));
        return metaData;
    }

    private UserProfile getUserProfileIfNoError(UUID userProfileId) {
        return userProfileDataAccessStore
                .getUserProfiles()
                .stream()
                .filter(userProfile ->
                    userProfile.getUserProfileID().equals(userProfileId)
                    )
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User profile not found"));
    }

    private void isFileTypeImage(MultipartFile file) {
        if(!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(), ContentType.IMAGE_PNG.getMimeType(), ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File should be image");
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Can not upload empty file" + "File size is " + file.getSize());
        }
    }
}
