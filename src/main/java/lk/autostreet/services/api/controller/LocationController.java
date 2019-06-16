package lk.autostreet.services.api.controller;

import lk.autostreet.services.api.exception.DistrictNotFoundException;
import lk.autostreet.services.api.model.City;
import lk.autostreet.services.api.model.District;
import lk.autostreet.services.api.service.LocationService;
import lk.autostreet.services.api.transformer.CityEntry;
import lk.autostreet.services.api.transformer.CityListResponse;
import lk.autostreet.services.api.transformer.DistrictEntry;
import lk.autostreet.services.api.transformer.DistrictListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static lk.autostreet.services.api.config.AppConfig.VERSION;

@Slf4j
@RestController
public class LocationController implements LocationApi {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    @GetMapping(value = "/districts", headers = "X-Api-Version=" + VERSION)
    public DistrictListResponse getAllDistricts() {

        List<District> districtList = locationService.getAllDistricts();

        List<DistrictEntry> districtEntries = districtList.stream()
                .map(district -> DistrictEntry.builder()
                        .id(district.getId())
                        .name(district.getName())
                        .represent(district.getRepresent())
                        .build()
                ).collect(Collectors.toList());

        return DistrictListResponse.builder()
                .districts(districtEntries)
                .build();
    }

    @Override
    @GetMapping(value = "/districts/{district-id}/cities", headers = "X-Api-Version=" + VERSION)
    public CityListResponse getAllCitiesByDistrict(@PathVariable("district-id") Long districtId) throws DistrictNotFoundException {

        List<City> cityList = locationService.getAllCitiesByDistrict(districtId);
        List<CityEntry> cityEntries = cityList.stream()
                .map(city -> CityEntry.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .represent(city.getRepresent())
                        .build()
                ).collect(Collectors.toList());

        return CityListResponse.builder()
                .cities(cityEntries)
                .build();
    }
}
