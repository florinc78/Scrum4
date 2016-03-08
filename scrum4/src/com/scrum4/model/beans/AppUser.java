package com.scrum4.model.beans;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "APP_USER", schema="BACKLOG")
public class AppUser {
	public static final String[] columns = {"uuid", "userId", "userName", "dataIn"};

	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "uuid", columnDefinition = "BINARY(16)")
	@Id
	private UUID uuid;
	@Column(name = "userid")
	private Integer userId;
	@Column(name = "username")
	private String userName;
	@Column(name = "datain")
	private Date dataIn;	
	@Column(name = "dataout")
	private Date dataout;
	@Column(name = "lastmodified")
	private Date lastmodified;
	@Transient
	private Long dataInTr;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDataIn() {
		return dataIn;
	}

	public void setDataIn(Date dataIn) {
		this.dataIn = dataIn;
	}

	public Date getDataout() {
		return dataout;
	}

	public void setDataout(Date dataout) {
		this.dataout = dataout;
	}

	public Date getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Long getDataInTr() {
		return dataInTr;
	}

	public void setDataInTr(Long dataInTr) {
		this.dataInTr = dataInTr;
	}
}
