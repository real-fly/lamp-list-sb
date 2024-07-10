package org.example.lamplistsb.service;

import org.example.lamplistsb.entity.ListInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ListInfoService {
    ResponseEntity<Object> createListInfo(ListInfo listInfo);
    List<ListInfo> getListInfos();
    void deleteListInfo(Integer id);
    ResponseEntity<Object> updateListInfo(ListInfo listInfo);
    ListInfo getListInfo(Integer id);
    List<ListInfo> findAllByTypeId(Integer typeId);
}
