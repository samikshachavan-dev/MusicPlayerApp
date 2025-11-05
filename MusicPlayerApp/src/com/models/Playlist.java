package com.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Playlist {
	private String name;
	private List<Song> songs;
	private boolean isPublic;
	public static Scanner sc = new Scanner(System.in);
	
	public void addSong(String songtitle) {
		for (Song s : Library.allSongs.values()) {
			if (songtitle.equals(s.getTitle())) {
				songs.add(s);
				break;
			}
		}
	}

	public void removeSong(Song song) {

	}

	public void displaySongs() {
		for(Song song:songs) {
			System.out.println(song.getTitle() + "\t\t" + song.getDuration() + "\t\t" + song.getPlayCount());
			
		}
	}

	public void shuffle() {

	}

	public Playlist(String name, boolean isPublic) {
		this.name = name;
		this.isPublic = isPublic;
		this.songs = new ArrayList<Song>();
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
