package com.apap.tugas1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apap.tugas1.model.InstansiModel;


@Repository
public interface InstansiDb extends JpaRepository<InstansiModel, Long> {
    InstansiModel findInstansiModelById(Long id);
    
    @Query(value="SELECT * FROM instansi WHERE id_provinsi = :id", nativeQuery = true)
    List<InstansiModel> findAllById_provinsi(@Param("id") Integer id);

    @Query(value="SELECT * FROM instansi WHERE id_provinsi = :id_provinsi AND nama = :nama", nativeQuery = true)
    InstansiModel findInstansiModelByNamaAndId_provinsi(@Param("nama")String nama, @Param("id_provinsi")Long id_provinsi);

}
