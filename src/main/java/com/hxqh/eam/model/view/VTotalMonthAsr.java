package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the V_TOTAL_MONTH_ASR database table.
 * 
 */
@Entity
@Table(name="V_TOTAL_MONTH_ASR")
public class VTotalMonthAsr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="T_ANS")
	private String tAns;

	@Column(name="T_LOST")
	private String tLost;

	@Column(name="UP_ANS")
	private String upAns;

	@Column(name="UP_LOST")
	private String upLost;

	public VTotalMonthAsr() {
	}

	public String getTAns() {
		return this.tAns;
	}

	public void setTAns(String tAns) {
		this.tAns = tAns;
	}

	public String getTLost() {
		return this.tLost;
	}

	public void setTLost(String tLost) {
		this.tLost = tLost;
	}

	public String getUpAns() {
		return this.upAns;
	}

	public void setUpAns(String upAns) {
		this.upAns = upAns;
	}

	public String getUpLost() {
		return this.upLost;
	}

	public void setUpLost(String upLost) {
		this.upLost = upLost;
	}

}