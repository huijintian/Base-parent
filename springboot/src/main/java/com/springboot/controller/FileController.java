package com.springboot.controller;

import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.springboot.component.FileReadInComponent;
import com.springboot.mapper.StopWordMapper;
import com.springboot.pojo.StopWord;
import com.springboot.process.FileReadInProcess;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mengtian on 2017/11/18
 */
@Controller
public class FileController {

    @Resource
    private FileReadInComponent fileReadInComponent;

    @Resource
    private StopWordMapper stopWordMapper;

    @RequestMapping("/fileReadIn")
    @ResponseBody
    public String fileReadIn(@RequestParam("filepath") String filePath) {
        LineProcessor processor = new FileReadInProcess(fileReadInComponent);
        try {
            Files.asCharSource(new File(filePath), Charset.forName("UTF-8"))
                    .readLines(processor);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return (String) processor.getResult();
    }

    @RequestMapping("/stopWords")
    @ResponseBody
    public Map getStopwords() {
        Map map = new HashMap();
        List<StopWord> stopWords = stopWordMapper.queryStopWords();
        map.put("words", stopWords);
        return map;
    }
}
