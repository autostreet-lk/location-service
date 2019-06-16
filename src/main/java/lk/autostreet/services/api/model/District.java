package lk.autostreet.services.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "districts")
public class District{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "district")
    private List<City> cityList;

    private String represent;
}
