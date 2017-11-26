package com.nlp.hanlp;

import com.base.util.FileUtil;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.nlp.hanlp.process.SegmentLineProcess;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by mengtian on 2017/11/13
 */
public class SegmentFile {

    private static final String EXT = ".txt";

    public static void main(String[] args) throws IOException {
        String basePath = "E:\\CODE\\JAVA\\Base-parent\\nlp\\src\\main\\resources\\";
        String novelPath = basePath.concat(File.separator).concat("novel");
        String segmentPath = basePath.concat(File.separator).concat("segment");

        List<String> files = FileUtil.listFile(novelPath, true);
        for (String file : files) {
            LineProcessor processor = new SegmentLineProcess();
            String fileName = Files.getNameWithoutExtension(file);
            Files.asCharSource(new File(file), Charset.forName("UTF-8"))
                    .readLines(processor);
            List<String> lines = (List<String>) processor.getResult();
            for (String line : lines) {
                System.out.println(line);
                Files.asCharSink(new File(segmentPath.concat(File.separator).concat(fileName + EXT)),
                        Charset.forName("UTF-8"),
                        FileWriteMode.APPEND).write(line + "\n");
            }
        }
    }
}
