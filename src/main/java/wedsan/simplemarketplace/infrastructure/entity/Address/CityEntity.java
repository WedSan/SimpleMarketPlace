package wedsan.simplemarketplace.infrastructure.entity.Address;

import jakarta.persistence.*;
import wedsan.simplemarketplace.core.domain.Address;

@Entity
@Table(name = "tb_city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cityName;

    public CityEntity(){}

    public CityEntity(String cityName){
        this.cityName = cityName;
    }
    public CityEntity(Integer id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
