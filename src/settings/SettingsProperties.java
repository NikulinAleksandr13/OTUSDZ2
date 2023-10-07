package settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SettingsProperties implements ISettingsProperties {

    @Override
    public Map<String, String> getDbSettings() {
        Properties properties = new Properties();
        Map<String, String> props = new HashMap<>();
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/settings/db.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            props.put(
                    entry.getKey().toString(),
                    entry.getValue().toString());
        }
        return props;
    }
}
