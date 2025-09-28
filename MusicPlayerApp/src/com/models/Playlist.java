package com.models;

import java.util.List;

public class Playlist {
	private String name;
	private List<Song> songs;
	private boolean isPublic;
	
	public void addSong(Song song) {
		
	}
	
	public void removeSong(Song song) {
		
	}
	
	public void displaySongs() {
		
	}
	
	public void shuffle() {
		
	}

	public Playlist(String name, List<Song> songs, boolean isPublic) {
		this.name = name;
		this.songs = songs;
		this.isPublic = isPublic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	
	
}
