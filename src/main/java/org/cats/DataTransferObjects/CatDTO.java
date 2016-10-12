package org.cats.DataTransferObjects;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class CatDTO {

	@NotBlank
	@Size(min=2, max=20)
	private String name;

	@NotBlank
	@Pattern(regexp="[1-2][0-9]{3}\\-[0-1]?[0-9]\\-[0-3]?[0-9]")
	private String dateOfBirth;

	@NotNull
	@Range(min=1, max=20)
	private Float weight;

	@NotBlank
	@Size(max=20)
	private String nameOfOwner;

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

}
