package com.example.ImageUpload.Profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * User Profile Model
 */
public class UserProfile {
    private UUID userProfileID;
    private String userName;
    private String userProfileLink;

    public UserProfile(UUID userProfileID, String userName, String userProfileLink) {
        this.userProfileID = userProfileID;
        this.userName = userName;
        this.userProfileLink = userProfileLink;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Optional<String> getUserProfileLink() {
        return Optional.ofNullable(userProfileLink);
    }

    public void setUserProfileLink(String userProfileLink) {
        this.userProfileLink = userProfileLink;
    }

    public UUID getUserProfileID() {
        return userProfileID;
    }

    public void setUserProfileID(UUID userProfileID) {
        this.userProfileID = userProfileID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userProfileID, that.userProfileID) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userProfileLink, that.userProfileLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileID, userName, userProfileLink);
    }
}
