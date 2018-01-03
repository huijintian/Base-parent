package com.springdata.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mengtian on 2018/1/3
 */
@Data
@Document(indexName = "es-article", type = "article")
public class Article implements Serializable {

    @Id
    private Long id;

    private String author;

    private String title;

    private String content;

    private List<String> tags;


    public Article(Long id, String author, String title, String content, List<String> tags) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.tags = tags;
    }
}
