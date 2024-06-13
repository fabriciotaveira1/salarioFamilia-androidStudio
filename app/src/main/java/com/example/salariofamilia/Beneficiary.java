package com.example.salariofamilia;

public class Beneficiary {

    private int beneficiarioID;
    private String nome;
    private String cpf;
    private String dataNascimento;

    // Getters and Setters
    public int getBeneficiarioID() {
        return beneficiarioID;
    }

    public void setBeneficiarioID(int beneficiarioID) {
        this.beneficiarioID = beneficiarioID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return nome;
    }

}
