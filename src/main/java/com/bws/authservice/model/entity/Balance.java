package com.bws.authservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "balance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "balance_id")
    private String balanceId;

    @Column(name = "username")
    private String username;

    @Column(name = "amount")
    private Long amount;

    //TODO : BURAYI BAGLA DIGERIYLE...

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "money_code")
    private String money_code;

}