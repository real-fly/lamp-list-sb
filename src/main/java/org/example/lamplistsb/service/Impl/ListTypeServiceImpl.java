package org.example.lamplistsb.service.Impl;

import jakarta.transaction.Transactional;
import org.example.lamplistsb.entity.ListInfo;
import org.example.lamplistsb.entity.ListType;
import org.example.lamplistsb.repository.ListContentRepository;
import org.example.lamplistsb.repository.ListInfoRepository;
import org.example.lamplistsb.repository.ListTypeRepository;
import org.example.lamplistsb.service.ListTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListTypeServiceImpl implements ListTypeService {

    @Autowired
    private ListTypeRepository listTypeRepository;

    @Autowired
    private ListInfoRepository listInfoRepository;

    @Autowired
    private ListContentRepository listContentRepository;

    @Override
    public ListType createListType(String name, String description) {
        ListType listType = new ListType();
        listType.setName(name);
        listType.setDescription(description);
        return listTypeRepository.save(listType);
    }

    @Override
    public List<ListType> getListTypes() {
        return listTypeRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteListType(Integer id) {
        listTypeRepository.deleteById(id);
        List<ListInfo> listInfos = listInfoRepository.findAllByTypeId(id);
        for (ListInfo listInfo : listInfos) {
            listContentRepository.deleteAllByInfoId(listInfo.getId());
        }
        listInfoRepository.deleteAllByTypeId(id);
    }

    @Override
    public ListType updateListType(ListType listType) {
        if (listTypeRepository.existsById(listType.getId())) {
            return listTypeRepository.save(listType);
        }
        return null;
    }
}
