package com.service;

import java.util.ArrayList;
import java.util.List;
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
			System.out.println("6. View  Playlist");
			System.out.println("7. Play songs from playlist");
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
				Boolean songAvailable = false;
				for (Song song : Library.allSongs.values()) {
					if (song.getTitle().equals(songName)) {
						playService = new PlayerService(song, true, 50);
						playService.play(song);
						songAvailable = true;
						break;
					}
				}
				if (songAvailable != true) {
					System.out.println("Song not found");
				}

			}
			case 2 -> {
				sc.nextLine();
				System.out.println("Enter Song name you want to like:");
				String s = sc.nextLine();
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
				sc.nextLine(); 
				System.out.println("Enter playlist name:");
				String playlistName = sc.nextLine();

				System.out.println("Is Public? Enter yes/no:");
				String isPublic = sc.nextLine();

				Boolean ispublic = isPublic.equalsIgnoreCase("yes");
				user.createPlaylist(playlistName, ispublic);
			}
			case 5 -> {
				sc.nextLine();
				System.out.println("Enter playlist name");
				String playlistName = sc.nextLine();
				Playlist playlist = null;
				Boolean playlistFound = false;

				for (Playlist p : user.getPlaylists().values()) {
					if (playlistName.equals(p.getName())) {
						playlistFound = true;
						playlist = p;
						break;
					}
				}
				if (!playlistFound) {
					System.out.println("Playlist not Found!");
				}

				displayAllSongs();
				Boolean addMoreSongs = true;
				List<Song> songs = new ArrayList<>();
				while (addMoreSongs) {
					System.out.println("1.  Add Song/n2. Exit");
					int ch1 = sc.nextInt();
					sc.nextLine();
					switch (ch1) {
					case 1 -> {
						boolean songFound = false;
						System.out.println("Enter Song Title");
						String songtitle = sc.nextLine();
						for (Song song : Library.allSongs.values()) {
							if (songtitle.equalsIgnoreCase(song.getTitle())) {
								songFound = true;
								songs.add(song);
								break;
							}
						}

						if (songFound != true) {
							System.out.println("Song not found");
						}

					}
					case 2 -> addMoreSongs = false;
					}
				}

				user.addSongToPlaylist(playlist, songs);

			}

			case 6 -> {
				System.out.println("====================DISPLAYING ALL PLAYLISTS=================");
				user.viewPlaylists();
				System.out.println("=============================================================");
			}

			case 7 -> {
				user.viewPlaylists();
				sc.nextLine();
				System.out.println("Enter Playlist name");
				String playlistName = sc.nextLine();
				System.out.println("Enter Song name");
				String playsongTitle = sc.nextLine();

				boolean found = false;
				for (Song song : Library.allSongs.values()) {
					if (playsongTitle.equalsIgnoreCase(song.getTitle())) {
						user.playSong(song, playlistName);
						found = true;
						break;
					}
				}
				if (!found)
					System.out.println("Song not found in library");
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
