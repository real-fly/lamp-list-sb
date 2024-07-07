package org.example.lamplistsb.service;

import org.example.lamplistsb.entity.ListContent;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ListContentService {
    ResponseEntity<Object> addListContent(ListContent listContent);
    List<ListContent> getListContents(Integer infoId);
    ResponseEntity<Object> updateListContent(ListContent updatedContent);
    void deleteListContents(List<Integer> contentIds);
    List<ListContent> getallListContents();
    boolean existsByInfoNameAndValue(String infoName, String value);
}
