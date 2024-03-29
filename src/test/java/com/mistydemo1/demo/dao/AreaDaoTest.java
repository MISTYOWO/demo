package com.mistydemo1.demo.dao;

import com.mistydemo1.demo.entity.area;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    @Ignore
    public void queryArea() {
        List<area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test

    public void queryAreaById() {
        area area = areaDao.queryAreaById(1);
        assertEquals("东园",area.getAreaName());
    }

    @Test

    @Ignore
    public void insertArea() {
        area area = new area();
        area.setAreaName("南元");
        area.setPriority(1);
        int effectedNum =areaDao.insertArea(area);
        assertEquals(1,effectedNum);
    }

    @Test


    public void updateArea() {
        area area= new area();
        area.setAreaName("南元");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int effectedNum = areaDao.updateArea(area);
        assertEquals(1,effectedNum);
    }

    @Test

    public void deleteArea() {
        int effectedNum = areaDao.deleteArea(3);
        assertEquals(1,effectedNum);
    }
}
