package controller;

import bean.*;
import service.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class UserInterfaceImplementation implements UserInterface{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<User> al=new ArrayList<User>();
	@Override
	public User registerNewUser() 
	{
		User obj=new User();
		try 
		{
			System.out.println("Enter user Id:");
			int userId = Integer.valueOf(br.readLine());
			if(userId!=0)
		 	{
				System.out.println("Enter user name:");
				String userName=br.readLine();
				if(!(userName.equals("")))
				{
					System.out.println("Enter password:");
					String password=br.readLine();
					if(password.length()>=8)
					{
						obj.setUserId(userId);
						obj.setUserName(userName);
						obj.setPassword(password);
						al.add(obj);
						System.out.println("User registered.");
					}
					else
					{
						System.out.println("Password should be minimum 8 characters\nPlease enter again\n.");
						UserInterfaceImplementation u=new UserInterfaceImplementation();
						u.registerNewUser();
					}
				}
			else
			{
				System.out.println("Enter Correct UserName");
				UserInterfaceImplementation u=new UserInterfaceImplementation();
				u.registerNewUser();
			}
		}
		else
		{
			System.out.println("Enter Correct UserID");
			UserInterfaceImplementation u=new UserInterfaceImplementation();
			u.registerNewUser();
		}
	}
		catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Boolean signIn(String userName, String password) 
	{
		boolean flag=false;
		Iterator<User> it=al.iterator();
		while(it.hasNext())
		{
			User user=(User) it.next();
			
			if(userName.equals(user.getUserName()))
			{
				if(user.getPassword().equals(password))
				{
					flag=true;
					break;
				}
			}
		}
		return flag;
	}

	@Override
	public Boolean signOut() 
	{
		boolean flag=false;
		System.out.println("Are you sure you want to logout?\nType yes or no");
		try {
			String s=br.readLine();
			if(s.equalsIgnoreCase("yes"))
			{
				flag=true;
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return flag;
	}
}
