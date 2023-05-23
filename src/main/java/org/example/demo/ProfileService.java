package org.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The {@link ProfileService} class is a RESTful API controller responsible for handling profile-related operations.
 * It provides endpoints for creating, updating, retrieving, and deleting profiles.
 * The class is annotated with Spring's @RestController and @RequestMapping annotations to define the base URL
 * ("/profile") for all endpoints within this controller.
 *
 * @author Julian Ertle
 */
@RestController
@RequestMapping("/profile")
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    /**
     * This endpoint allows you to create a new profile by sending a POST request to "/profile/create".
     * The request body should contain a JSON representation of the profile to be created.
     * @param profile The profile object to create.
     * @return ResponseEntity<Void> indicating the success or failure of the operation.
     */
    @PostMapping("/create")
    public ResponseEntity<Void> createProfile(@RequestBody Profile profile) {
        profileRepository.save(profile);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") int id, @RequestBody Map<String, Object> updates) {

        Profile existingProfile = profileRepository.getById(id);

        // Update each field that was specified in the request body
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            switch (key) {
                case "username":
                    existingProfile.setUsername((String) value);
                    break;
                case "profile_picture":
                    String base64String = (String) value;
                    byte[] pictureData = Base64.getDecoder().decode(base64String);
                    existingProfile.setProfile_picture(pictureData);
                    break;
                case "description":
                    existingProfile.setDescription((String) value);
                    break;
                case "password":
                    existingProfile.setPassword((String) value);
                    break;
                case "creation_date":
                    existingProfile.setCreation_date((Date) value);
                    break;
                case "email":
                    existingProfile.setEmail((String) value);
                    break;
                case "birthday":
                    existingProfile.setBirthday((Date) value);
                    break;
                case "phone_number":
                    existingProfile.setPhone_number((String) value);
                    break;
                case "opening_hours":
                    existingProfile.setOpening_hours((String) value);
                    break;
                case "street":
                    existingProfile.setStreet((String) value);
                    break;
                case "country":
                    existingProfile.setCountry((String) value);
                    break;
                case "city":
                    existingProfile.setCity((String) value);
                    break;
                case "street_number":
                    existingProfile.setStreet_number((String) value);
                    break;
                case "homepage":
                    existingProfile.setHomepage((String) value);
                    break;
                case "postal_code":
                    existingProfile.setPostal_code((Integer) value);
                    break;
                case "discriminator":
                    existingProfile.setDiscriminator((String) value);
                    break;
                case "firstname":
                    existingProfile.setFirstname((String) value);
                    break;
                case "lastname":
                    existingProfile.setLastname((String) value);
                    break;
                default:
                    // Ignore any unknown fields
                    break;
            }
        }

        // Save the updated profile and return it in the response
        Profile updatedProfile = profileRepository.save(existingProfile);
        return ResponseEntity.ok(updatedProfile);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable("id") Integer id) {
        Optional<Profile> profileOptional = profileRepository.findById(id);
        if (profileOptional.isPresent()) {
            return ResponseEntity.ok(profileOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Profile> getProfileByEmail(@PathVariable String email) {
        Profile profile = profileRepository.findByEmail(email);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all/ids")
    public ResponseEntity<List<Integer>> getProfileIds() {
        List<Profile> profiles = profileRepository.findAll();
        List<Integer> ids = profiles.stream().map(Profile::getProfile_id).collect(Collectors.toList());
        return ResponseEntity.ok(ids);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable("id") int id) {
        Optional<Profile> profileOptional = profileRepository.findById(id);
        if (profileOptional.isPresent()) {
            profileRepository.delete(profileOptional.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
