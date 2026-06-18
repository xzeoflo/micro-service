package TP4.microService.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marque;
    private String modele;
    @Column(unique = true, nullable = false)
    private String numMatricule;
    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    public Vehicule(String marque, String modele, String numMatricule) {
        this.marque = marque;
        this.modele = modele;
        this.numMatricule = numMatricule;
        this.statut = StatutVehicule.AVAILABLE;
    }
}
