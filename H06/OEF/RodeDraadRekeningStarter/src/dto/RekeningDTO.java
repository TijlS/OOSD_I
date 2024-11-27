package dto;

import java.math.BigDecimal;

public record RekeningDTO(long rekeningNummer, String houder, BigDecimal saldo) {

}
