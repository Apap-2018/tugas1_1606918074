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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instansi")
    private int id;
	
	@NotBlank
	@Size(max=255)
	@Column(name="nama", nullable=false)
    private String nama;
	
	@NotBlank
	@Column(name="presentase_tunjangan", nullable=false)
    private double presentase_tunjangan;
}
