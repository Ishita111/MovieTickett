package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
import bean.*;
public class UserMain {

	public static void main(String[] args) 
	{
			try 
			{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int n;
			do {
			System.out.println("\tONLINE MOVIE TICKET SYSTEM");
			System.out.println("\nMenu-");
			System.out.println("1. New Registration");
			System.out.println("2. Sign In");
			System.out.println("3. Sign Out");
			System.out.println("Enter your choice (1-3):");
			n=Integer.parseInt(br.readLine());
			
			switch(n)
			{
			case 1:
				UserInterfaceImplementation usi=new UserInterfaceImplementation();
				usi.registerNewUser();
				break;
				
			case 2:
				System.out.println("Enter your username:");
				String username=br.readLine();
				System.out.println("Enter your password:");
				String pass=br.readLine();
				UserInterfaceImplementation obj2=new UserInterfaceImplementation();
				boolean flag1=obj2.signIn(username,pass);
				if(flag1==true)
				{
					System.out.println("Logged In succesfully!");
				}
				else
					System.out.println("UserId not registered...Press 1 to register.");
					break;
				
			case 3:
				UserInterfaceImplementation obj3=new UserInterfaceImplementation();
				boolean flag2=obj3.signOut();
				if(flag2==true)
				{
					System.out.println("Signout succesfull!!");
				}
				else
					System.out.println("Signout failed!!");
				    break;
			default:
				System.out.println("Invalid choice!!");
			}
		}
		while(n<=3);
		}
		catch(Exception e)
			{
			e.printStackTrace();
			}
	}
}