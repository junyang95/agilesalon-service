package com.miniprogram.agilesalonservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions", schema = "agilesalon")
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    @Column(name = "question_type")
    private String questionType;

    @Column(name = "question_cn")
    private String questionCn;

    @Column(name = "question_en")
    private String questionEn;

    @Column(name = "explanation_cn")
    private String explanationCn;

    @Column(name = "explanation_en")
    private String explanationEn;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "question")
    private List<Option> options;
}
