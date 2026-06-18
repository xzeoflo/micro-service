package TP4.microService.Controllers;

import TP4.microService.DTO.StatutUpdateDTO;
import TP4.microService.DTO.VehiculeRequestDTO;
import TP4.microService.DTO.VehiculeResponseDTO;
import TP4.microService.Services.VehiculeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicule")
public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping
    public List<VehiculeResponseDTO> getAll() {
        return vehiculeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculeResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<VehiculeResponseDTO> create(@Valid @RequestBody VehiculeRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculeResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody VehiculeRequestDTO dto) {
        return ResponseEntity.ok(vehiculeService.update(id, dto));
    }

    @PatchMapping("/{id}/statut")
    public ResponseEntity<VehiculeResponseDTO> updateStatut(
            @PathVariable Long id,
            @Valid @RequestBody StatutUpdateDTO dto) {
        return ResponseEntity.ok(vehiculeService.updateStatut(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehiculeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
