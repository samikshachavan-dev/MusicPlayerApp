package com.models;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.service.Main;

public class User {

	public static Scanner sc = new Scanner(System.in);
	private String userName;
	private String email;
	public Set<Song> likedSongs;
	private Map<String, Playlist> playlists;
	private Deque<Song> recentlyPlayed;

	Playlist playlist = null;

	public void likeSong(Song song) {
		if (song != null) {
			likedSongs.add(song);
			System.out.println("Song Liked!!");
		} else {
			System.out.println("Song cannot be added");
		}
	}

	public void createPlaylist(String name, Boolean isPublic) {
		playlist = new Playlist(name, isPublic);
		System.out.println(name + " is created");
		Main.displayAllSongs();

		boolean addMoreSongs = true;
		while (addMoreSongs) {
			System.out.println("1. Add Song\n2. Exit"); 
			System.out.print("Enter your choice: ");

			
			if (!sc.hasNextInt()) {
				System.out.println("Please enter a valid number (1 or 2).");
				sc.nextLine(); 
				continue;
			}

			int ch = sc.nextInt();
			sc.nextLine(); 

			switch (ch) {
			case 1 -> {
				System.out.println("Enter Song Title:");
				String songtitle = sc.nextLine();

				
				boolean found = false;
				for (Song song : Library.allSongs.values()) {
					if (song.getTitle().equalsIgnoreCase(songtitle)) {
						playlist.getSongs().add(song);
						System.out.println(song.getTitle() + " added to playlist " + name);
						found = true;
						break;
					}
				}

				if (!found)
					System.out.println("Song not found in library.");
			}

			case 2 -> addMoreSongs = false;

			default -> System.out.println("Invalid choice. Enter 1 or 2.");
			}
		}
		playlists.put(name, playlist);

	}

	public void addSongToPlaylist(Playlist playlist, List<Song> newSongs) {
		// TODO Auto-generated method stub
		if (playlist == null) {
			System.out.println("Playlist not found!");
			return;
		}
		List<Song> existingSongs = playlist.getSongs();
		existingSongs.addAll(newSongs);

		playlists.put(playlist.getName(), playlist);

		System.out.println("Songs added successfully to playlist: " + playlist.getName());
	}

	public void viewPlaylists() {
		for (Playlist p : playlists.values()) {
			System.out.println("----------------------------------------------------------");
			System.out.println("Playlist Name: " + p.getName() + " | Public: " + (p.isPublic() ? "Yes" : "No"));
			System.out.println("----------------------------------------------------------");
			System.out.printf("| %-25s | %-14s | %-10s |\n", "Song Title", "Duration (min)", "Play Count");
			System.out.println("--------------------------------------------------------------------");

			for (Song song : p.getSongs()) {
				System.out.printf("| %-25s | %-14.2f | %-10d |\n", song.getTitle(), song.getDuration(),
						song.getPlayCount());
			}

			System.out.println("--------------------------------------------------------------------");
		}

	}

	public void playSong(Song song, String playlistName) {
		// TODO Auto-generated method stub
		for (Playlist playlist : playlists.values()) {
			if (playlist.getName().equalsIgnoreCase(playlistName)) {
				if (playlist.getSongs().contains(song))
					System.out.println(song.getTitle() + " is playing.........");
				try {
					song.incrementPlayCount(song);
				} catch (NoSuchMethodError | AbstractMethodError e) {
					song.incrementPlayCount(song);
				}
				return;
			} else {
				System.out.println("Song '" + song.getTitle() + "' not found in playlist '" + playlistName + "'.");
				return;
			}
		}
		System.out.println("Playlist not found: " + playlistName);
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
