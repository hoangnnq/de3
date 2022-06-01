package com.example.onthi3;

public class Phong_User {

    private Integer Id;
    private String HoTen;
    private int SoPhong;
    private int DonGia;
    private int SoNgayLuuTru;

    public Phong_User(Integer id, String hoTen, int soPhong, int donGia, int soNgayLuuTru) {
        Id = id;
        HoTen = hoTen;
        SoPhong = soPhong;
        DonGia = donGia;
        SoNgayLuuTru = soNgayLuuTru;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public int getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(int soPhong) {
        SoPhong = soPhong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int donGia) {
        DonGia = donGia;
    }

    public int getSoNgayLuuTru() {
        return SoNgayLuuTru;
    }

    public void setSoNgayLuuTru(int soNgayLuuTru) {
        SoNgayLuuTru = soNgayLuuTru;
    }
}
