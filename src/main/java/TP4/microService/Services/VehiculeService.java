package TP4.microService.Services;

import TP4.microService.DTO.StatutUpdateDTO;
import TP4.microService.DTO.VehiculeRequestDTO;
import TP4.microService.DTO.VehiculeResponseDTO;
import TP4.microService.Exceptions.ImmatriculationDejaUtiliseeException;
import TP4.microService.Exceptions.VehiculeNotFoundException;
import TP4.microService.Mapper.VehiculeMapper;
import TP4.microService.Models.Vehicule;
import TP4.microService.Repository.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    public List<VehiculeResponseDTO> findAll() {
        return vehiculeRepository.findAll().stream()
                .map(VehiculeMapper::toResponseDTO)
                .toList();
    }

    public VehiculeResponseDTO findById(Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new VehiculeNotFoundException(id));
        return VehiculeMapper.toResponseDTO(vehicule);
    }

    public VehiculeResponseDTO create(VehiculeRequestDTO dto) {
        if (vehiculeRepository.existsByNumMatricule(dto.getNumMatricule())) {
            throw new ImmatriculationDejaUtiliseeException(dto.getNumMatricule());
        }
        Vehicule saved = vehiculeRepository.save(VehiculeMapper.toEntity(dto));
        return VehiculeMapper.toResponseDTO(saved);
    }

    public VehiculeResponseDTO update(Long id, VehiculeRequestDTO dto) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new VehiculeNotFoundException(id));
        if (!vehicule.getNumMatricule().equals(dto.getNumMatricule())
                && vehiculeRepository.existsByNumMatricule(dto.getNumMatricule())) {
            throw new ImmatriculationDejaUtiliseeException(dto.getNumMatricule());
        }
        vehicule.setMarque(dto.getMarque());
        vehicule.setModele(dto.getModele());
        vehicule.setNumMatricule(dto.getNumMatricule());
        return VehiculeMapper.toResponseDTO(vehiculeRepository.save(vehicule));
    }

    public VehiculeResponseDTO updateStatut(Long id, StatutUpdateDTO dto) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new VehiculeNotFoundException(id));
        vehicule.setStatut(dto.getStatut());
        return VehiculeMapper.toResponseDTO(vehiculeRepository.save(vehicule));
    }

    public void delete(Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new VehiculeNotFoundException(id));
        vehiculeRepository.delete(vehicule);
    }
}
