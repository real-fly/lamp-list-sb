package org.example.lamplistsb.controller;

import org.example.lamplistsb.entity.ListInfo;
import org.example.lamplistsb.service.ListInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/list-info")
public class ListInfoController {

    @Autowired
    private ListInfoService listInfoService;

    @PostMapping//新建具体名单库
    public ResponseEntity<Object> createListInfo(@RequestBody ListInfo listInfo) {
        return listInfoService.createListInfo(listInfo);
    }

    @GetMapping//查询具体名单库
    public List<ListInfo> getListInfos() {
        return listInfoService.getListInfos();
    }

    @DeleteMapping("/{id}")//删除具体名单库
    public void deleteListInfo(@PathVariable Integer id) {
        listInfoService.deleteListInfo(id);
    }

    @PutMapping("/{id}")//更新具体名单库
    public ResponseEntity<Object> updateListInfo(@PathVariable Integer id, @RequestBody ListInfo listInfo) {
        listInfo.setId(id);
        return listInfoService.updateListInfo(listInfo);
    }

    @GetMapping("/{id}")//查询具体名单库
    public ListInfo getListInfo(@PathVariable Integer id) {
        return listInfoService.getListInfo(id);
    }

    @GetMapping("/type/{typeId}")//查询具体名单库
    public List<ListInfo> findAllByTypeId(@PathVariable Integer typeId) {
        return listInfoService.findAllByTypeId(typeId);
    }
}
