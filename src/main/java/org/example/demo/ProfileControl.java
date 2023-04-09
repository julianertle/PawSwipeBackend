package org.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profile")
public class ProfileControl {

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping("/create")
    public ResponseEntity<Void> createProfile(@RequestBody Profile profile) {
        profileRepository.save(profile);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable("id") int id) {
        Optional<Profile> profileOptional = profileRepository.findById((long) id);
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
        Optional<Profile> profileOptional = profileRepository.findById((long) id);
        if (profileOptional.isPresent()) {
            profileRepository.delete(profileOptional.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
