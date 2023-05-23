package org.example.demo;

import org.example.demo.exceptionHandeling.AnimalServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * {@link AnimalService} is a RESTful API controller class that handles operations related to animals.
 * This class provides endpoints for creating, updating, retrieving, and deleting animals.
 * The class is annotated with Spring's @RestController and @RequestMapping annotations to define the base URL
 * ("/animal") for all endpoints within this controller.
 * It uses the {@link AnimalRepository} bean for accessing the animal data from the database.
 *
 * @author Julian Ertle
 */
@RestController
@RequestMapping("/animal")
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    /**
     * This endpoint allows you to create a new animal by providing the animal object in the request body.
     *
     * @param animal The animal object containing the details of the animal to be created.
     * @return ResponseEntity<Void> indicating the success or failure of the operation.
     *         - If the animal is created successfully, it returns a response with HTTP status code 201 (Created).
     *         - If an error occurs during the creation process, it throws an AnimalServiceException.
     */
    @PostMapping("/create")
    public ResponseEntity<Void> createAnimal(@RequestBody Animal animal) {
        try {
            animalRepository.save(animal);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception ex) {
            throw new AnimalServiceException("Error creating animal: " + ex.getMessage());
        }
    }

    /**
     * This endpoint allows you to update an existing animal based on the specified ID.
     * The animal ID should be provided in the URL path, and the updates should be provided
     * in the request body as a map of field names and their corresponding values.
     *
     * @param id      The ID of the animal to update.
     * @param updates A map containing the field names and their corresponding updated values.
     * @return ResponseEntity<Animal> indicating the success or failure of the operation.
     *         - If the animal is updated successfully, it returns a response with HTTP status code 200 (OK)
     *           and the updated animal object in the response body.
     *         - If the specified animal does not exist, it returns a response with HTTP status code 404 (Not Found).
     *         - If the provided update values are invalid or an error occurs during the update process,
     *           it throws an AnimalServiceException.
     */
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
                            existingAnimal.setProfile_id((Profile) value);
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
                    case "picture_one":
                        String base64StringOne = (String) value;
                        byte[] pictureDataOne = Base64.getDecoder().decode(base64StringOne);
                        existingAnimal.setPicture_one(pictureDataOne);
                        break;
                    case "picture_two":
                        String base64StringTwo = (String) value;
                        byte[] pictureDataTwo = Base64.getDecoder().decode(base64StringTwo);
                        existingAnimal.setPicture_two(pictureDataTwo);
                        break;
                    case "picture_three":
                        String base64StringThree = (String) value;
                        byte[] pictureDataThree = Base64.getDecoder().decode(base64StringThree);
                        existingAnimal.setPicture_three(pictureDataThree);
                        break;
                    case "picture_four":
                        String base64StringFour = (String) value;
                        byte[] pictureDataFour = Base64.getDecoder().decode(base64StringFour);
                        existingAnimal.setPicture_four(pictureDataFour);
                        break;
                    case "picture_five":
                        String base64StringFive = (String) value;
                        byte[] pictureDataFive = Base64.getDecoder().decode(base64StringFive);
                        existingAnimal.setPicture_five(pictureDataFive);
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


    /**
     * This endpoint allows you to retrieve an animal based on the specified ID.
     * The animal ID should be provided in the URL path.
     *
     * @param id The ID of the animal to retrieve.
     * @return ResponseEntity<Animal> indicating the success or failure of the operation.
     *         - If the animal is found, it returns a response with HTTP status code 200 (OK)
     *           and the animal object in the response body.
     *         - If the specified animal does not exist, it returns a response with HTTP status code 404 (Not Found).
     *         - If an error occurs during the retrieval process, it throws an AnimalServiceException.
     */
    @GetMapping("/id/{id}")
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

    /**
     * This endpoint allows you to retrieve the IDs of all animals.
     *
     * @return ResponseEntity<List<Integer>> indicating the success or failure of the operation.
     *         - If the animals are found, it returns a response with HTTP status code 200 (OK)
     *           and a list of animal IDs in the response body.
     *         - If no animals are found, it returns an empty list in the response body.
     *         - If an error occurs during the retrieval process, it throws an AnimalServiceException.
     */
    @GetMapping("/all/ids")
    public ResponseEntity<List<Integer>> getAnimalIds() throws AnimalServiceException {
        List<Animal> animals;
        animals = animalRepository.findAll();
        List<Integer> ids = animals.stream().map(Animal::getAnimal_id).collect(Collectors.toList());
        return ResponseEntity.ok(ids);
    }

    /**
     * This endpoint allows you to delete an animal based on the specified ID.
     * The animal ID should be provided in the URL path.
     *
     * @param id The ID of the animal to delete.
     * @return ResponseEntity<Void> indicating the success or failure of the operation.
     *         - If the animal is found and successfully deleted, it returns a response with HTTP status code 200 (OK).
     *         - If the specified animal does not exist, it returns a response with HTTP status code 404 (Not Found).
     *         - If an error occurs during the deletion process, it returns an appropriate error response.
     */
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
