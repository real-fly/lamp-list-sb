package org.example.lamplistsb.service;

import org.example.lamplistsb.entity.ListInfo;

import java.util.List;

public interface ListInfoService {
    ListInfo createListInfo(Integer typeId, String name, String description);
    List<ListInfo> getListInfos();
}
