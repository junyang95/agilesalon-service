package com.miniprogram.agilesalonservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "options", schema = "agilesalon")
@Getter
@Setter
@NoArgsConstructor
public class Option {
    @Id
    @Column(name = "option_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer optionId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "option_cn")
    private String optionCn;

    @Column(name = "option_en")
    private String optionEn;

    @Column(name = "is_correct")
    private Boolean isCorrect;
}
