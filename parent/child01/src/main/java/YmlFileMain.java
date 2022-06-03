import com.zdl.ymlutils.YamlUtils;

import java.io.File;
import java.util.Objects;

public class YmlFileMain {

    public static void main(String[] args) throws Exception {

        File yml = new File(Objects.requireNonNull(YmlFileMain.class.getClassLoader().getResource("application.yml")).toURI());
        YamlUtils.setYmlFile(yml);
        System.out.println(YamlUtils.getByKey("athena"));
        YamlUtils.saveOrUpdateByKey("athena.name", "superman");
        YamlUtils.removeByKey("athena.upload.time");

    }


}
