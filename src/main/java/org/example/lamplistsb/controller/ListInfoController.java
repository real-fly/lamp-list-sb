package org.example.lamplistsb.controller;

import org.example.lamplistsb.entity.ListInfo;
import org.example.lamplistsb.service.ListInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/list-info")
public class ListInfoController {

    @Autowired
    private ListInfoService listInfoService;

    @PostMapping//新建具体名单库
    public ListInfo createListInfo(@RequestBody ListInfo listInfo) {
        return listInfoService.createListInfo(listInfo.getTypeId(), listInfo.getName(), listInfo.getDescription());
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
    public ListInfo updateListInfo(@PathVariable Integer id, @RequestBody ListInfo listInfo) {
        listInfo.setId(id);
        return listInfoService.updateListInfo(listInfo);
    }
}
