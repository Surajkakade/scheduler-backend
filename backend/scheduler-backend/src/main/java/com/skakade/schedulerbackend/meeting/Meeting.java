package com.skakade.schedulerbackend.meeting;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.skakade.schedulerbackend.user.User;
import com.skakade.schedulerbackend.userMeeting.UserMeeting;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private Date time;
	
	private String description;
	

	
	@OneToMany(mappedBy = "meeting")
    List <UserMeeting> userMeetingStatus;
	

	public Meeting() {

	}

	public Meeting(long id, String title, Date time, String description, List<UserMeeting> userMeetingStatus) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
		this.description = description;
		this.userMeetingStatus = userMeetingStatus;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserMeeting> getUserMeetingStatus() {
		return userMeetingStatus;
	}

	public void setUserMeetingStatus(List<UserMeeting> userMeetingStatus) {
		this.userMeetingStatus = userMeetingStatus;
	}
	

	
}
