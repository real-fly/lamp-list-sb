package org.example.lamplistsb.service;

import org.example.lamplistsb.entity.ListContent;

import java.time.Instant;
import java.util.List;

public interface ListContentService {
    ListContent addListContent(ListContent listContent);
    List<ListContent> getListContents(Integer infoId);
    ListContent updateListContent(ListContent updatedContent);
    void deleteListContents(List<Integer> contentIds);
    boolean isValueInList(Integer infoId, String value);
}
