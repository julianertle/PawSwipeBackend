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

        Optional<Profile> existingProfileOptional = profileRepository.findById(id);
        if (!existingProfileOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Profile existingProfile = existingProfileOptional.get();

        // Update each field that was specified in the request body
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            switch (key) {

                case "firstname":
                    existingProfile.setFirstname((String) value);
                    break;
                case "lastname":
                    existingProfile.setLastname((String) value);
                    break;
                case "profilepicture":
                    existingProfile.setProfilepicture((String) value);
                    break;
                case "description":
                    existingProfile.setDescription((String) value);
                    break;
                case "password":
                    existingProfile.setPassword((String) value);
                    break;
                case "creationdate":
                    existingProfile.setCreationdate(((Date) value).toLocalDate());
                    break;
                case "phonenumber":
                    existingProfile.setPhonenumber((String) value);
                    break;
                case "country":
                    existingProfile.setCountry((String) value);
                    break;
                case "postalcode":
                    existingProfile.setPostalcode((String) value);
                    break;
                case "city":
                    existingProfile.setCity((String) value);
                    break;
                case "street":
                    existingProfile.setStreet((String) value);
                    break;
                case "streetnumber":
                    existingProfile.setStreetnumber((String) value);
                    break;
                case "birthday":
                    existingProfile.setBirthday(((Date) value).toLocalDate());
                    break;
                case "openinghours":
                    existingProfile.setOpeninghours((String) value);
                    break;
                case "homepage":
                    existingProfile.setHomepage((String) value);
                    break;
                case "discriminator":
                    existingProfile.setDiscriminator((String) value);
                    break;
                case "email":
                    existingProfile.setEmail((String) value);
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
        List<Integer> ids = profiles.stream().map(Profile::getProfileid).collect(Collectors.toList());
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
