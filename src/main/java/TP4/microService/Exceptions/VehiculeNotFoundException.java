package TP4.microService.Exceptions;

public class VehiculeNotFoundException extends RuntimeException {
    public VehiculeNotFoundException(Long id) {
        super("Aucun véhicule trouvé avec l'id " + id);
    }
}
