package org.example.lamplistsb.controller;

import org.example.lamplistsb.entity.ListType;
import org.example.lamplistsb.service.ListTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/list-types")
public class ListTypeController {

    @Autowired
    private ListTypeService listTypeService;

    @PostMapping//新建名单类型
    public ListType createListType(@RequestParam String name, @RequestParam(required = false) String description) {
        return listTypeService.createListType(name, description);
    }
}
