package com.example.miaprimaapplicazione;

public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private Long dataNascita;

    public Utente(String nome, String cognome, String email, String password, Long dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.dataNascita = dataNascita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Long getDataNascita() {
        return dataNascita;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
