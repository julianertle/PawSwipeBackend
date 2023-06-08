package org.example.demo;

import java.io.Serializable;

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

    // Add constructors, equals, and hashCode methods
}