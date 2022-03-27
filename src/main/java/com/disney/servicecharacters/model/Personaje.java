package com.disney.servicecharacters.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "character")
public class Personaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
    private String name;
    private Integer age;
    private Double weight;

    public Personaje(String image, String name, Integer age, Double weight) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Personaje(Long id, String image, String name, Integer age, Double weight) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Personaje() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    private static final long serialVersionUID = -3906084092057068490L;
}
