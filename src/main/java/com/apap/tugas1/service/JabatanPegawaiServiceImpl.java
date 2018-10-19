package com.apap.tugas1.service;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.repository.JabatanDb;
import com.apap.tugas1.repository.JabatanPegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JabatanPegawaiServiceImpl implements JabatanPegawaiService{
    @Autowired
    JabatanPegawaiDb jabatanPegawaiDb;

    @Autowired
    JabatanDb jabatanDb;

    @Override
    public void addJabatanPegawai(JabatanPegawaiModel jabatanPegawaiModel) {
        jabatanPegawaiDb.save(jabatanPegawaiModel);
    }
    
    @Override
    @Transactional(readOnly = false)
    public List<JabatanPegawaiModel> getJabatanPegawaiListByIdPegawai(Long idPegawai) {
        List<JabatanPegawaiModel> jabatanPegawaiModels = jabatanPegawaiDb.findJabatanPegawaiModelsById_pegawai(idPegawai);
        for(JabatanPegawaiModel jabatanPegawai : jabatanPegawaiModels) {
            JabatanModel jabatanModel = jabatanDb.findJabatanModelById(Long.valueOf(jabatanPegawai.getId_jabatan()));
            jabatanPegawai.setGaji_pokok(jabatanModel.getGaji_pokok());
            jabatanPegawai.setNamaJabatan(jabatanModel.getNama());
        }
        return jabatanPegawaiModels;
    }
}
