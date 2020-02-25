package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class UserInterfaceImplementation implements UserInterface{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<User> al=new ArrayList<User>();
	@Override
	public void registerNewUser() 
	{
		System.out.println("User ID:");
		int userId;
		try 
		{
			userId = Integer.valueOf(br.readLine());
		 
			System.out.println("Enter name:");
			String userName=br.readLine();
			System.out.println("Enter password:");
			String password=br.readLine();
			User obj=new User();
			obj.setUserId(userId);
			obj.setUserName(userName);
			obj.setPassword(password);
			al.add(obj);
			
		}
		catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public Boolean signIn(String userName, String password) {
		// TODO Auto-generated method stub
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
	public Boolean signOut() {
		
		boolean flag=false;
		System.out.println("Are you sure to logout?....type yes or no");
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
