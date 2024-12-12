package dto;

public record RekeningDTO(long rekeningnummer, double saldo, String houder, double maxKredietOnderNul,
		double aangroeiIntrest, char soort) {

}
