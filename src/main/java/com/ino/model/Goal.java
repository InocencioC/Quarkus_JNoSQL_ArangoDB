package com.ino.model;

import jakarta.json.bind.annotation.JsonbProperty;
import com.arangodb.shaded.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.List;

@JsonPropertyOrder({"id", "title", "description", "priority", "tasks"})
@Entity
public record Goal(
    @Id @JsonbProperty("id") String id,
    @JsonbProperty("title") @Column String title,
    @JsonbProperty("description") @Column String description,
    @JsonbProperty("priority") @Column String priority,
    @JsonbProperty("tasks") @Column List<String> tasks) {}


