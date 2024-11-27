package com.sambit.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "bus_stop")
public class Bus_Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "stop_id")
    private Stop stop;

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    @Column(name = "depatur_time", nullable = false)
    private LocalTime depaturTime;

// Add other fields as needed
    // For example, arrival time, departure time write code









}