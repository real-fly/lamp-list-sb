package org.example.lamplistsb.controller;

import org.example.lamplistsb.entity.ListType;
import org.example.lamplistsb.service.ListTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/list-types")
public class ListTypeController {

    @Autowired
    private ListTypeService listTypeService;

    @PostMapping//新建名单类型
    public ListType createListType(@RequestParam String name, @RequestParam(required = false) String description) {
        return listTypeService.createListType(name, description);
    }

    @GetMapping//查询名单类型
    public List<ListType> getListTypes() {
        return listTypeService.getListTypes();
    }

    @DeleteMapping("/{id}")//删除名单类型
    public void deleteListType(@PathVariable Integer id) {
        listTypeService.deleteListType(id);
    }

    @PutMapping("/{id}")//更新名单类型
    public ListType updateListType(@PathVariable Integer id, @RequestBody ListType listType) {
        listType.setId(id);
        return listTypeService.updateListType(listType);
    }
}
