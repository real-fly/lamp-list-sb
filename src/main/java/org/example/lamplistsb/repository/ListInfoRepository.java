package org.example.lamplistsb.repository;

import org.example.lamplistsb.entity.ListInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListInfoRepository extends JpaRepository<ListInfo, Integer> {
}