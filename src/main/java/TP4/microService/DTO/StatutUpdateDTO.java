package TP4.microService.DTO;

import TP4.microService.Models.StatutVehicule;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StatutUpdateDTO {
    @NotNull(message = "Le statut est obligatoire")
    private StatutVehicule statut;
}
