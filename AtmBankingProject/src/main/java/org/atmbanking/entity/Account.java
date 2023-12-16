package org.atmbanking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    private int id;
    private int userId;
    private double balance;
    private String accountNo;
    private String name ;

}
