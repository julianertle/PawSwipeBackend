package org.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * The LikedAnimalController class handles HTTP requests related to liked animals.
 *
 * @author Julian Ertle
 */
@RestController
@RequestMapping("/liked-animals")
public class LikedAnimalController {
    private final LikedAnimalService likedAnimalService;

    /**
     * Constructs a new instance of LikedAnimalController with the provided LikedAnimalService.
     *
     * @param likedAnimalService The LikedAnimalService to be used by the controller.
     */
    @Autowired
    public LikedAnimalController(LikedAnimalService likedAnimalService) {
        this.likedAnimalService = likedAnimalService;
    }

    /**
     * Handles a POST request to like an animal.
     *
     * @param likedAnimalRequest The request object containing the profile ID and animal ID to like.
     * @return A ResponseEntity with the appropriate HTTP status and a response message.
     */
    @PostMapping("/like")
    public ResponseEntity<String> likeAnimal(@RequestBody LikedAnimalRequest likedAnimalRequest) {

            int profileId = likedAnimalRequest.getProfile_id();
            int animalId = likedAnimalRequest.getAnimal_id();

            likedAnimalService.likeAnimal(profileId, animalId);

            return ResponseEntity.status(HttpStatus.OK).body("Animal liked successfully");


    }

    /**
     * Handles a DELETE request to dislike an animal.
     *
     * @param likedAnimalRequest The request object containing the profile ID and animal ID to dislike.
     * @return A ResponseEntity with the appropriate HTTP status and a response message.
     */
    @DeleteMapping("/dislike")
    public ResponseEntity<String> dislikeAnimal(@RequestBody LikedAnimalRequest likedAnimalRequest) {
        try {
            int profileId = likedAnimalRequest.getProfile_id();
            int animalId = likedAnimalRequest.getAnimal_id();

            likedAnimalService.dislikeAnimal(profileId, animalId);

            return ResponseEntity.status(HttpStatus.OK).body("Animal disliked successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * Handles a GET request to retrieve a list of liked animal IDs for a specific profile.
     *
     * @param profileId The ID of the profile to retrieve the liked animal IDs for.
     * @return A ResponseEntity with the appropriate HTTP status and a list of liked animal IDs.
     */
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
