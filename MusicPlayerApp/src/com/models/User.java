package com.models;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class User {

	public static Scanner sc=new Scanner(System.in);
	public static Playlist p;
	private String userName;
	private String email;
	public Set<Song> likedSongs;
	private Map<String, Playlist> playlists;
	private Deque<Song> recentlyPlayed;
	
	public void likeSong(Song song) {
		if(song!=null) {
			likedSongs.add(song);
			System.out.println("Song Liked!!");
		}
		else {
			System.out.println("Song cannot be added");
		}
	}
	public Playlist createPlaylist(String name, Boolean isPublic) {
		for(Playlist p:playlists.values()) {
			if(name.equalsIgnoreCase(p.getName())) {
				System.out.println("Playlist already exists");
				return p;
			}
		}
		Playlist newPlaylist=new Playlist(name, isPublic);
		playlists.put(name, newPlaylist);
		return newPlaylist;
	}
	
	public void addSongToPlaylist(String playlistName, Song song) {
		Playlist playlist = playlists.get(playlistName);
	    if (playlist != null && song != null) {
	        playlist.addSong(song);
	        System.out.println("Song added to playlist: " + playlistName);
	    } else {
	        System.out.println("Playlist or Song not found");
	    }
	}
	
	public void viewPlaylists() {
		for(Playlist p:playlists.values()) {
			System.out.println("Playlist Name:"+p.getName()+"Is Public"+(p.isPublic()?"yes":"no"));
			p.displaySongs();
		}
	}
	
	public void playSong(Song song) {
	
	}
	public User(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
		this.likedSongs = new HashSet<>();
		this.playlists = new HashMap<>();
		this.recentlyPlayed = null;
	}
	public Set<Song> getLikedSongs() {
		return likedSongs;
	}
	public void setLikedSongs(Set<Song> likedSongs) {
		this.likedSongs = likedSongs;
	}
	public Map<String, Playlist> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(Map<String, Playlist> playlists) {
		this.playlists = playlists;
	}
	public Deque<Song> getRecentlyPlayed() {
		return recentlyPlayed;
	}
	public void setRecentlyPlayed(Deque<Song> recentlyPlayed) {
		this.recentlyPlayed = recentlyPlayed;
	}
	
	
}
