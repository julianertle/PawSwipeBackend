package org.example.demo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


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

    @Transactional
    public void unlikeAnimal(int profileId, int animalId) throws NotFoundException {
        LikedAnimal likedAnimal = likedAnimalRepository.findByProfileIdAndAnimalId(profileId, animalId);
        if (likedAnimal == null) {
            throw new NotFoundException("Liked animal not found for profileId: " + profileId + " and animalId: " + animalId);
        }
        likedAnimalRepository.deleteByProfileIdAndAnimalId(profileId, animalId);
    }

    public List<Integer> getLikedAnimalIds(int profileId) {
        List<LikedAnimal> likedAnimals = likedAnimalRepository.findByProfileId(profileId);
        List<Integer> likedAnimalIds = new ArrayList<>();

        for (LikedAnimal likedAnimal : likedAnimals) {
            likedAnimalIds.add(likedAnimal.getAnimal().getAnimal_id());
        }
        return likedAnimalIds;
    }
}


