package org.example.lamplistsb.controller;

import org.example.lamplistsb.entity.ListContent;
import org.example.lamplistsb.service.ListContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/list-content")
public class ListContentController {

    @Autowired
    private ListContentService listContentService;

    @PostMapping//新建名单内容
    public ListContent addListContent(@RequestBody ListContent listContent) {
        return listContentService.addListContent(listContent);
    }

    @GetMapping("/{infoId}")//查询名单内容
    public List<ListContent> getListContents(@PathVariable Integer infoId) {
        return listContentService.getListContents(infoId);
    }

    @PutMapping("/{contentId}")//更新名单内容
    public ListContent updateListContent(@PathVariable Integer contentId, @RequestBody ListContent updatedContent) {
        updatedContent.setId(contentId);
        return listContentService.updateListContent(updatedContent);
    }

    @DeleteMapping//删除名单内容
    public void deleteListContents(@RequestBody List<Integer> contentIds) {
        listContentService.deleteListContents(contentIds);
    }

    @GetMapping("/exists")
    public boolean isValueInList(@RequestParam Integer infoId, @RequestParam String value) {
        return listContentService.isValueInList(infoId, value);
    }
}
