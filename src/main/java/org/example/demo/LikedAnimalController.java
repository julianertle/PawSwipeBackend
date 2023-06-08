package org.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/liked-animals")
public class LikedAnimalController {
    private final LikedAnimalService likedAnimalService;

    @Autowired
    public LikedAnimalController(LikedAnimalService likedAnimalService) {
        this.likedAnimalService = likedAnimalService;
    }

    @PostMapping("/like")
    public ResponseEntity<String> likeAnimal(@RequestBody LikedAnimalRequest likedAnimalRequest) {
        try {
            int profileId = likedAnimalRequest.getProfileId();
            int animalId = likedAnimalRequest.getAnimalId();

            // Add your logic to handle the 'like' action
            likedAnimalService.likeAnimal(profileId, animalId);

            // Return a response with a success message
            return ResponseEntity.status(HttpStatus.OK).body("Animal liked successfully");
        }
        catch (Exception e) {
            // Handle other exceptions and return a general error message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
