package com.models;

import java.util.Deque;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class User {

	public static Scanner sc=new Scanner(System.in);
	Song s;
	
	private String userName;
	private String email;
	private Set<Song> likedSongs;
	private Map<String, Playlist> playlists;
	private Deque<Song> recentlyPlayed;
	
	public void likeSong(Song song) {
		
	}
	public void createPlaylist(String name) {
		
	}
	public void addSongToPlaylist(String playlistName, Song song) {
		
	}
	
	public void viewPlaylists() {
		
	}
	
	public void playSong(Song song) {
	if(song!=null) {
		
		System.out.println(song.getTitle()+"is playing........");
		song.incrementPlayCount();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	public User(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
		this.likedSongs = null;
		this.playlists = null;
		this.recentlyPlayed = null;
	}
	
	
}
