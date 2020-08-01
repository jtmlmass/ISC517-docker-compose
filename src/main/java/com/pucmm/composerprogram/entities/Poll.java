package com.pucmm.composerprogram.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Poll implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pollNumber;

    private String question1;
    private String question2;
    private String question3;
    private String question4;

    private int answer1;
    private int answer2;
    private int answer3;
    private int answer4;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "username_poll_number", nullable = false)
    private User user;
}
