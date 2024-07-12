package org.example.lamplistsb.service.Impl;

import org.example.lamplistsb.entity.ListContent;
import org.example.lamplistsb.entity.ListInfo;
import org.example.lamplistsb.repository.ListContentRepository;
import org.example.lamplistsb.repository.ListInfoRepository;
import org.example.lamplistsb.service.ListContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ListContentServiceImpl implements ListContentService {

    @Autowired
    private ListContentRepository listContentRepository;
    @Autowired
    private ListInfoRepository listInfoRepository;

    @Override
    public ResponseEntity<Object> addListContent(ListContent listContent) {
        if (listContentRepository.existsByInfoIdAndValue(listContent.getInfoId(), listContent.getValue())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("该值已在名单中，请重新输入后再试");
        }
        listContent.setModifiedTime(LocalDateTime.now());
        ListContent savedContent = listContentRepository.save(listContent);
        return ResponseEntity.ok(savedContent);
    }

    @Override
    public List<ListContent> getListContents(Integer infoId) {
        return listContentRepository.findByInfoId(infoId);
    }

    @Override
    public ResponseEntity<Object> updateListContent(ListContent updatedContent) {
        ListContent listContent = listContentRepository.findById(updatedContent.getId()).orElse(null);
        if (listContent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("未找到该名单内容");
        }
        if (!listContent.getValue().equals(updatedContent.getValue())) {
            if (listContentRepository.existsByInfoIdAndValue(listContent.getInfoId(), updatedContent.getValue())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("修改后的值已在名单中，请重新输入后再试");
            }
        }
        updatedContent.setModifiedTime(LocalDateTime.now());
        ListContent savedContent = listContentRepository.save(updatedContent);
        return ResponseEntity.ok(savedContent);
    }

    @Transactional
    @Override
    public void deleteListContents(List<Integer> contentIds) {
        listContentRepository.deleteAllByIdIn(contentIds); // 使用新的方法
    }

    @Override
    public List<ListContent> getallListContents() {
        return listContentRepository.findAll();
    }

    @Override
    public boolean existsByInfoNameAndValue(String infoName, String value) {
        ListInfo listInfo = listInfoRepository.findByName(infoName);
        if (listInfo == null) {
            return false;
        }
        return listContentRepository.existsByInfoIdAndValue(listInfo.getId(), value);
    }
}
