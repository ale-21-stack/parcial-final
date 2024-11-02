package controller;

import lombok.Getter;
import lombok.Setter;
import model.DnaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service1.MutantService;

import java.util.Arrays;


@Getter
@Setter
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mutant")
public class MutantController {
        private final MutantService mutantService;

        @Autowired
        public MutantController(MutantService mutantService ) {
            this.mutantService = mutantService;
        }

        @PostMapping
        public ResponseEntity<?> detectMutant(@RequestBody DnaRequest DnaRequest) {
            model.DnaRequest dnaRequest = new DnaRequest();
            String[] dna = new String[]{Arrays.toString(dnaRequest.getDna())};

            try {
                boolean isMutant = mutantService.isMutant(dna);
                if (isMutant) {
                    mutantService.save(dnaRequest);
                    return ResponseEntity.ok("Es un mutante");  // HTTP 200 OK
                } else {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No es un mutante");  // HTTP 403 Forbidden
                }
            } catch (NullPointerException e) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("El ADN está vacío");
            } catch (ArrayIndexOutOfBoundsException e) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("El ADN no tiene un tamaño de NxN");
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Alguna de las letras del ADN no corresponde con una de las válidas");
            } catch (DataIntegrityViolationException e) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("EL ADN ingresado ya se encuentra en la base de datos");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"error\":\"Error, por favor intente más tarde\"}");
            }
        }


    }


