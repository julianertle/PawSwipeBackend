package org.example.demo;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "animal")
public class Animal {

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

    public Animal() {
        // no-arg constructor needed by JPA
    }

    public Animal(Profile profile_id, String species, String name, LocalDate birthday, String illness, String description, String breed, String color, String gender) {
        this.profile_id = profile_id;
        this.species = species;
        this.name = name;
        this.birthday = birthday;
        this.illness = illness;
        this.description = description;
        this.breed = breed;
        this.color = color;
        this.gender = gender;
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

}
