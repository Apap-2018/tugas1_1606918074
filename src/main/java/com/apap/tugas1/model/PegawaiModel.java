package com.apap.tugas1.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "pegawai")
public class PegawaiModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    public Long id;

    @NotBlank
    @Size(max=255)
	@Column(name="nip", nullable=false, unique=true)
    public String nip;

    @NotBlank
    @Size(max=255)
	@Column(name="nama", nullable=false)
    public String nama;

    @NotBlank
    @Size(max=255)
	@Column(name="tempat_lahir", nullable=false)
    public String tempat_lahir;

    @NotNull
	@Column(name="tanggal_lahir", nullable=false)
    public Date tanggal_lahir;

    @NotBlank
    @Size(max=255)
	@Column(name="tahun_masuk", nullable=false)
    public String tahun_masuk;

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

    @NotNull(message = "please insert id")
    public Long id_instansi;

//    @OneToMany(mappedBy = "pegawai")
//    public List<JabatanPegawaiModel> jabatanList;

    public String jabatanfull;

    public String getJabatanfull() {
        return jabatanfull;
    }

    public void setJabatanfull(String jabatanfull) {
        this.jabatanfull = jabatanfull;
    }
}