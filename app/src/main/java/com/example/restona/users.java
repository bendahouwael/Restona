package com.example.restona;

public class users {
    String userId;
    String email;
    int solde;


    public users(String userId, String email, int solde) {
        this.userId = userId;
        this.email = email;
        this.solde = solde;
    }

    public users() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
}

