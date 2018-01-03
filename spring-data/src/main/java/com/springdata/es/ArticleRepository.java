package com.springdata.es;

import com.springdata.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mengtian on 2018/1/3
 */
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

}
