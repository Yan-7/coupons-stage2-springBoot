package com.couponsstage2.enteties;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "coupons")
// TODO: 22/02/2023 hide password after testing is finished 
//@ToString(exclude = "password")
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

    public void addCouponClass(Coupon coupon) {
        if (this.coupons == null) {
            this.coupons = new ArrayList<>();
        }
        coupon.setCompany(this);
        this.coupons.add(coupon);

    }
}
