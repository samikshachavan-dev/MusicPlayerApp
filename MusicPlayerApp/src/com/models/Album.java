package com.models;

import java.util.List;

public class Album {

	private String title;
	private String artistName;
	private List<Song> songs;
	
	public Album(String title, String artistName, List<Song> songs) {
		super();
		this.title = title;
		this.artistName = artistName;
		this.songs = songs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	
}
