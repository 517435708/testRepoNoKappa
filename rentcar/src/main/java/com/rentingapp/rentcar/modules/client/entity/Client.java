package com.rentingapp.rentcar.modules.client.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public int clientId;
    private String firstName;
    private String surname;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private boolean renting = false; //one client can rent only one car
}
