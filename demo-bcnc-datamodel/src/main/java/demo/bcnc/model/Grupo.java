package demo.bcnc.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "GRUPOS")
public class Grupo {

    @Id
    @Column(name = "BRAND_ID")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Price> prices;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
