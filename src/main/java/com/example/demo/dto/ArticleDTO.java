package com.example.demo.dto;
import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleDTO {
    @Autowired
    private ArticleRepository articleRepository;

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Integer id) {
        return articleRepository.findById(id);
    }

    public Article updateArticle(Integer id, Article articleDetails) {
        Article article = articleRepository.findById(id).orElseThrow();
        article.setTitle(articleDetails.getTitle());
        article.setBody(articleDetails.getBody());
        article.setAuthor(articleDetails.getAuthor());
        return articleRepository.save(article);
    }

    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
    }
}
