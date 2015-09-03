package com.dee.web.spring.usecase3.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.util.PropertiesPersister;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.ScalarStyle;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.resolver.Resolver;

/**
 * dien.nguyen
 */
public class YamlPropertiesPersister implements PropertiesPersister {

    private Properties property;

    private Map<String, Object> propertyConfig;

    @Override
    public void load(Properties props, InputStream is) throws IOException {
        load(props, new InputStreamReader(is));
        property = props;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void load(Properties props, Reader reader) throws IOException {
        Yaml yaml = YamlPropertiesPersister.instanceOfYaml();
        Map<String, Object> map = (Map<String, Object>) yaml.load(reader);
        assignProperties(props, map, null);
        propertyConfig = map;
    }

    @SuppressWarnings("unchecked")
    public void assignProperties(Properties props, Map<String, Object> map, String path) {
        for (Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            if (path != null && !path.isEmpty())
                key = path + "." + key;
            Object val = entry.getValue();
            if (val instanceof String) {
                // see if we need to create a compound key
                props.put(key, val);
            } else if (val instanceof Map) {
                assignProperties(props, (Map<String, Object>) val, key);
            } else if (val instanceof Map) {
                assignProperties(props, (Map<String, Object>) val, key);
            }
        }
    }

    @Override
    public void store(Properties props, OutputStream os, String header) throws IOException {
        throw new IllegalAccessError("Current implementation is a read-only");
    }

    @Override
    public void store(Properties props, Writer writer, String header) throws IOException {
        throw new IllegalAccessError("Current implementation is a read-only");
    }

    @Override
    public void loadFromXml(Properties props, InputStream is) throws IOException {
        throw new IllegalAccessError("Use DefaultPropertiesPersister if you want to read/write XML");
    }

    @Override
    public void storeToXml(Properties props, OutputStream os, String header) throws IOException {
        throw new IllegalAccessError("Use DefaultPropertiesPersister if you want to load/store to XML");
    }

    @Override
    public void storeToXml(Properties props, OutputStream os, String header, String encoding) throws IOException {
        throw new IllegalAccessError("Use DefaultPropertiesPersister if you want to read/write XML");
    }

    public static Yaml instanceOfYaml() {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setDefaultScalarStyle(ScalarStyle.DOUBLE_QUOTED);

        final Yaml yaml = new Yaml(new Constructor(), new Representer(), options, new Resolver() {
            @Override
            protected void addImplicitResolvers() {
                addImplicitResolver(Tag.BOOL, BOOL, "yYnNtTfFoO");
                addImplicitResolver(Tag.MERGE, MERGE, "<");
                addImplicitResolver(Tag.NULL, NULL, "~nN\0");
                addImplicitResolver(Tag.NULL, EMPTY, null);
                addImplicitResolver(Tag.TIMESTAMP, TIMESTAMP, "0123456789");
                addImplicitResolver(Tag.VALUE, VALUE, "=");
            }
        });
        return yaml;
    }

    public Properties getProperty() {
        return property;
    }

    public void setProperty(Properties property) {
        this.property = property;
    }

    public Map<String, Object> getPropertyConfig() {
        return propertyConfig;
    }

    public void setPropertyConfig(Map<String, Object> propertyConfig) {
        this.propertyConfig = propertyConfig;
    }

    public String getPropertyByKey(String key) {
        Object obj = getProperty().get(key);
        return obj != null ? obj.toString() : "";
    }
}
