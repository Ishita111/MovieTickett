package service;

import bean.*;
public interface UserInterface 
{
	public User registerNewUser(); 
	public Boolean signIn(String userId, String password);
	public Boolean signOut();
}