package com.rodelindev.SuperMarketApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCategory;

    @Column(nullable = false, length = 50)//, name = "name_category")
    private String name; //camel case | lowerCamelCase | UpperCamelCase | snake_case

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false)
    private boolean enabled;

}
