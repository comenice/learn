package com._1813qt.learn.springcloudconfigserver.config;

import java.util.HashMap;

public class TestFactories extends HashMap {

    @Override
    public Object get(Object key) {
        return "惊不惊喜 意不意外 " + key;
    }
}
