package com.mistydemo1.demo.service;

import com.mistydemo1.demo.entity.area;

import java.util.List;

public interface areaServices {
    List<area> getAreaList();

    area getAreaById(int areaId);

    boolean addArea(area area);

    boolean modifyArea(area area);

    boolean deleteArea(int areaId);
}
