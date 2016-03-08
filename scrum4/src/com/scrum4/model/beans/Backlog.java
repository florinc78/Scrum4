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
@Table(name = "BACKLOG", schema = "BACKLOG")
public class Backlog {
	
	public static final String[] columns = {"uuid", "name", "dataIn", "lastmodified"};

	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "uuid", columnDefinition = "BINARY(16)")
	@Id
	private UUID uuid;
	@Column(name = "name")
	private String name;
	@Column(name = "data_in")
	private Date dataIn;
	@Column(name = "last_modified")
	private Date lastmodified;
	@Transient
	private Long dataInTr;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDataIn() {
		return dataIn;
	}
	public void setDataIn(Date dataIn) {
		this.dataIn = dataIn;
	}
	public Date getLastmodified() {
		return lastmodified;
	}
	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}
	public Long getDataInTr() {
		return dataInTr;
	}
	public void setDataInTr(Long dataInTr) {
		this.dataInTr = dataInTr;
	}
	
	
}
