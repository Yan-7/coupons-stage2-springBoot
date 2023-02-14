package com.couponsstage2.enteties;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "coupons")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "company",cascade =CascadeType.ALL )
    private List<Coupon> coupons;

    public void addCoupon(Coupon coupon) {
        coupons.add(coupon);
        System.out.println("coupon " + coupon.getDescription()+ " was added");
    }
}
