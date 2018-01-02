import com.base.util.CSVUtil;
import com.base.util.ConfigUtil;
import com.base.util.FileUtil;
import com.base.util.YamlConfigUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by mengtian on 2017/10/22
 */
public class ReadConfig {
    @Test
    public void readYaml() throws FileNotFoundException {
        Map map = YamlConfigUtil.readConfig(new File("E:\\CODE\\JAVA\\Base-parent\\base-util\\src\\main\\resources\\resource.yml"));
        System.out.println(map);
    }

    @Test
    public void readConfig() {
        Map map = ConfigUtil.getInstance().getConfig();
        System.out.println(map);
    }

    @Test
    public void fileTest() {
        System.out.println(FileUtil.listFile("/Users/mengtian/Documents/temp", "csv", true));
    }

    @Test
    public void fileExistTest() {
        File file = new File("/Users/mengtian/Documents/temp/zookper/version-2/test.txt");
        if (file.exists()) {
            file.deleteOnExit();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void unionCSVTest() {
        try {
            CSVUtil.unionCSV("/Users/mengtian/Documents/temp/csv2", "/Users/mengtian/Documents/temp/train.csv", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileCascadeTest(){
        System.out.println(FileUtil.listFile("E:\\txt", null));
    }
}
