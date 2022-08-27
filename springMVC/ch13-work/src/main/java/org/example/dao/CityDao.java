package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.City;

import java.util.List;

public interface CityDao {
    int insertCity(City city);
    List<City> selectCityByProvinceId(@Param("pid")Integer provinceId);
}
