package org.example.lamplistsb.service.Impl;

import org.example.lamplistsb.entity.ListContent;
import org.example.lamplistsb.repository.ListContentRepository;
import org.example.lamplistsb.service.ListContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class ListContentServiceImpl implements ListContentService {

    @Autowired
    private ListContentRepository listContentRepository;

    @Override
    public ListContent addListContent(ListContent listContent) {
        if (listContentRepository.existsByInfoIdAndValue(listContent.getInfoId(), listContent.getValue())) {
            throw new RuntimeException("该值已在名单中，请重新输入后再试");
        }
        listContent.setModifiedTime(Instant.now());
        return listContentRepository.save(listContent);
    }

    @Override
    public List<ListContent> getListContents(Integer infoId) {
        return listContentRepository.findByInfoIdOrderByModifiedTimeDesc(infoId);
    }

    @Override
    public ListContent updateListContent(ListContent updatedContent) {
        if (listContentRepository.existsById(updatedContent.getId())) {
            updatedContent.setModifiedTime(Instant.now());
            return listContentRepository.save(updatedContent);
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteListContents(List<Integer> contentIds) {
        listContentRepository.deleteAllByIdIn(contentIds); // 使用新的方法
    }

    @Override
    public boolean isValueInList(Integer infoId, String value) {
        return listContentRepository.existsByInfoIdAndValue(infoId, value);
    }
}
