package com.example.auth.Enteties;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Token {

    @Id
    @GeneratedValue()
    private long id;
    private String token;
    private LocalDateTime createdat;
    private LocalDateTime expiredat;
    private LocalDateTime validatedat;


    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

}
