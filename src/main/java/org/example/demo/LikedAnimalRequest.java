package org.example.demo;

/**
 * The LikedAnimalRequest class represents a request object for liking or disliking an animal.
 * It encapsulates the profile ID and animal ID.
 *
 * @author Julian Ertle
 */
public class LikedAnimalRequest {
    private int profile_id;
    private int animal_id;


    public LikedAnimalRequest() {
    }

    public LikedAnimalRequest(int profile_id, int animal_id) {
        this.profile_id = profile_id;
        this.animal_id = animal_id;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }
}
