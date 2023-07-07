package org.example.demo;

import java.io.Serializable;

/**
 * The LikedAnimalId class represents the composite key for the LikedAnimal entity.
 * It is used to uniquely identify the combination of profile and animal.
 * This class implements the Serializable interface to support serialization and deserialization.
 *
 * @author Julian Ertle
 */
public class LikedAnimalId implements Serializable {
    private int profile;
    private int animal;

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getAnimal() {
        return animal;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }
}