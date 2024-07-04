package org.example.lamplistsb.service.Impl;

import org.example.lamplistsb.entity.ListInfo;
import org.example.lamplistsb.repository.ListInfoRepository;
import org.example.lamplistsb.service.ListInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListInfoServiceImpl implements ListInfoService {

    @Autowired
    private ListInfoRepository listInfoRepository;

    @Override
    public ListInfo createListInfo(Integer typeId, String name, String description) {
        ListInfo listInfo = new ListInfo();
        listInfo.setTypeId(typeId);
        listInfo.setName(name);
        listInfo.setDescription(description);
        return listInfoRepository.save(listInfo);
    }

    @Override
    public List<ListInfo> getListInfos() {
        return listInfoRepository.findAll();
    }
}
