package com.mistydemo1.demo.service.implservices;

import com.mistydemo1.demo.dao.AreaDao;
import com.mistydemo1.demo.entity.area;
import com.mistydemo1.demo.service.areaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class AreaServices implements areaServices {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public area getAreaById(int areaId) {
        int a = areaId/0;
        return areaDao.queryAreaById(areaId);
    }
    @Transactional
    @Override
    public boolean addArea(area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int efftiveNum = areaDao.insertArea(area);
                if(efftiveNum >0 ){
                    return true;
                }
                else{
                    throw new RuntimeException("插入区域信息失败");
                }
            }
            catch (Exception e){
                throw new RuntimeException("插入区域失败" + e.getMessage());
            }
        }
        else{
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public boolean modifyArea(area area) {
        if(area.getAreaId() != null && area.getAreaId()>0){
            area.setLastEditTime(new Date());
            try{
                int efftiveNum = areaDao.updateArea(area);
                if(efftiveNum >0 ){
                    return true;
                }
                else{
                    throw new RuntimeException("更新区域信息失败");
                }
            }
            catch (Exception e){
                throw new RuntimeException("更新区域失败" + e.toString());
            }
        }
        else{
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try{
                int efftiveNum = areaDao.deleteArea(areaId);
                if(efftiveNum >0 ){
                    return true;
                }
                else{
                    throw new RuntimeException("删除区域信息失败");
                }
            }
            catch (Exception e){
                throw new RuntimeException("删除区域失败" + e.toString());
            }
        }
        else{
            throw new RuntimeException("区域Id信息不能为负数或为空");
        }
    }
}
