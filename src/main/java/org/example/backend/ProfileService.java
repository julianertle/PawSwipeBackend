package org.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The {@link ProfileService} class is a RESTful API controller responsible for handling profile-related operations.
 * It provides endpoints for creating, updating, retrieving, and deleting profiles.
 * The class is annotated with Spring's @RestController and @RequestMapping annotations to define the base URL
 * ("/profile") for all endpoints within this controller.
 * It uses the {@link ProfileRepository} bean for accessing the animal data from the database.
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
     * @param profile The profile object to create. The data field creation_date in the request will be ignored
     *                and replaced by the current date.
     * @return ResponseEntity<Void> indicating the success or failure of the operation.
     */
    @PostMapping("/create")
    public ResponseEntity<Void> createProfile(@RequestBody Profile profile) {
        // Set the current date as the creation date
        profile.setCreation_date(new Date(Calendar.getInstance().getTimeInMillis()));

        profileRepository.save(profile);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    /**
     * This endpoint allows you to update an existing profile with the specified ID.
     * The profile ID should be provided in the URL path, and the fields to update should be included in the request
     * body as a map of key-value pairs.
     *
     * @param id      The ID of the profile to update.
     * @param updates A map containing the fields to update and their new values.
     * @return ResponseEntity<Profile> indicating the success or failure of the operation.
     *         - If the profile is successfully updated, it returns a response with HTTP status code 200 (OK)
     *           and the updated profile in the response body.
     *         - If the specified profile does not exist, it returns a response with HTTP status code 404 (Not Found).
     *         - If an error occurs during the update process, it returns an appropriate error response.
     */
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
                    existingProfile.setProfile_picture((String) value);
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
                    existingProfile.setPostal_code((String) value);
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
                case "lat":
                    existingProfile.setLat((Double) value);
                    break;
                case "lon":
                    existingProfile.setLon((Double) value);
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


    /**
     * This endpoint allows you to retrieve a profile based on the specified ID.
     * The profile ID should be provided in the URL path.
     *
     * @param id The ID of the profile to retrieve.
     * @return ResponseEntity<Profile> indicating the success or failure of the operation.
     *         - If the profile is found, it returns a response with HTTP status code 200 (OK)
     *           and the profile object in the response body.
     *         - If the specified profile does not exist, it returns a response with HTTP status code 404 (Not Found).
     *         - If an error occurs during the retrieval process, it returns an appropriate error response.
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable("id") Integer id) {
        Optional<Profile> profileOptional = profileRepository.findById(id);
        if (profileOptional.isPresent()) {
            return ResponseEntity.ok(profileOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * This endpoint allows you to retrieve a profile based on the specified email.
     * The email should be provided in the URL path.
     *
     * @param email The email of the profile to retrieve.
     * @return ResponseEntity<Profile> indicating the success or failure of the operation.
     *         - If the profile is found, it returns a response with HTTP status code 200 (OK)
     *           and the profile object in the response body.
     *         - If the specified profile does not exist, it returns a response with HTTP status code 404 (Not Found).
     *         - If an error occurs during the retrieval process, it returns an appropriate error response.
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<Profile> getProfileByEmail(@PathVariable String email) {
        Profile profile = profileRepository.findByEmail(email);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * This endpoint allows you to retrieve the IDs of all profiles.
     *
     * @return ResponseEntity<List<Integer>> indicating the success or failure of the operation.
     *         - If the profiles are found, it returns a response with HTTP status code 200 (OK)
     *           and a list of profile IDs in the response body.
     *         - If no profiles are found, it returns an empty list in the response body.
     *         - If an error occurs during the retrieval process, it returns an appropriate error response.
     */
    @GetMapping("/all/ids")
    public ResponseEntity<List<Integer>> getProfileIds() {
        List<Profile> profiles = profileRepository.findAll();
        List<Integer> ids = profiles.stream().map(Profile::getProfile_id).collect(Collectors.toList());
        return ResponseEntity.ok(ids);
    }

    /**
     * This endpoint allows you to delete a profile based on the specified ID.
     * The profile ID should be provided in the URL path.
     *
     * @param id The ID of the profile to delete.
     * @return ResponseEntity<Void> indicating the success or failure of the operation.
     *         - If the profile is found and successfully deleted, it returns a response with HTTP status code 200 (OK).
     *         - If the specified profile does not exist, it returns a response with HTTP status code 404 (Not Found).
     *         - If an error occurs during the deletion process, it returns an appropriate error response.
     */
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
