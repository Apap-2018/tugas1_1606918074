package com.apap.tugas1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="jabatan_pegawai")
public class JabatanPegawaiModel implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
    private Long id;
	
	@NotNull
	@JoinColumn(name="id")
	private Long id_pegawai;
	
	@NotNull
	@JoinColumn(name="id")
	private Long id_jabatan;

	private Long gaji_pokok;

	private String namaJabatan;

	public String getNamaJabatan() {
		return namaJabatan;
	}

	public void setNamaJabatan(String namaJabatan) {
		this.namaJabatan = namaJabatan;
	}

	public Long getGaji_pokok() {

		return gaji_pokok;
	}

	public void setGaji_pokok(Long gaji_pokok) {
		this.gaji_pokok = gaji_pokok;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_pegawai() {
		return id_pegawai;
	}

	public void setId_pegawai(Long id_pegawai) {
		this.id_pegawai = id_pegawai;
	}

	public Long getId_jabatan() {
		return id_jabatan;
	}

	public void setId_jabatan(Long id_jabatan) {
		this.id_jabatan = id_jabatan;
	}
	//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="id_pegawai")
//	private PegawaiModel pegawai;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="id_jabatan")
//	private JabatanModel jabatan;
}
