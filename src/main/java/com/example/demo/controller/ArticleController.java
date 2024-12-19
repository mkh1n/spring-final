package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.dto.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
public class ArticleController {
    @Autowired
    private ArticleDTO articleDTO;

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleDTO.createArticle(article);
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleDTO.getAllArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Integer id) {
        return articleDTO.getArticleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Integer id, @RequestBody Article articleDetails) {
        return articleDTO.updateArticle(id, articleDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Integer id) {
        articleDTO.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}