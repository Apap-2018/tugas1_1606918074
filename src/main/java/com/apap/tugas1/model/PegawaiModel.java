package com.apap.tugas1.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "pegawai")
public class PegawaiModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max=20)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jabatan_pegawai")
	@Column(name="id", nullable=false)
    private Long id;

    @NotBlank
    @Size(max=255)
	@Column(name="NIP", nullable=false, unique=true)
    private String nip;

    @NotBlank
    @Size(max=255)
	@Column(name="nama", nullable=false)
    private String nama;

    @NotBlank
    @Size(max=255)
	@Column(name="tempat_lahir", nullable=false)
    private String tempat_lahir;

    @NotBlank
	@Column(name="tempat_lahir", nullable=false)
    private Date tanggal_lahir;

    @NotBlank
    @Size(max=255)
	@Column(name="tahun_masuk", nullable=false)
    private String tahun_masuk;

    @NotBlank
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id")
    @Size(max=20)
	@Column(name="id_instansi", nullable=false)
    private long id_instansi;
}