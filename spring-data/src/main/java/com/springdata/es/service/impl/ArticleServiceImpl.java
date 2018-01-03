package com.springdata.es.service.impl;

import com.springdata.entity.Article;
import com.springdata.es.ArticleRepository;
import com.springdata.es.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mengtian on 2018/1/3
 */
@Service
@Primary
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public boolean saveArticle(List<Article> articles) {
        articleRepository.saveAll(articles);
        return true;
    }
}
