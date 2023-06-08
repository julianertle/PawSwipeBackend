package org.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikedAnimalService {
    private final LikedAnimalRepository likedAnimalRepository;

    @Autowired
    public LikedAnimalService(LikedAnimalRepository likedAnimalRepository) {
        this.likedAnimalRepository = likedAnimalRepository;
    }

    public void likeAnimal(int profileId, int animalId) {
        Profile profile = new Profile();
        profile.setProfile_id(profileId);

        Animal animal = new Animal();
        animal.setAnimalId(animalId);

        LikedAnimal likedAnimal = new LikedAnimal();
        likedAnimal.setProfile(profile);
        likedAnimal.setAnimal(animal);

        likedAnimalRepository.save(likedAnimal);
    }
}


