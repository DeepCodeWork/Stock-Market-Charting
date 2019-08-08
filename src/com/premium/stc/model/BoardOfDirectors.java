package com.premium.stc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="BoardOfDirectors")
public class BoardOfDirectors {

	@NotEmpty
	@Column(name = "name")
	private String name;
	
}
