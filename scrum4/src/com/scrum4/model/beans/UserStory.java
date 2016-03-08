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
@Table(name = "USER_STORY", schema="BACKLOG")
public class UserStory {

	public static final String[] columns = {"uuid", "name", "dataIn", "lastModified"};
	
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "uuid", columnDefinition = "BINARY(16)")
	@Id
	private UUID uuid;
	
	@Column(name="STORY_CAT_UUID", length=20)
	private String storyCatUUID;
	@Column(name="CODE", length=20)
	private String code;
	@Column(name="STATE", length=20)
	private String state;
	@Column(name="ACTOR", length=255)
	private String actor;
	@Column(name="ACTION", length=255)
	private String action;
	@Column(name="TARGET", length=255)
	private String target;
	@Column(name="COMMENTS", length=255)
	private String comments;
	@Column(name="POINTS")
	private Integer points;
	@Column(name="DATA_IN")
	private Date dataIn;
	@Column(name="LAST_MODIFIED")
	private Date lastModified;
	@Transient
	private Long dataInTr;
	
	public String getStoryCatUUID() {
		return storyCatUUID;
	}
	public void setStoryCatUUID(String storyCatUUID) {
		this.storyCatUUID = storyCatUUID;
	}
	public Long getDataInTr() {
		return dataInTr;
	}
	public void setDataInTr(Long dataInTr) {
		this.dataInTr = dataInTr;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Date getDataIn() {
		return dataIn;
	}
	public void setDataIn(Date dataIn) {
		this.dataIn = dataIn;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
}
