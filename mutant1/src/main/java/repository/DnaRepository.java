package repository;

import model.DnaRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DnaRepository extends JpaRepository<DnaRequest, Long> {
    Optional<DnaRequest> findByDna(String[] dna);
    long countByEsMutant(boolean esMutant);

    long countByIsMutant(boolean b);
}
