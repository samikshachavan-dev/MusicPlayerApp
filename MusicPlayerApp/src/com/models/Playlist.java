package com.models;

import java.util.LinkedList;
import java.util.List;

public class Playlist {
	private String name;
	private List<Song> songs;
	private boolean isPublic;
	
	public void addSong(Song song) {
		songs.add(song);
		System.out.println(song.getTitle()+"added successfully to your playlist");
	}
	
	public void removeSong(Song song) {
		
	}
	
	public void displaySongs() {
		for(Song s:songs) {
			System.out.println("Song Name"+s.getTitle()+"\t\tGenre"+s.getGenre()+"\t\tDuration"+s.getDuration()+"\t\tPlayCount"+s.getPlayCount());
		}
	}
	
	public void shuffle() {
		
	}

	public Playlist(String name, boolean isPublic) {
		this.name = name;
		this.isPublic = isPublic;
		this.songs=new LinkedList<Song>();
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
