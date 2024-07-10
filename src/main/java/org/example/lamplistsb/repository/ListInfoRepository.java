package org.example.lamplistsb.repository;

import org.example.lamplistsb.entity.ListInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListInfoRepository extends JpaRepository<ListInfo, Integer> {
    void deleteAllByTypeId(Integer typeId);
    List<ListInfo> findAllByTypeId(Integer typeId);
    ListInfo findByName(String name);
    boolean existsByName(String name);
}