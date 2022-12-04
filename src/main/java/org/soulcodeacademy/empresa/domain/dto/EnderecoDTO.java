package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnderecoDTO {

    @NotBlank(message = "Campo cidade é obrigatório.")
    private String cidade;

    @NotBlank(message = "Campo uf é obrigatório.")
    private String uf;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
