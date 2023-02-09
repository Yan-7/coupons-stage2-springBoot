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
    @Enumerated(EnumType.ORDINAL)
    private int companyId;
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

    @ManyToMany(mappedBy = "coupons",cascade = CascadeType.DETACH)
    private List<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @ToString.Exclude
    private Company company;


}
