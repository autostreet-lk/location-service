package lk.autostreet.services.api.repository;

import lk.autostreet.services.api.model.City;
import lk.autostreet.services.api.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByDistrict(District district);
}
