package lk.autostreet.services.api.transformer;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CityListResponse {

    private List<CityEntry> cities;
}
