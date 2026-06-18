package TP4.microService.Repository;

import TP4.microService.Models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    boolean existsByNumMatricule(String numMatricule);
}
