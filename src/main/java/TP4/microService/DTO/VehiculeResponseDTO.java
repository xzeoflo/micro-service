package TP4.microService.DTO;

import TP4.microService.Models.StatutVehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeResponseDTO {
    private Long id;
    private String marque;
    private String modele;
    private String numMatricule;
    private StatutVehicule statut;
}
