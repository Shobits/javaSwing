package org.example.service;

import org.example.domain.City;
import org.example.domain.Province;

import java.util.List;

public interface ProvinceCityService {
    List<Province> queryAllProvince();

    int addCity(City city);

    List<City> queryCityByProvinceId(Integer provinceId);
}
