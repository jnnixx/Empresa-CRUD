package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.*;

public class EmpregadoDTO {

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;
    @Email
    @NotBlank(message = "E-mail é obrigatório.")
    private String email;
    @NotNull(message = "Salário é obrigatório.")
    @Min(value = 1200, message = "Campo salário inválido.")
    @Max(value= 100000, message = "Campo salário inválido.")
    private Double salario;

    @NotNull
    private Integer idEndereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
}
