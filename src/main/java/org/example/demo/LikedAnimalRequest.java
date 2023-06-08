package org.example.demo;

public class LikedAnimalRequest {
    private int profileId;
    private int animalId;

    public LikedAnimalRequest() {
    }

    public LikedAnimalRequest(int profileId, int animalId) {
        this.profileId = profileId;
        this.animalId = animalId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
}

