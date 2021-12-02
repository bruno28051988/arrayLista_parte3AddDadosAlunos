package com.example.arraylist_parte3adddadosalunos;

public class Aluno {

    private String name;
    private String address;
    private String email;

    public Aluno() {
    }

    public Aluno(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Aluno(Aluno a) {
        this.name = a.name;
        this.address = a.address;
        this.email = a.email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: " + name + '\n' +
                "Endereço : " + address + '\n' +
                "E-mail: " + email + '\n';
    }
}
