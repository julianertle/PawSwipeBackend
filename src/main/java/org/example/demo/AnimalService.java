package org.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal")
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping("/create")
    public ResponseEntity<Void> createAnimal(@RequestBody Animal animal) {
        try {
            animalRepository.save(animal);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception ex) {
            throw new AnimalServiceException("Error creating animal: " + ex.getMessage());
        }
    }

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @PutMapping("/update/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable(value = "id") int id, @RequestBody Map<String, Object> updates) {
        try {
            Animal existingAnimal = animalRepository.getById(id);

            // Update each field that was specified in the request body
            for (Map.Entry<String, Object> entry : updates.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                switch (key) {

                    case "profile":
                        if (value instanceof Profile) {
                            existingAnimal.setProfile((Profile) value);
                        } else {
                            throw new IllegalArgumentException("Value for 'profile' must be of type Profile.");
                        }
                        break;

                    case "species":
                        existingAnimal.setSpecies((String) value);
                        break;
                    case "name":
                        existingAnimal.setName((String) value);
                        break;
                    case "birthday":
                        existingAnimal.setBirthday((LocalDate) value);
                        break;
                    case "illness":
                        existingAnimal.setIllness((String) value);
                        break;
                    case "description":
                        existingAnimal.setDescription((String) value);
                        break;
                    case "breed":
                        existingAnimal.setBreed((String) value);
                        break;
                    case "color":
                        existingAnimal.setColor((String) value);
                        break;
                    case "gender":
                        existingAnimal.setGender((String) value);
                        break;
                    default:
                        // Ignore any unknown fields
                        break;
                }
            }

            // Save the updated animal and return it in the response
            Animal updatedAnimal = animalRepository.save(existingAnimal);
            return ResponseEntity.ok(updatedAnimal);
        } catch (Exception ex) {
            throw new AnimalServiceException("Error updating animal: " + ex.getMessage());
        }
    }





    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable("id") int id)  {
        try {
            Optional<Animal> animalOptional = animalRepository.findById(id);
            if (animalOptional.isPresent()) {
                return ResponseEntity.ok(animalOptional.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            throw new AnimalServiceException("Error getting animal: " + ex.getMessage());
        }
    }

    @GetMapping("/all/ids")
    public ResponseEntity<List<Integer>> getAnimalIds() throws AnimalServiceException {
        List<Animal> animals;
        animals = animalRepository.findAll();
        List<Integer> ids = animals.stream().map(Animal::getAnimalId).collect(Collectors.toList());
        return ResponseEntity.ok(ids);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable("id") int id) {
        try {
            Optional<Animal> animalOptional = animalRepository.findById(id);
            if (animalOptional.isPresent()) {
                animalRepository.delete(animalOptional.get());
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            throw new AnimalServiceException("Error deleting animal: " + ex.getMessage());
        }
    }
}
