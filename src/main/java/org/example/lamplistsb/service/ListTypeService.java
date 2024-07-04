package org.example.lamplistsb.service;

import org.example.lamplistsb.entity.ListType;

import java.util.List;

public interface ListTypeService {
    ListType createListType(String name, String description);
    List<ListType> getListTypes();
}
