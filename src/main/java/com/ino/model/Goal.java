package com.ino.model;

import com.arangodb.shaded.fasterxml.jackson.annotation.JsonProperty;
import com.arangodb.shaded.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.List;

@JsonPropertyOrder({"id", "title", "description", "priority", "tasks"})
@Entity
public record Goal(
    @Id @JsonProperty("id") String id,
    @JsonProperty("title") @Column String title,
    @JsonProperty("description") @Column String description,
    @JsonProperty("priority") @Column String priority,
    @JsonProperty("tasks") @Column String tasks) {}


