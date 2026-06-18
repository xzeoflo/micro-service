package TP4.microService.Exceptions;

public class ImmatriculationDejaUtiliseeException extends RuntimeException {
    public ImmatriculationDejaUtiliseeException(String numMatricule) {
        super("Le numéro d'immatriculation '" + numMatricule + "' est déjà utilisé");
    }
}
