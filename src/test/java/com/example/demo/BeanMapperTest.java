package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.simple.BeanMapper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wuzhong on 2018/4/20.
 * @version 1.0
 */
public class BeanMapperTest {

    @Test
    public void beanToMap() {

        Person person = new Person("wuzhong",true);

        Map<String, Object> stringObjectMap = BeanMapper.beanToMap(person);

        Assert.assertTrue(stringObjectMap.get("name").equals("wuzhong"));
        Assert.assertTrue(stringObjectMap.get("sex").equals(true));

    }

    @Test
    public void mapToBean() {

        Map<String,Object> map = new HashMap<>();
        map.put("name", "wuzhong");
        map.put("sex", true);

        Person person = new Person();
        Person person2 = BeanMapper.mapToBean(map, person);

        Assert.assertEquals(person, person2);


    }

    @Test
    public void objectsToMaps() {
    }

    @Test
    public void mapsToObjects() {
    }

    public static class Person {

        private String name;
        private boolean sex;

        public Person() {
        }

        public Person(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }
    }

}