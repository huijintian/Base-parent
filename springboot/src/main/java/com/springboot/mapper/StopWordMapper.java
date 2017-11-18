package com.springboot.mapper;

import com.springboot.pojo.StopWord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mengtian on 2017/11/18
 */
@Mapper
public interface StopWordMapper {
    @Insert("insert into stop_word(stop_word) values(#{stopWord})")
    void insertStopWord(StopWord stopWord);

    @Insert("insert into stop_word(stop_word) values " +
            "<foreach collection='words' item='word' index='index' separator=','>" +
            "(#{word})" +
            "</foreach>")
    void batchInsertStopWord(@Param("words") List<String> words);

    @Select("select * from stop_word")
    List<StopWord> queryStopWords();
}
