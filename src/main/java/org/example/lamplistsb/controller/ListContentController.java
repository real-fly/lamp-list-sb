package org.example.lamplistsb.controller;

import org.example.lamplistsb.entity.ListContent;
import org.example.lamplistsb.service.ListContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/list-content")
public class ListContentController {

    @Autowired
    private ListContentService listContentService;

    @PostMapping//新建名单内容
    public ResponseEntity<Object> addListContent(@RequestBody ListContent listContent) {
        return listContentService.addListContent(listContent);
    }

    @Autowired
    private RedisTemplate<String, Boolean> redisTemplate; // RedisTemplate用于操作Redis

    @GetMapping("/exists")
    public boolean existsByInfoNameAndValue(@RequestParam String infoName, @RequestParam String value) {
        // 构建Redis中的缓存键，可以使用infoName和value来唯一标识
        String cacheKey = "exists:" + infoName + ":" + value;

        // 尝试从Redis缓存中获取结果
        Boolean exists = redisTemplate.opsForValue().get(cacheKey);

        if (exists == null) {
            // 如果缓存中不存在，则进行数据库查询
            exists = listContentService.existsByInfoNameAndValue(infoName, value);

            // 将结果存入Redis缓存，设置过期时间（例如设置为5分钟）
            redisTemplate.opsForValue().set(cacheKey, exists, 5, TimeUnit.MINUTES);
        }

        return exists;
    }

    @GetMapping("/{infoId}")//查询名单内容
    public List<ListContent> getListContents(@PathVariable Integer infoId) {
        return listContentService.getListContents(infoId);
    }

    @PutMapping("/{contentId}")//更新名单内容
    public ResponseEntity<Object> updateListContent(@PathVariable Integer contentId, @RequestBody ListContent updatedContent) {
        updatedContent.setId(contentId);
        return listContentService.updateListContent(updatedContent);
    }

    @DeleteMapping//删除名单内容
    public void deleteListContents(@RequestBody List<Integer> contentIds) {
        listContentService.deleteListContents(contentIds);
    }

    @GetMapping("/all")
    public List<ListContent> getallListContents() {
        return listContentService.getallListContents();
    }

}
