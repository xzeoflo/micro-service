package TP4.microService.Mapper;

import TP4.microService.DTO.VehiculeRequestDTO;
import TP4.microService.DTO.VehiculeResponseDTO;
import TP4.microService.Models.Vehicule;

public class VehiculeMapper {

    private VehiculeMapper() {}

    public static Vehicule toEntity(VehiculeRequestDTO dto) {
        return new Vehicule(dto.getMarque(), dto.getModele(), dto.getNumMatricule());
    }

    public static VehiculeResponseDTO toResponseDTO(Vehicule vehicule) {
        return new VehiculeResponseDTO(
                vehicule.getId(),
                vehicule.getMarque(),
                vehicule.getModele(),
                vehicule.getNumMatricule(),
                vehicule.getStatut()
        );
    }
}
