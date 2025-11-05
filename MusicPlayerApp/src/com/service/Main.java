package com.service;

import java.util.Scanner;

import com.models.Library;
import com.models.PlayerService;
import com.models.Playlist;
import com.models.Song;
import com.models.User;

public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library.initialize();
		System.out.println("Enter your name:");
		String name = sc.nextLine();
		name = name.trim().toLowerCase();
		System.out.println("Enter your email:");
		String email = sc.nextLine();
		User user;
		PlayerService playService = null;
		if (Library.allUsers.containsKey(name)) {
			user = Library.allUsers.get(name);
			System.out.println("Welcome " + name + "!");
		} else {
			user = new User(name, email);
			Library.allUsers.put(name, user);
			System.out.println("New user created: " + name);
		}
//		
		Boolean flag = true;
		while (flag) {
			System.out.println("===========WELCOME TO MUSIC-PLAYER=============");
			System.out.println("1. Play Song");
			System.out.println("2. Like a Song");
			System.out.println("3. Display liked Songs");
			System.out.println("4. Create Playlist");
			System.out.println("5. Add Songs to Playlist");
			System.out.println("6. Display  Playlist");
			System.out.println("10. Exit");
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			switch (ch) {

			case 1 -> {
				displayAllSongs();
				System.out.println("------------------------------------------------");
				sc.nextLine();
				System.out.println("Enter Song name you want to play:");
				String songName = sc.nextLine();
				Boolean songAvailable=false;
				for (Song song : Library.allSongs.values()) {
					if (song.getTitle().equals(songName)) {
						playService = new PlayerService(song, true, 50);
						playService.play(song);
						songAvailable=true;
						break;
					} 
				}
				if(songAvailable!=true) {
					System.out.println("Song not found");
				}
				
				
			}
			case 2 -> {
				System.out.println("Enter Song name you want to like:");
				String s = sc.next();
				Boolean songFound = false;
				for (Song song : Library.allSongs.values()) {
					if (s.equalsIgnoreCase(song.getTitle())) {
						user.likeSong(song);
						songFound = true;
						break;
					}
				}
				if (songFound != true) {
					System.out.println("Song not found");
				}
			}

			case 3 -> {
				System.out.println("======================Liked Songs======================");
				for (Song song : user.likedSongs) {
					System.out.println(song.getTitle() + "\t\t" + song.getDuration() + "\t\t" + song.getPlayCount());
				}
				System.out.println("======================================================");
			}

			case 4 -> {
				System.out.println("Enter playlist name");
				String playlistName = sc.next();
				System.out.println("Is Public? Enter yes/no");
				String isPublic = sc.next();
				Boolean ispublic = isPublic.equalsIgnoreCase("yes");
				user.createPlaylist(playlistName, ispublic);
			}
			case 5 -> {
				System.out.println("Enter playlist name");
				String playlist = sc.next();
				
				Playlist foundPlaylist = user.getPlaylists().get(playlist);
				if (foundPlaylist != null) {
					System.out.println("Playlist Found!");
					System.out.println("Enter Song to add:");
					String playlistSong = sc.next();
					boolean songFound = false;

					for (Song song : Library.allSongs.values()) {
						if (playlistSong.equalsIgnoreCase(song.getTitle())) {
							user.addSongToPlaylist(playlist, song);
							songFound = true;
							break;
						}
					}

					if (!songFound)
						System.out.println("Song not found!");
				} else {
					System.out.println("Playlist not found!");
				}
			}

			case 6 -> {
				System.out.println("====================DISPLAYING ALL PLAYLISTS=================");
				user.viewPlaylists();
				System.out.println("=============================================================");
			}
			case 10 -> {
				flag = false;
			}
			}
		}
		System.out.println("=============THANK FOR USING MUSIC-PLAYER=============");
	}

	public static void displayAllSongs() {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("| %-25s | %-14s | %-10s |\n", "Song Title", "Duration (min)", "Play Count");
		System.out.println("------------------------------------------------------------------------------");

		for (Song song : Library.allSongs.values()) {
			System.out.printf("| %-25s | %-14.2f | %-10d |\n", song.getTitle(), song.getDuration(),
					song.getPlayCount());
		}
		System.out.println("------------------------------------------------");

	}

}
