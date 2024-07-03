package org.example.lamplistsb.service;

import org.example.lamplistsb.entity.ListInfo;

public interface ListInfoService {
    ListInfo createListInfo(Integer typeId, String name, String description);
}
