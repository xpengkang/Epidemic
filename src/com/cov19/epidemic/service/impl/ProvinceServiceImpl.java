package com.cov19.epidemic.service.impl;

import com.cov19.epidemic.bean.ProvinceInfo;
import com.cov19.epidemic.mapper.ProvinceMapper;
import com.cov19.epidemic.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;
    @Override
    public List<ProvinceInfo> findNoDataProvinces(String date) {
        short year = 0, month = 0, day = 0;
        String[] array = date.split("-");
        List<ProvinceInfo> list = null;
        if (array.length >= 3){
            year = Short.parseShort(array[0]);
            month = Short.parseShort(array[1]);
            day = Short.parseShort(array[2]);
            list = provinceMapper.findNoDataProvinces(year,month,day);
        }
        return list;
    }
}
