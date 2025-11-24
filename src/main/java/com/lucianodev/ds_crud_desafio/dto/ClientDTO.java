package com.lucianodev.ds_crud_desafio.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.lucianodev.ds_crud_desafio.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;

    @NotBlank(message = "O nome não pode está vázio.")
    @Size(min = 3, max = 100)
    private String name;
    private String cpf;
    private Double income;

    @PastOrPresent(message = "Data de nascimento não pode ser data futura")
    private LocalDate birthDate;
    private Integer children;


    public ClientDTO() {
    }

    @JsonCreator
    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client entity){
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
