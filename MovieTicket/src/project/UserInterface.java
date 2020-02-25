package project;

public interface UserInterface 
{
	public void registerNewUser(); 
	public Boolean signIn(String userId, String password);
	public Boolean signOut();
}
