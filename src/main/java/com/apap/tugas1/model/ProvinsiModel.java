package com.apap.tugas1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="provinsi")
public class ProvinsiModel implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(max=10)
	@Column(name="id", nullable=false)
	private int id;
	
	@NotBlank
	@Size(max=255)
	@Column(name="nama", nullable=false)
    public String nama;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public double getPresentase_tunjangan() {
		return presentase_tunjangan;
	}

	public void setPresentase_tunjangan(double presentase_tunjangan) {
		this.presentase_tunjangan = presentase_tunjangan;
	}

	@NotBlank
	@Column(name="presentase_tunjangan", nullable=false)
    public double presentase_tunjangan;
}
