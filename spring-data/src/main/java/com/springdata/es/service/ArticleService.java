package com.springdata.es.service;

import com.springdata.entity.Article;

import java.util.List;

/**
 * Created by mengtian on 2018/1/3
 */
public interface ArticleService {
    boolean saveArticle(List<Article> articles);
}
