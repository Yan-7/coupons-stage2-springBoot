package com.couponsstage2.enteties;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "coupons")
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String password;

    // TODO: 14/02/2023   Error executing DDL "alter table customer_vs_coupon drop foreign key FKikxo4a104ty3ydilh4m422ca2" via JDBC Statement
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @JoinTable(
                name = "customer_vs_coupon",
                joinColumns = @JoinColumn(name = "customer_id"),
                inverseJoinColumns = @JoinColumn(name = "coupon_id")
    )
    private List<Coupon> coupons;

    public void attachCouponToCustomer(Coupon coupon){
        if (this.coupons == null) {
            this.coupons = new ArrayList<>();
        }
        coupons.add(coupon);
        System.out.println("coupon " + coupon.getId() + " attached to " +firstName);

    }
}
