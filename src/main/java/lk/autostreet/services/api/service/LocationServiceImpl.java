package lk.autostreet.services.api.service;

import lk.autostreet.services.api.exception.CityNotFoundException;
import lk.autostreet.services.api.exception.DistrictNotFoundException;
import lk.autostreet.services.api.model.City;
import lk.autostreet.services.api.model.District;
import lk.autostreet.services.api.repository.CityRepository;
import lk.autostreet.services.api.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private CityRepository cityRepository;
    private DistrictRepository districtRepository;

    @Autowired
    public LocationServiceImpl(CityRepository cityRepository, DistrictRepository districtRepository) {
        this.cityRepository = cityRepository;
        this.districtRepository = districtRepository;
    }

    @Override
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    @Override
    public List<City> getAllCitiesByDistrict(Long districtId) throws DistrictNotFoundException {

        District district = this.getDistrictById(districtId);
        return cityRepository.findByDistrict(district);
    }

    @Override
    public District getDistrictById(Long districtId) throws DistrictNotFoundException {
        Optional<District> districtOptional = districtRepository.findById(districtId);
        return districtOptional.orElseThrow(() -> new DistrictNotFoundException("no district found with id [" + districtId + "]"));
    }

    @Override
    public City getCityById(Long cityId) throws CityNotFoundException {
        Optional<City> cityOptional = cityRepository.findById(cityId);
        return cityOptional.orElseThrow(() -> new CityNotFoundException("no city found with id [" + cityId + "]"));
    }
}
