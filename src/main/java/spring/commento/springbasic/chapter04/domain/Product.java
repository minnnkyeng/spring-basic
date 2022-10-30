package spring.commento.springbasic.chapter04.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String productName;

    private int price;

    private int quantity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @ToString.Exclude
    private Store store;

    public Product( int price, int quantity) {
        this(null ,price, quantity, null);
    }

    public Product(String productName, int price, int quantity) {
        this(productName,price, quantity, null);
    }

    public Product(String productName, int price, int quantity, Store store) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        if( store != null ) {
            changeStore(store);
        }
    }

    public void changeStore(Store store) {
        this.store = store;
        store.getProducts().add(this);
    }
}
