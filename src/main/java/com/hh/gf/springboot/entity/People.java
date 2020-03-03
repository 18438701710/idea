package com.hh.gf.springboot.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "people")
@Data
public class People {

    private Long id;
    private String name;
    private String age;
    private List<String> list;
    private int[] array;
    private Map<String, Object> map;
}
