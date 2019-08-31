package com.mistydemo1.demo.dao;

import com.mistydemo1.demo.entity.area;

import java.util.List;

public interface AreaDao {
    List<area> queryArea();
    area queryAreaById(int areaId);
    int insertArea(area area);
    int updateArea(area area);
    int deleteArea(int areaId);
}
