package org.cats.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.mapping.Collection;


@Entity
@Table
public class Cat {

	@Id
	@SequenceGenerator(name = "cat_seq", sequenceName = "cat_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq")
	@Column(name = "CAT_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DOB")
	private String dateOfBirth;

	@Column(name = "WEIGHT")
	private Float weight;

	@Column(name = "OWNERS_NAME")
	private String nameOfOwner;

	@OneToMany(mappedBy = "cat", targetEntity = Toy.class, fetch = FetchType.EAGER)
	 
	private List<Toy> catToys;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getNameOfOwner() {
		return nameOfOwner;
	}

	public void setNameOfOwner(String nameOfOwner) {
		this.nameOfOwner = nameOfOwner;
	}

	public List<Toy> getToyList() {
		return catToys;
	}

	/*public void setToyList(Toy catToy) {
		this.catToys.add(catToy);
	}*/
}
