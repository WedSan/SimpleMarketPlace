package wedsan.simplemarketplace.infrastructure.entity.Address;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_province")
public class ProvinceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String provinceName;


    public ProvinceEntity() {
    }

    public ProvinceEntity(String provinceName){
        this.provinceName = provinceName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
