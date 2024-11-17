package dto;

// Automatisch getters, geen setters
// --> Immutable
public record SpelerDTO(String naam, String voornaam, boolean adminrechten, int krediet) {

}
