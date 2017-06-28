package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_ENT_BUS_TOP_THREE database table.
 * 
 */
@Entity
@Table(name="V_ENT_BUS_TOP_THREE")
public class VEntBusTopThree implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	@Column(name="\"VALUE\"")
	private BigDecimal value;

	public VEntBusTopThree() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}