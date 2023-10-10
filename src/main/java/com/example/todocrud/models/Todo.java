package com.example.todocrud.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

    public class Todo {
        @Id
        @GeneratedValue
        @Column(updatable = false, nullable = false)
        Long id;
        @Column
        String title;
        @Column
        String description;
        @Column
        TodoStatus todoStatus;
        @CreationTimestamp
        @Column(updatable = false)
        Timestamp dateCreated;
        @UpdateTimestamp
        Timestamp lastModified;

    }
