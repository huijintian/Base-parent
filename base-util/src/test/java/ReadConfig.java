import com.base.util.ConfigUtil;
import com.base.util.YamlConfigUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
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
}
