package org.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profile")
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;


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
                        existingProfile.setProfilePicture((byte[]) value);
                        break;
                    case "description":
                        existingProfile.setDescription((String) value);
                        break;
                    case "password":
                        existingProfile.setPassword((String) value);
                        break;
                    case "creation_date":
                        existingProfile.setCreationDate((Date) value);
                        break;
                    case "email":
                        existingProfile.setEmail((String) value);
                        break;
                    case "is_complete":
                        existingProfile.setComplete((int) value);
                        break;
                    case "birthday":
                        existingProfile.setBirthday((Date) value);
                        break;
                    case "phone_number":
                        existingProfile.setPhoneNumber((String) value);
                        break;
                    case "opening_hours":
                        existingProfile.setOpeningHours((String) value);
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
                        existingProfile.setStreetNumber((Integer) value);
                        break;
                    case "homepage":
                        existingProfile.setHomepage((String) value);
                        break;
                    case "postal_code":
                        existingProfile.setPostalCode((Integer) value);
                        break;
                    case "discriminator":
                        existingProfile.setDiscriminator((String) value);
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



    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable("id") Integer id) {
        Optional<Profile> profileOptional = profileRepository.findById(id);
        if (profileOptional.isPresent()) {
            return ResponseEntity.ok(profileOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/all/ids")
    public ResponseEntity<List<Integer>> getProfileIds() {
        List<Profile> profiles = profileRepository.findAll();
        List<Integer> ids = profiles.stream().map(Profile::getProfileId).collect(Collectors.toList());
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
