package com.service;

import java.util.Scanner;

import com.models.Library;
import com.models.Song;
import com.models.User;

public class Main {

	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter your name:");
		String name=sc.next();
		System.out.println("Enter your email:");
		String email=sc.next();
		User user=new User(name, email);
		Library.initializeSongs();
		Boolean flag=true;
		while(flag) {
			System.out.println("===========WELCOME TO MUSIC-PLAYER=============");
			System.out.println("1. Play Song");
			System.out.println("2. Exit");
			System.out.println("Enter your choice:");
			int ch=sc.nextInt();
			switch(ch) {
			case 1->{
				System.out.println("Enter Song name you want to play");
				String s=sc.next();
				for(Song song:Library.allSongs.values()) {
					if(s.equalsIgnoreCase(song.getTitle()))
					{
						user.playSong(song);
						break;
					}
					else {
						System.out.println("Song not found");
					}
				}
				
			}
			case 2->{
				flag=false;
				
			}
			}
			
		}
		System.out.println("============THANK FOR USING MUSIC-PLAYER=======================");
		
		
		
	}

}
