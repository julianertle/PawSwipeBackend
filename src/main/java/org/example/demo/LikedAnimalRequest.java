package org.example.demo;
public class LikedAnimalRequest {
    private int profile_Id;
    private int animal_Id;

    public LikedAnimalRequest() {
    }

    public LikedAnimalRequest(int profile_Id, int animal_Id) {
        this.profile_Id = profile_Id;
        this.animal_Id = animal_Id;
    }

    public int getProfile_Id() {
        return profile_Id;
    }

    public void setProfile_Id(int profile_Id) {
        this.profile_Id = profile_Id;
    }

    public int getAnimal_Id() {
        return animal_Id;
    }

    public void setAnimal_Id(int animal_Id) {
        this.animal_Id = animal_Id;
    }
}
