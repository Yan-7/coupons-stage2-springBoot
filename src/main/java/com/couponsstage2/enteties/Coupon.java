package com.couponsstage2.enteties;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private int companyId;

    @Enumerated(EnumType.ORDINAL)
    private Category category;
    private String title;
    private String description;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;
    private int amount;
    private double price;
    private String image;

    @ManyToMany
    @JoinTable(
            name = "customer_vs_coupon",
            joinColumns = @JoinColumn(name="coupon_id"),
            inverseJoinColumns = @JoinColumn(name="customer_id")
    )
    @ToString.Exclude
    @Setter(value = AccessLevel.NONE)
    private List<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "companyId")
    @ToString.Exclude
    private Company company;


}
