package org.example.lamplistsb.controller;

import org.example.lamplistsb.entity.ListInfo;
import org.example.lamplistsb.service.ListInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/list-info")
public class ListInfoController {

    @Autowired
    private ListInfoService listInfoService;

    @PostMapping//新建具体名单库
    public ListInfo createListInfo(@RequestBody ListInfo listInfo) {
        return listInfoService.createListInfo(listInfo.getTypeId(), listInfo.getName(), listInfo.getDescription());
    }
}
