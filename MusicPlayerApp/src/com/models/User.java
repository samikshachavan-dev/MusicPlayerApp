package com.models;

import java.util.Deque;
import java.util.Map;
import java.util.Set;

public class User {

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
		
	}
}
