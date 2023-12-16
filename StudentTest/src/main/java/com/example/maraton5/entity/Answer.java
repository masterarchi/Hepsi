package com.example.maraton5.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Answer")

public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public void setContent(String content) {
        this.content = content;
    }

}
