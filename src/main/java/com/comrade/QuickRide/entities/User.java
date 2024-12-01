package com.comrade.QuickRide.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String name;
	private char gender;
	private int age;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "x", column = @Column(name = "location_x")),
			@AttributeOverride(name = "y", column = @Column(name = "location_y"))
	})
	private Coordinate location;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "x", column = @Column(name = "destination_x")),
			@AttributeOverride(name = "y", column = @Column(name = "destination_y"))
	})
	private Coordinate destination;

	public User(String name, char gender, int age, Coordinate location, Coordinate destination) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.location = location;
		this.destination = destination;
	}
}
