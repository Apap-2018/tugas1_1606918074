package com.apap.tugas1.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class PegawaiCmd {
	private Long id;
    private String nip;
    private String nama;
    private String tempat_lahir;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggal_lahir;
    private String tahun_masuk;
    private Long id_instansi;
    private String instansi;
    private Long id_provinsi;

    public Long getId_provinsi() {
        return id_provinsi;
    }

    public void setId_provinsi(Long id_provinsi) {
        this.id_provinsi = id_provinsi;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    private Integer id_jabatan;
    private List<Integer> jabatan_Ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getTahun_masuk() {
        return tahun_masuk;
    }

    public void setTahun_masuk(String tahun_masuk) {
        this.tahun_masuk = tahun_masuk;
    }

    public Long getId_instansi() {
        return id_instansi;
    }

    public void setId_instansi(Long id_instansi) {
        this.id_instansi = id_instansi;
    }

    public Integer getId_jabatan() {
        return id_jabatan;
    }

    public void setId_jabatan(Integer id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public List<Integer> getJabatan_Ids() {
        return jabatan_Ids;
    }

    public void setJabatan_Ids(List<Integer> jabatan_Ids) {
        this.jabatan_Ids = jabatan_Ids;
    }
}
