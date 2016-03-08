package com.scrum4.model.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STORY_CAT", schema="BACKLOG")
public class StoryCat {

	public static final String[] columns = {"uuid", "name", "description", "position", "lastModified"};
	
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "uuid", columnDefinition = "BINARY(16)")
	@Id
	private UUID uuid;
	@Column(name="NAME", length=20)
	private String name;
	@Column(name="DESCRIPTION", length=255)
	private String description;
	@Column(name="POSITION")
	private Integer position;
	@Column(name="DATA_IN")
	private Date dataIn;
	@Column(name="LAST_MODIFIED")
	private Date lastModified;
	@Transient
	private Long dataInTr;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "storyCatUUID")
	private Set<UserStory> userStories = new HashSet<UserStory>(0);
	
	
	public Set<UserStory> getUserStories() {
		return this.userStories;
	}

	public void setUserStories(Set<UserStory> userStories) {
		this.userStories = userStories;
	}
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
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
	public Long getDataInTr() {
		return dataInTr;
	}
	public void setDataInTr(Long dataInTr) {
		this.dataInTr = dataInTr;
	}	
}
