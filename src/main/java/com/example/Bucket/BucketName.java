package com.example.Bucket;

public enum BucketName {
    PROFILE_IMAGE("dimplesapp-1");
    private final String bucketName;

    /**
     * Constructor for bucket name
     * @param bucketName
     */
    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     *
     * @return bucketname
     */
    public String getBucketName() {
        return bucketName;
    }
}
