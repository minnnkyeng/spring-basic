package spring.commento.springbasic.chapter04.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Store {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    private String storeName;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();

    public Store(String storeName) {
        this(storeName,null);
    }

    public Store(String storeName, Address address) {
        this.storeName = storeName;
        this.address = address;
    }

    public void changeProducts(Product product){
        this.products.add(product);
        product.setStore(this);
    }

    public void changeProducts(List<Product> products){
        this.products.addAll(products);
        products.forEach(product -> product.setStore(this));
    }
}
