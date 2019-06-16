package lk.autostreet.services.api.service;

import lk.autostreet.services.api.exception.CityNotFoundException;
import lk.autostreet.services.api.exception.DistrictNotFoundException;
import lk.autostreet.services.api.model.City;
import lk.autostreet.services.api.model.District;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {

    List<District> getAllDistricts();

    List<City> getAllCitiesByDistrict(Long districtId) throws DistrictNotFoundException;

    District getDistrictById(Long districtId) throws DistrictNotFoundException;

    City getCityById(Long cityId) throws CityNotFoundException;
}
