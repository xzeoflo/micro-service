package TP4.microService.DTO;

import TP4.microService.Models.Validators.ValidMatricule;
import TP4.microService.Models.Validators.ValidTexte;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehiculeRequestDTO {
    @ValidTexte(message = "La marque est invalide", min = 2, max = 50)
    private String marque;
    @ValidTexte(message = "Le modèle est invalide", min = 1, max = 50)
    private String modele;
    @ValidMatricule
    private String numMatricule;
}
