package org.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The LikedAnimal class represents a mapping entity that represents the liking relationship
 * between a Profile and an Animal.
 *
 * @author Julian Ertle
 */
@Entity
@Table(name = "liked_animals")
@IdClass(LikedAnimalId.class)
public class LikedAnimal {
    @Id
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Id
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
