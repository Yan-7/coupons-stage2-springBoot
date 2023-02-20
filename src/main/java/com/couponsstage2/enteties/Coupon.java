package com.couponsstage2.enteties;

import com.sun.istack.NotNull;
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

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    @Column(nullable = false)
    private LocalDate startDate = LocalDate.of(2022,1,1);

    @NotNull
    @Column(nullable = false)
    private LocalDate endDate = LocalDate.of(2035,1,1);

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