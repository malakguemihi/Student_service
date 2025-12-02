package com.example.demo.dto;

public class CourseDTO {
    private int id;
    private String name;
    private String instructor;
    private String category;

    public CourseDTO() {}

    public CourseDTO(int id, String name, String instructor , String category) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.category = category;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
