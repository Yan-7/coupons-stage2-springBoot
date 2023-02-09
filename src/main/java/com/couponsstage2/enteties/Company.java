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

    @OneToMany
    private List<Coupon> coupons;

    // TODO: 09/02/2023
    public void addCoupon(Coupon coupon) {

    }
}
