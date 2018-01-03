package com.springdata.controller;

import com.springdata.entity.Article;
import com.springdata.es.service.ArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengtian on 2018/1/3
 */
@RestController
@RequestMapping("/api")
public class DataController {

    @Resource
    private ArticleService articleService;

    @PostMapping("/es/save")
    public String saveEsData() {
        List<Article> articles = new ArrayList<>();

        articles.add(
                new Article(
                        1l,
                        "tian",
                        "es测试",
                        "ElasticSearch是一个基于Lucene开发的搜索服务器，具有分布式多用户的能力，ElasticSearch是用Java开发的开源项目(Apache许可条款)，基于Restful Web接口，能够达到实时搜索、稳定、可靠、快速" +
                                "、高性能、安装使用方便，同时它的横向扩展能力非常强，不需要重启服务。",
                        null));

        articleService.saveArticle(articles);
        return "success";
    }
}
