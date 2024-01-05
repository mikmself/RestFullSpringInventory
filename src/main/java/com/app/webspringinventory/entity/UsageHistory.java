package com.app.webspringinventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usagehistory")
public class UsageHistory {
    @Id
    @GeneratedValue
    private int id;
    private int usage_quantity;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory_id;
}
