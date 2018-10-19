package com.apap.tugas1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apap.tugas1.model.JabatanPegawaiModel;

@Repository
public interface JabatanPegawaiDb extends JpaRepository<JabatanPegawaiModel, Long>{
    @Query(value="SELECT * FROM jabatan_pegawai WHERE id_pegawai = :id", nativeQuery = true)
    List<JabatanPegawaiModel> findJabatanPegawaiModelsById_pegawai(@Param("id") Long id);

    JabatanPegawaiModel save(JabatanPegawaiModel jabatanPegawaiModel);
    }
