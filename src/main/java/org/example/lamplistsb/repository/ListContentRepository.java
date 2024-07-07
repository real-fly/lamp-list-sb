package org.example.lamplistsb.repository;

import org.example.lamplistsb.entity.ListContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListContentRepository extends JpaRepository<ListContent, Integer> {
    List<ListContent> findByInfoId(Integer infoId);
    boolean existsByInfoIdAndValue(Integer infoId, String value);
    void deleteAllByIdIn(List<Integer> ids); // 修改方法
    void deleteAllByInfoId(Integer infoId);
}
