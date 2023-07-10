package org.example.backend;

import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * Represents an Animal entity in the system.
 *
 * @author Julian Ertle
 */

@Entity
@Table(name = "animal")
public class  Animal {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "animal_id")
    private int animal_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", nullable = false)
    private Profile profile_id;

    @Column(name = "species", length = 50)
    private String species;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "illness", length = 50)
    private String illness;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "breed", length = 50)
    private String breed;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "gender", length = 50)
    private String gender;

    @Column(name = "picture_one")
    private String picture_one;

    @Column(name = "picture_two")
    private String picture_two;

    @Column(name = "picture_three")
    private String picture_three;

    @Column(name = "picture_four")
    private String picture_four;

    @Column(name = "picture_five")
    private String picture_five;

    public Animal() {
        // no-arg constructor needed by JPA
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animalId) {
        this.animal_id = animalId;
    }

    public Profile getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Profile profile) {
        this.profile_id = profile;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAnimalId(Integer animalId) {
        this.animal_id = animalId;
    }

    public String getPicture_one() {
        return picture_one;
    }

    public void setPicture_one(String picture_one) {
        this.picture_one = picture_one;
    }

    public String getPicture_two() {
        return picture_two;
    }

    public void setPicture_two(String picture_two) {
        this.picture_two = picture_two;
    }

    public String getPicture_three() {
        return picture_three;
    }

    public void setPicture_three(String picture_three) {
        this.picture_three = picture_three;
    }

    public String getPicture_four() {
        return picture_four;
    }

    public void setPicture_four(String picture_four) {
        this.picture_four = picture_four;
    }

    public String getPicture_five() {
        return picture_five;
    }

    public void setPicture_five(String picture_five) {
        this.picture_five = picture_five;
    }

    public Animal(Profile profile_id, String species, String name, LocalDate birthday, String illness, String description,
                  String breed, String color, String gender, String picture_one, String picture_two, String picture_three, String picture_four, String picture_five) {
        this.profile_id = profile_id;
        this.species = species;
        this.name = name;
        this.birthday = birthday;
        this.illness = illness;
        this.description = description;
        this.breed = breed;
        this.color = color;
        this.gender = gender;
        this.picture_one = picture_one;
        this.picture_two = picture_two;
        this.picture_three = picture_three;
        this.picture_four = picture_four;
        this.picture_five = picture_five;
    }
}
