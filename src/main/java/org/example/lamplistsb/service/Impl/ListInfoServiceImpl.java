package org.example.lamplistsb.service.Impl;

import org.example.lamplistsb.entity.ListInfo;
import org.example.lamplistsb.repository.ListContentRepository;
import org.example.lamplistsb.repository.ListInfoRepository;
import org.example.lamplistsb.service.ListInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListInfoServiceImpl implements ListInfoService {

    @Autowired
    private ListInfoRepository listInfoRepository;

    @Autowired
    private ListContentRepository listContentRepository;

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

    @Override
    public void deleteListInfo(Integer id) {
        listInfoRepository.deleteById(id);
        // 添加 null 检查以避免空指针异常
        if (listContentRepository != null) {
            listContentRepository.deleteAllByInfoId(id);
        }
    }

    @Override
    public ListInfo updateListInfo(ListInfo listInfo) {
        if (listInfoRepository.existsById(listInfo.getId())) {
            return listInfoRepository.save(listInfo);
        }
        return null;
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
