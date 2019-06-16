package lk.autostreet.services.api.controller;

import static lk.autostreet.services.api.config.AppConfig.VERSION;

import lk.autostreet.services.api.exception.DistrictNotFoundException;
import lk.autostreet.services.api.transformer.CityListResponse;
import lk.autostreet.services.api.transformer.DistrictListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public interface LocationApi {

    @GetMapping(value = "/districts", headers = "X-API-VERSION=" + VERSION)
    DistrictListResponse getAllDistricts();

    @GetMapping(value = "/districts/{district-id}/cities", headers = "X-API-VERSION=" + VERSION)
    CityListResponse getAllCitiesByDistrict(@PathVariable("district-id") Long districtId) throws DistrictNotFoundException;
}
