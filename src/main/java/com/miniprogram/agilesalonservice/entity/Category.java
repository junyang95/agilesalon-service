package com.miniprogram.agilesalonservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories", schema = "agilesalon")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "category_level1")
    private String categoryLevel1;

    @Column(name = "category_level2")
    private String categoryLevel2;

    @OneToMany(mappedBy = "category")
    private List<Question> questions;
}
