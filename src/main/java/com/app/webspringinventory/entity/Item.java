package com.app.webspringinventory.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ItemCategory category_id;

}
