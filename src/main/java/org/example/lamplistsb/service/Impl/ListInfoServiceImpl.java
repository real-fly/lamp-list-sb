package org.example.lamplistsb.service.Impl;

import org.example.lamplistsb.entity.ListInfo;
import org.example.lamplistsb.repository.ListContentRepository;
import org.example.lamplistsb.repository.ListInfoRepository;
import org.example.lamplistsb.service.ListInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListInfoServiceImpl implements ListInfoService {

    @Autowired
    private ListInfoRepository listInfoRepository;

    @Autowired
    private ListContentRepository listContentRepository;

    @Override
    public ResponseEntity<Object> createListInfo(ListInfo listInfo) {
        if (listInfoRepository.existsByName(listInfo.getName())) {
            return ResponseEntity.badRequest().body("该名单库已存在，请重新输入");
        }
        return ResponseEntity.ok(listInfoRepository.save(listInfo));
    }

    @Override
    public List<ListInfo> getListInfos() {
        return listInfoRepository.findAll();
    }

    @Override
    public void deleteListInfo(Integer id) {
        listInfoRepository.deleteById(id);
        // 添加 null 检查以避免空指针异常
        if (listContentRepository != null) {
            listContentRepository.deleteAllByInfoId(id);
        }
    }

    @Override
    public ResponseEntity<Object> updateListInfo(ListInfo listInfo) {
        ListInfo listInfoToUpdate = listInfoRepository.findById(listInfo.getId()).orElse(null);
        if (listInfoToUpdate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("未找到该名单库");
        }
        if(!listInfoToUpdate.getName().equals(listInfo.getName()) ) {
            if (listInfoRepository.existsByName(listInfo.getName())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("该名单库已存在，请重新输入");
            }
        }
        return ResponseEntity.ok(listInfoRepository.save(listInfo));
    }

    @Override
    public ListInfo getListInfo(Integer id) {
        return listInfoRepository.findById(id).orElse(null);
    }

    @Override
    public List<ListInfo> findAllByTypeId(Integer typeId) {
        return listInfoRepository.findAllByTypeId(typeId);
    }
}
