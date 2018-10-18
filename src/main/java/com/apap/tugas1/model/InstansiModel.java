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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="instansi")
public class InstansiModel implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(max=20)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pegawai")
	@Column(name="id", nullable=false)
    private Long id;
	
	@NotBlank
	@Size(max=255)
	@Column(name="nama", nullable=false)
    private String nama;
	
	@NotBlank
	@Size(max=255)
	@Column(name="deskripsi", nullable=false)
    private String deskripsi;
	
	@NotBlank
	@ManyToOne (fetch = FetchType.LAZY)	
	@JoinColumn(name="id_provinsi", referencedColumnName="id")
	@Size(max=20)
	@Column(name="id_provinsi", nullable=false)
    private Long id_provinsi;
}
