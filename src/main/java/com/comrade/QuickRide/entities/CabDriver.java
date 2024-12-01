package com.comrade.QuickRide.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class CabDriver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String name;
	private char gender;
	private int age;
	private String carName;
	private String carNumber;
	@Embedded
	private Coordinate location;
	private boolean status;
	private int earnings;

	public CabDriver(String name, char gender, int age, String carName, String carNumber, Coordinate location, boolean status, int earnings) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.carName = carName;
		this.carNumber = carNumber;
		this.location = location;
		this.status = status;
		this.earnings = earnings;
	}
}
