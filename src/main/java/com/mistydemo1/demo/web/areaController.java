package com.mistydemo1.demo.web;

import com.mistydemo1.demo.entity.area;
import com.mistydemo1.demo.service.implservices.AreaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.Area;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class areaController {
    @Autowired
    private AreaServices areaServices;

    @RequestMapping(value="/listarea",method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<area> list = areaServices.getAreaList();
        modelMap.put("areaList",list);
        return modelMap;
    }
    @RequestMapping(value = "/getareabyid",method = RequestMethod.GET)
    private Map<String,Object> getAreaById(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        area area = areaServices.getAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    private Map<String,Object> addarea(@RequestBody area area){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("seccuess",areaServices.addArea(area));
        return modelMap;
    }
    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    private Map<String,Object> modifyarea(@RequestBody area area){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",areaServices.modifyArea(area));
        return modelMap;
    }
    @RequestMapping(value = "/removearea",method = RequestMethod.GET)
    private Map<String,Object> removearea(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",areaServices.deleteArea(areaId));
        return modelMap;
    }


}
