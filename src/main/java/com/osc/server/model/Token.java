package com.osc.server.model;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Token extends BaseModel{
	
	private String token;
	private String username;
	Instant time;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	@OneToMany(mappedBy = "token", cascade = CascadeType.ALL)
	List<Activity> activity;

	public Token() {
		
	}
	
	public Token(String username, String token, Instant time) {
		this.username = username;
		this.token = token;
		this.time = time;
	}
	
}
