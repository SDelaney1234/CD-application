package com.qa.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class CD {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(name="title")
	private String title;
	
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
//  @ManyToMany
//	@JoinTable(name="cd",
//			   joinColumns=@JoinColumn(name="artist", referencedColumnName="name"),
//			   inverseJoinColumns=@JoinColumn(name="PROJ_ID", referencedColumnName="ID"))
	private Collection<Artist> artists= new ArrayList<Artist>();
	
	public CD() { }
	
	public CD(String title, List<Artist> artists) {
		this.title= title;
		this.artists= artists;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Collection<Artist> getArtists() {
		return artists;
	}

	public void setArtists(Collection<Artist> artists) {
		this.artists = artists;
	}
	
	
	
	
}
