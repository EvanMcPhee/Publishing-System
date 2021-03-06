package Login;

import java.util.Scanner;

import Users.Operator;

/**
 * basic main function used by all starting users.
 * Used to launch seperate experiences based on the logged in account
 * or wether the user is a guest or not.
 * @author Gibson Dziwinski
 * @version 1.0
 * @since Nov 22, 2018
 *
 */
public class StartUp {

	public static void main(String[] args) {
		
		LoginServer login = new LoginServer();
		
		String intro = "Enter one of the numbers below:\n 1: to Login\n 2: to enter as Guest";
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println(intro);
			String input = sc.nextLine();
			
			if(input.equals("1"))
			{
				System.out.println("Please enter username: ");
				String username = sc.nextLine();
				System.out.print("Please enter password: ");
				String password = sc.nextLine();
				
				Account user = login.validate(username, password);
				
				if(user == null)
				{
					System.out.println("Invalid credentials sorry");
				}
				else
				{
					System.out.println("Welcome " + user.getUsername());
					if(user.getType().equals("O"))
					{
						Operator operator = new Operator(user);
					}
					break;
				}
				
			}
			else if(input.equals("2"))
			{
				//launch guest buyer
			}
			else
			{
				System.out.println("Invalid input please try again");
			}
		}
		
		sc.close();
	}

}
