package com.rizaluardi.ppsdt1184102.model;

public class Dosen {
    private int id;
    private String dosen;
    private String nik;

    public Dosen() {
    }

    public Dosen(String dosen, String nik) {
        this.dosen = dosen;
        this.nik = nik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }
}