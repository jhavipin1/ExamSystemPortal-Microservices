package com.question.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quesId;
    @Column(length = 5000)
    private String content;

    private String image;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String answer;
    private Long quizId;

   /* @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;*/
}
