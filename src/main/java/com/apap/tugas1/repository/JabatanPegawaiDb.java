package com.apap.tugas1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugas1.model.JabatanPegawaiModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JabatanPegawaiDb extends JpaRepository<JabatanPegawaiModel, Long>{
    @Query(value="SELECT * FROM jabatan_pegawai WHERE id_pegawai = :id", nativeQuery = true)
    List<JabatanPegawaiModel> findJabatanPegawaiModelsById_pegawai(@Param("id") Long id);
}
