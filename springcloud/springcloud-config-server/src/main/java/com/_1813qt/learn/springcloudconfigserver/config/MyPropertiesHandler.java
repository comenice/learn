package com._1813qt.learn.springcloudconfigserver.config;


import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * 1: 解决统一配置文件从git获取中文乱码问题
 */

public class MyPropertiesHandler extends PropertiesPropertySourceLoader {

    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        ArrayList<PropertySource<?>> list = new ArrayList<>();
        Properties properties = getProperties(resource);
        if (!properties.isEmpty()) {
            list.add(new PropertiesPropertySource(name, properties));
        }
        return list;
    }

    private Properties getProperties(Resource resource) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = resource.getInputStream();
        properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        inputStream.close();
        return properties;
    }

}
