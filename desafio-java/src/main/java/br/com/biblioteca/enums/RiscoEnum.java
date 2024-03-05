package br.com.biblioteca.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
// @JsonFormat(shape = JsonFormat.Shape.STRING)
public enum RiscoEnum {

    BAIXO_RISCO("Baixo risco"),
    MEDIO_RISCO("Médio risco"),
    ALTO_RISCO("Alto risco");

    private String label;

    @JsonValue
    public String toValue() {
        return label;
    }
}
