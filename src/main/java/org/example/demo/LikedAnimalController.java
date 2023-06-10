package org.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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

            int profileId = likedAnimalRequest.getProfile_id();
            int animalId = likedAnimalRequest.getAnimal_id();

            likedAnimalService.likeAnimal(profileId, animalId);

            return ResponseEntity.status(HttpStatus.OK).body("Animal liked successfully");


    }

    @DeleteMapping("/unlike")
    public ResponseEntity<String> unlikeAnimal(@RequestBody LikedAnimalRequest likedAnimalRequest) {
        try {
            int profileId = likedAnimalRequest.getProfile_id();
            int animalId = likedAnimalRequest.getAnimal_id();

            likedAnimalService.unlikeAnimal(profileId, animalId);

            return ResponseEntity.status(HttpStatus.OK).body("Animal unliked successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/list/{profileId}")
    public ResponseEntity<List<Integer>> getLikedAnimalIds(@PathVariable int profileId) {
        try {
            List<Integer> likedAnimalIds = likedAnimalService.getLikedAnimalIds(profileId);
            return ResponseEntity.status(HttpStatus.OK).body(likedAnimalIds);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
