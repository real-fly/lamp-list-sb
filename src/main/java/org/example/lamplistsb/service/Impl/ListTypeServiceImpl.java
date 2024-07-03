package org.example.lamplistsb.service.Impl;

import org.example.lamplistsb.entity.ListType;
import org.example.lamplistsb.repository.ListTypeRepository;
import org.example.lamplistsb.service.ListTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListTypeServiceImpl implements ListTypeService {

    @Autowired
    private ListTypeRepository listTypeRepository;

    @Override
    public ListType createListType(String name, String description) {
        ListType listType = new ListType();
        listType.setName(name);
        listType.setDescription(description);
        return listTypeRepository.save(listType);
    }
}
