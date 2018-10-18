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
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="jabatan_pegawai")
public class JabatanPegawaiModel implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(max=20)
	@Column(name="id", nullable=false)
    private Long id;
	
	@NotBlank
	@Size(max=20)
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id")
	@Column(name="id_pegawai", nullable=false)
    private Long id_pegawai;
	
	@NotBlank
	@Size(max=20)
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id")
	@Column(name="id_jabatan", nullable=false)
    private Long id_jabatan;
}
