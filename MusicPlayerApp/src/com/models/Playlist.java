package com.models;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Playlist {
	private String name;
	private List<Song> songs;
	private boolean isPublic;
	public static Scanner sc = new Scanner(System.in);

	public void addSong(String songtitle, Playlist playlist) {
		boolean found = false;
		for (Song song : Library.allSongs.values()) {
			if (song.getTitle().equalsIgnoreCase(songtitle)) {
				playlist.songs.add(song);
				System.out.println(song.getTitle() + " added to playlist " + name);
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("Song not found in library.");
	}

	public void removeSong(Song song, Playlist playlist) {
		if(playlist==null) {
			System.out.println("Playlist not found");
			return;
		}
		playlist.songs.remove(song);
		System.out.println(song.getTitle() + " removed from " + playlist.getName());
		
	}

	public void displaySongs(Playlist p) {

		for (Song song : p.getSongs()) {
			System.out.printf("| %-25s | %-14.2f | %-10d |\n", song.getTitle(), song.getDuration(),
					song.getPlayCount());
		}
	}

	

	public void shuffle(Playlist p, Deque<Song> recentlyPlayed) {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------");
		for (Song song : p.getSongs()) {
			System.out.println(song.getTitle() + " is playing...........");
			recentlyPlayed.addLast(song);
			song.incrementPlayCount(song);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("--------------------------------------");

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
