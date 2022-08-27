package org.example.service.Impl;

import org.example.dao.CityDao;
import org.example.dao.ProvinceDao;
import org.example.domain.City;
import org.example.domain.Province;
import org.example.service.ProvinceCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProvinceCityServiceImpl implements ProvinceCityService {
    @Resource
    private ProvinceDao pDao;
    @Resource
    private CityDao cDao;

    @Override
    public List<Province> queryAllProvince() {
        return pDao.selectProvinceList();
    }

    @Override
    public int addCity(City city) {
        int rows = cDao.insertCity(city);
        return rows;
    }

    @Override
    public List<City> queryCityByProvinceId(Integer provinceId) {
        return cDao.selectCityByProvinceId(provinceId);
    }
}
