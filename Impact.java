package Impact;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Impact main source: create a SNS called Impact to connect individual, organization and volunteer.
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/09/2019
 * **/
public class Impact {

	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		String pickedActionMain,pickedINDaction,pickedORGaction,pickedVOLaction,pickedOrg,donationAmount, pickedVLT,from,till, pickedNum;
		int indx = -1;
		List<User> Accounts = new ArrayList<>();
		List<Post> Posts = new ArrayList<>();
		addingAccounts(Accounts);
		MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
		pickedActionMain = in.nextLine();
		
		while (!pickedActionMain.equalsIgnoreCase("X")) {
			if(pickedActionMain.equalsIgnoreCase("A")) {
				
				System.out.println("Do you want to 1)select your account or 2)type in your username and password?");
				pickedNum = in.nextLine();
				while (!pickedNum.equals("1") && !pickedNum.equals("2") ) {
					System.out.println("Invalid input, please pick 1 or 2.");
					pickedNum = in.nextLine();
				}
				if (pickedNum.equals("1")) {
					for (int i = 0; i< Accounts.size();i++) {
						System.out.println((i+1) + ". " + Accounts.get(i).getUserName());
					}
					System.out.print("\nPlease enter a number of your account: ");
					indx = in.nextInt();
					indx = indx -1;
					if(Accounts.get(indx).getClassName().equals("Individual")) {
						System.out.println("Individual Menu=========================================");
						Accounts.get(indx).displayMenu();
						pickedINDaction = in.nextLine();
						while(!pickedINDaction.equalsIgnoreCase("P") && !pickedINDaction.equalsIgnoreCase("M") && !pickedINDaction.equalsIgnoreCase("R") && !pickedINDaction.equalsIgnoreCase("E")) {
							System.out.println("Invalid input, please enter P(post), D(donate), or R(register)..\n");
							pickedINDaction = in.nextLine();
						}
						if(pickedINDaction.equalsIgnoreCase("P")) {
							System.out.println("Do you want to add an image? Y/N: ");
							String selectedAction = in.nextLine();
							while(!selectedAction.equalsIgnoreCase("Y") && !selectedAction.equalsIgnoreCase("N")) {
								System.out.println("Invalid input, please enter Y(yes)or N(no)..\n");
								selectedAction = in.nextLine();
							}
							if(selectedAction.equalsIgnoreCase("N"))
								Posts.add(posting(indx));
							else
								Posts.add(postingWITHimage(indx));
							displayUpdatesFor(Posts,indx);
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
						else if(pickedINDaction.equalsIgnoreCase("M")) {
							if(getAge(((Individual) Accounts.get(indx)).getDOB())<18) {
								System.out.println("We're sorry, donation is allowed over 18 years old. \nBut Thank you so much for your consideration!");
								MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
								pickedActionMain = in.nextLine();
							}
							else {
								for (int i = 0; i < Accounts.size(); i++)
									if(Accounts.get(i).getClassName().equals("Organization")) {
										System.out.println(Accounts.get(i).getUserName());
									}
								System.out.println("Thank you for your consideration! \nLet's pick which organization to donate from above: ");
								pickedOrg = in.nextLine();
								System.out.println("Please enter your desiered donation amount: ");
								donationAmount = in.nextLine();
								Posts.add(new Donation(indx, pickedOrg, donationAmount));
								displayUpdatesFor(Posts,indx);
								MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
								pickedActionMain = in.nextLine();
							}	
						}else if(pickedINDaction.equalsIgnoreCase("R")){
							System.out.println("Okay! let's register to an event! The dates are showing as mm.dd.yyyy");
							for (int i = 0; i < Accounts.size(); i++)
								if(Accounts.get(i).getClassName().equals("Volunteer")) {
									System.out.println(((Volunteer) Accounts.get(i)).displayDetail());
								}
							System.out.print("Which one would you like to join? Enter the event name: ");
							pickedVLT = in.nextLine();
							for (int i = 0; i < Accounts.size(); i++)
								if(Accounts.get(i).getUserName().equals(pickedVLT)) {
									String dateFrom = ((Volunteer) Accounts.get(i)).getFrom();
									Posts.add(new Events(indx, pickedVLT, dateFrom));
								}
							System.out.println("Thank you for joining \"" + pickedVLT + "\"");
							displayUpdatesFor(Posts,indx);
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
						
						else if(pickedINDaction.equalsIgnoreCase("E")){
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
					}
					else if(Accounts.get(indx).getClassName().equals("Organization")) {
						System.out.println("Organization Menu=========================================");
						Accounts.get(indx).displayMenu();
						System.out.print("Enter your choice: ");
						pickedORGaction = in.nextLine();
						while(!pickedORGaction.equalsIgnoreCase("P") && !pickedORGaction.equalsIgnoreCase("E")) {
							System.out.println("Invalid input, please enter P(post) or E(exit)..\n");
							pickedORGaction = in.nextLine();
						}
						if(pickedORGaction.equalsIgnoreCase("P")) {
							System.out.println("Do you want to add an image? Y/N: ");
							String selectedOrgAct = in.nextLine();
							while(!selectedOrgAct.equalsIgnoreCase("Y") && !selectedOrgAct.equalsIgnoreCase("N")) {
								System.out.println("Invalid input, please enter Y(yes)or N(no)..\n");
								selectedOrgAct = in.nextLine();
							}
							if(selectedOrgAct.equalsIgnoreCase("N"))
								Posts.add(posting(indx));
							else
								Posts.add(postingWITHimage(indx));
							displayUpdatesFor(Posts,indx);
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
						else  if(pickedORGaction.equalsIgnoreCase("E")){
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
					}
					else if(Accounts.get(indx).getClassName().equals("Volunteer")) {
						System.out.println("Volunteer Menu=========================================");
						Accounts.get(indx).displayMenu();
						System.out.print("Enter your choice: ");
						pickedVOLaction = in.nextLine();
						while(!pickedVOLaction.equalsIgnoreCase("P") && !pickedVOLaction.equalsIgnoreCase("M") && !pickedVOLaction.equalsIgnoreCase("E")) {
							System.out.println("Invalid input, please enter P(post), M(modify Date/Time/Location)or E(exit)..\n");
							pickedVOLaction = in.nextLine();
						}
						if(pickedVOLaction.equalsIgnoreCase("P")) {
							System.out.println("Do you want to add an image? Y/N: ");
							String pickedVollAction = in.nextLine();
							while(!pickedVollAction.equalsIgnoreCase("Y") && !pickedVollAction.equalsIgnoreCase("N")) {
								System.out.println("Invalid input, please enter Y(yes)or N(no)..\n");
								pickedVollAction = in.nextLine();
							}
							if(pickedVollAction.equalsIgnoreCase("N"))
								Posts.add(posting(indx));
							else
								Posts.add(postingWITHimage(indx));
							displayUpdatesFor(Posts,indx);
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}else if(pickedVOLaction.equalsIgnoreCase("M")) {
							System.out.print("From? ");
							from = in.nextLine();
							System.out.print("Till? ");
							till=in.nextLine();
							((Volunteer) Accounts.get(indx)).setEventDate(from, till);
							System.out.println("Now, " + Accounts.get(indx).getUserName() + "'s date has changed as " + from + " - " + till);
							displayUpdatesFor(Posts,indx);
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}else if(pickedVOLaction.equalsIgnoreCase("E")){
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
					}
					
				}
				if(pickedNum.equals("2")) {
					UserMenu();   // 1.IND 2.ORG 3.VlU++++++++++++++++++++++++++++++++User menu++++++++++++++++++++++++++++++++
					String userType = in.nextLine();
					while (!userType.equals("1") && !userType.equals("2") && !userType.equals("3") ) {
						System.out.println("Invalid input, please pick 1-3.");
						UserMenu();
						userType = in.nextLine();
					}
					if(userType.equals("1")) {  //1111111111111111111111entered Individual Login page111111111111111111111111111111111
						System.out.println("Individual Menu=========================================");
						indx = findUser(Accounts);   // ********** ACTIVE USER'S INDEX NUMBER ********** 
						Accounts.get(indx).displayMenu();
						pickedINDaction = in.nextLine();
						while(!pickedINDaction.equalsIgnoreCase("P") && !pickedINDaction.equalsIgnoreCase("M") && !pickedINDaction.equalsIgnoreCase("R") && !pickedINDaction.equalsIgnoreCase("E")) {
							System.out.println("Invalid input, please enter P(post), D(donate), or R(register)..\n");
							pickedINDaction = in.nextLine();
						}
						if(pickedINDaction.equalsIgnoreCase("P")) {
							System.out.println("Do you want to add an image? Y/N: ");
							String selectedAction = in.nextLine();
							while(!selectedAction.equalsIgnoreCase("Y") && !selectedAction.equalsIgnoreCase("N")) {
								System.out.println("Invalid input, please enter Y(yes)or N(no)..\n");
								selectedAction = in.nextLine();
							}
							if(selectedAction.equalsIgnoreCase("N"))
								Posts.add(posting(indx));
							else
								Posts.add(postingWITHimage(indx));
							displayUpdatesFor(Posts,indx);
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
						else if(pickedINDaction.equalsIgnoreCase("M")) {
							if(getAge(((Individual) Accounts.get(indx)).getDOB())<18) {
								System.out.println("We're sorry, donation is allowed over 18 years old. \nBut Thank you so much for your consideration!");
								MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
								pickedActionMain = in.nextLine();
							}
							else {
								for (int i = 0; i < Accounts.size(); i++)
									if(Accounts.get(i).getClassName().equals("Organization")) {
										System.out.println(Accounts.get(i).getUserName());
									}
								System.out.println("Thank you for your consideration! \nLet's pick which organization to donate from above: ");
								pickedOrg = in.nextLine();
								System.out.println("Please enter your desiered donation amount: ");
								donationAmount = in.nextLine();
								Posts.add(new Donation(indx, pickedOrg, donationAmount));
								System.out.println("Thank you for your donation, your donation $" + donationAmount + " has been donated to \"" + pickedOrg + "\"");
								displayUpdatesFor(Posts,indx);
								MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
								pickedActionMain = in.nextLine();
							}	
						}else if(pickedINDaction.equalsIgnoreCase("R")){
							System.out.println("Okay! let's register to an event! The dates are showing as mm.dd.yyyy");
							for (int i = 0; i < Accounts.size(); i++)
								if(Accounts.get(i).getClassName().equals("Volunteer")) {
									System.out.println(((Volunteer) Accounts.get(i)).displayDetail());
								}
							System.out.print("Which one would you like to join? Enter the event name: ");
							pickedVLT = in.nextLine();
							for (int i = 0; i < Accounts.size(); i++)
								if(Accounts.get(i).getUserName().equals(pickedVLT)) {
									String dateFrom = ((Volunteer) Accounts.get(i)).getFrom();
									Posts.add(new Events(indx, pickedVLT, dateFrom));
								}
							System.out.println("Thank you for joining \"" + pickedVLT + "\"");
							displayUpdatesFor(Posts,indx);
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
						
						else if(pickedINDaction.equalsIgnoreCase("E")){
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
					}else if(userType.equals("2")) {                    //222222222222222222222222Organization222222222222222222222222
						System.out.println("Organization Menu=========================================");
						indx = findUser(Accounts);   // ********** ACTIVE USER'S INDEX NUMBER ********** 
						Accounts.get(indx).displayMenu();
						System.out.print("Enter your choice: ");
						pickedORGaction = in.nextLine();
						while(!pickedORGaction.equalsIgnoreCase("P") && !pickedORGaction.equalsIgnoreCase("E")) {
							System.out.println("Invalid input, please enter P(post) or E(exit)..\n");
							pickedORGaction = in.nextLine();
						}
						if(pickedORGaction.equalsIgnoreCase("P")) {
							System.out.println("Do you want to add an image? Y/N: ");
							String selectedOrgAct = in.nextLine();
							while(!selectedOrgAct.equalsIgnoreCase("Y") && !selectedOrgAct.equalsIgnoreCase("N")) {
								System.out.println("Invalid input, please enter Y(yes)or N(no)..\n");
								selectedOrgAct = in.nextLine();
							}
							if(selectedOrgAct.equalsIgnoreCase("N"))
								Posts.add(posting(indx));
							else
								Posts.add(postingWITHimage(indx));
							displayUpdatesFor(Posts,indx);
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
						else  if(pickedORGaction.equalsIgnoreCase("E")){
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
					}else {//                                              333333333333333333333333333Volunteer3333333333333333333333333333
						System.out.println("Volunteer Menu=========================================");
						indx = findUser(Accounts);   // ********** ACTIVE USER'S INDEX NUMBER ********** 
						Accounts.get(indx).displayMenu();
						System.out.print("Enter your choice: ");
						pickedVOLaction = in.nextLine();
						while(!pickedVOLaction.equalsIgnoreCase("P") && !pickedVOLaction.equalsIgnoreCase("M") && !pickedVOLaction.equalsIgnoreCase("E")) {
							System.out.println("Invalid input, please enter P(post), M(modify Date/Time/Location)or E(exit)..\n");
							pickedVOLaction = in.nextLine();
						}
						if(pickedVOLaction.equalsIgnoreCase("P")) {
							System.out.println("Do you want to add an image? Y/N: ");
							String pickedVollAction = in.nextLine();
							while(!pickedVollAction.equalsIgnoreCase("Y") && !pickedVollAction.equalsIgnoreCase("N")) {
								System.out.println("Invalid input, please enter Y(yes)or N(no)..\n");
								pickedVollAction = in.nextLine();
							}
							if(pickedVollAction.equalsIgnoreCase("N"))
								Posts.add(posting(indx));
							else
								Posts.add(postingWITHimage(indx));
							displayUpdatesFor(Posts,indx);
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}else if(pickedVOLaction.equalsIgnoreCase("M")) {
							System.out.print("From? ");
							from = in.nextLine();
							System.out.print("Till? ");
							till=in.nextLine();
							((Volunteer) Accounts.get(indx)).setEventDate(from, till);
							System.out.println("Now, " + Accounts.get(indx).getUserName() + "'s date has changed as " + from + " - " + till);
							displayUpdatesFor(Posts,indx);
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}else if(pickedVOLaction.equalsIgnoreCase("E")){
							MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
							pickedActionMain = in.nextLine();
						}
					}
				}
				
			}else if(pickedActionMain.equalsIgnoreCase("C")) {
				System.out.println("Okay, let's get ready to become a member of Impact!"); // ======create an account=========
				System.out.print("Please select your choice of account from I (individual), O (organization), V (vlunteer)");
				String selectedType = in.nextLine();
				while(!selectedType.equalsIgnoreCase("I") && !selectedType.equalsIgnoreCase("O") && !selectedType.equalsIgnoreCase("V")) {
					System.out.println("Invalid input, please enter I, O, or V..\n");
					selectedType = in.nextLine();
				}
				if(selectedType.equalsIgnoreCase("I")) {
					Accounts.add(createNewAccountIND());
					System.out.println("Okay, your all set, " + Accounts.get(Accounts.size()-1).getUserName() + "!");
					MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
					pickedActionMain = in.nextLine();
					}else if (selectedType.equalsIgnoreCase("O")) {
						Accounts.add(createNewAccountORG());
						System.out.println("Okay, your all set, " + Accounts.get(Accounts.size()-1).getUserName() + "!");
						MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
						pickedActionMain = in.nextLine();
					}else {
						Accounts.add(createNewAccountVLN());
						System.out.println("Okay, your all set, " + Accounts.get(Accounts.size()-1).getUserName() + "!");
						MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
						pickedActionMain = in.nextLine();
					}
		}else if (pickedActionMain.equalsIgnoreCase("D")) {   // D)isplay
			System.out.println("\n*************************FEED*************************");
			for(int i = 0; i < Posts.size(); i++) {
				if(Posts.get(i).getPostClass().equals("Evennts")) {
					String date = ((Events) Posts.get(i)).getDate();
					if(getDays(date)<1) {
						Posts.remove(i);
					}
				}
			}
			for(int i = 0; i < Posts.size(); i++)
				System.out.println(Accounts.get(Posts.get(i).getIndex()).username + Posts.get(i).toString() + "\n");
			MainMenu();  // ++++++++++++++++++++++++++++++++Main menu++++++++++++++++++++++++++++++++
			pickedActionMain = in.nextLine();

			}
		}
		in.close();
		}

	public static void MainMenu() {
		System.out.println("\nMain Menu=========================================");
		System.out.println("C)reate a new user");
		System.out.println("A)ct as user");
		System.out.println("D)isplay Feed");
	}
	
	public static void UserMenu() {
		System.out.println("\nWelcome to the Impact!!!");
		System.out.print("Please pick your account type from below.\n");
		System.out.println("1: Individual");
		System.out.println("2: Organization");
		System.out.println("3: Volunteer");
	}
	
	public static int nameMatchinguuu(List a, String userName) {
		int indx = 0;
		
		while (indx != a.size())
			if(!userName.equals(((User) a.get(indx)).getUserName())) 
				indx++;
			else if (userName.equals(((User) a.get(indx)).getUserName()))
				return indx;
		return -1;
	}
	
	public static int pwMatchinguuu(List a, String pw) {
		int indx = 0;
		
		while (indx != a.size())
			if(!pw.equals(((User) a.get(indx)).getPassword())) 
				indx++;
			else if (pw.equals(((User) a.get(indx)).getPassword()))
				return indx;
		return -1;
	}
	
	public static int findUser(List a) {
		Scanner in = new Scanner(System.in);
		String userName;
		String password;
		System.out.print("Enter your user name: ");
		userName = in.next();
		nameMatchinguuu(a, userName);
		while(nameMatchinguuu(a, userName) == -1) {
			System.out.print("Data didn't match, please enter your user name: ");
			userName = in.next();
			nameMatchinguuu(a, userName);
		}
		System.out.print("Enter your password: ");
		password = in.next();
		pwMatchinguuu(a, password);
		while(pwMatchinguuu(a, password) == -1) {
			System.out.print("Data didn't match, please enter your password: ");
			password = in.next();
			pwMatchinguuu(a, password);
		}
		while (nameMatchinguuu(a, userName) != pwMatchinguuu(a, password)) {
			System.out.print("Data didn't match, please enter your user name: ");
			userName = in.next();
			nameMatchinguuu(a, userName);
			while(nameMatchinguuu(a, userName) == -1) {
				System.out.print("Data didn't match, please enter your user name: ");
				userName = in.next();
				nameMatchinguuu(a, userName);
			}
			System.out.print("Data didn't match, please enter your password: ");
			password = in.next();
			pwMatchinguuu(a, password);
			while(pwMatchinguuu(a, password) == -1) {
				System.out.print("Data didn't match, please enter your password: ");
				password = in.next();
				pwMatchinguuu(a, password);
			}
		}
		System.out.println("Hello " + userName + ", welcome back to Impact!");
		return pwMatchinguuu(a, password);
	}
	
	public static Post posting(int a) {
		String msg;
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your message: ");
		msg = in.nextLine();
		return new Post(a, msg);
	}
	
	public static Post postingWITHimage(int a) {
		String msg, image, location, action;
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your message: ");
		msg = in.nextLine();
		System.out.println("Please enter the image name: ");
		image = in.nextLine();
		System.out.println("Please enter the location of the image: ");
		location = in.nextLine();
		return new PostWITHimage(a, msg, image, location);
	}
	
	public static User defaultInfo() {
		String name, email, userName, password, bio;
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your name: ");
		name = in.nextLine();
		System.out.print("Please enter your email address: ");
		email = in.nextLine();
		System.out.print("Please set your user name: ");
		userName = in.nextLine();
		System.out.print("Please set your password: ");
		password = in.nextLine();
		System.out.print("Please set your bio: ");
		bio = in.nextLine();
		return new User(name, email, userName, password, bio);
	}
	
	public static User createNewAccountIND() throws ParseException {
		String bio, bankInfo, dob;
		Scanner in = new Scanner(System.in);
		User ind = defaultInfo();
		
		System.out.print("Please enter your birthday in MM/dd/yyy format: ");
		dob = in.nextLine();
		//System.out.println(getAge(dob));
		if(getAge(dob)<18)
			bankInfo = " ";
		else {
			System.out.print("Please enter your bank name: ");
			bankInfo = in.nextLine();
		}
		return new Individual(ind.getName(), ind.getEmail(), ind.getUserName(), ind.getPassword(), ind.getBio(), dob, bankInfo);
	}
	
	public static User createNewAccountORG() {
		String address, bankInfo, phone, taxID;
		Scanner in = new Scanner(System.in);
		User ind = defaultInfo();
		
		System.out.print("Please enter your mailing address: ");
		address = in.nextLine();
		System.out.print("Please enter your bank name: ");
		bankInfo = in.nextLine();
		System.out.print("Please enter your phone number: ");
		phone = in.nextLine();
		System.out.print("Please enter your tax ID: ");
		taxID = in.nextLine();
		return new Organization(ind.getName(), ind.getEmail(), ind.getUserName(), ind.getPassword(), ind.getBio(), address, phone, taxID, bankInfo);
	}
	
	public static User createNewAccountVLN() {
	String address,phone, from, till, time;
	Scanner in = new Scanner(System.in);
	User ind = defaultInfo();
	
	System.out.print("Please enter your mailing address: ");
	address = in.nextLine();
	System.out.print("Please enter your phone number: ");
	phone = in.nextLine();
	System.out.print("Please enter the event starting date in mm/dd/yyy form: ");
	from = in.nextLine();
	System.out.print("Please enter the event ending date in mm/dd/yyy form: ");
	till = in.nextLine();
	System.out.print("Please enter time:");
	time = in.nextLine();
	return new Volunteer(ind.getName(), ind.getEmail(), ind.getUserName(), ind.getPassword(), ind.getBio(), from,till, time, address, phone);
	}
	
	public static int getAge(String dateOfBirth) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date d = sdf.parse(dateOfBirth);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		LocalDate l1 = LocalDate.of(year, month, date);
		LocalDate now1 = LocalDate.now();
		Period diff1 = Period.between(l1, now1);
		
		return diff1.getYears();
	}
	
	public static int getDays(String day) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date d = sdf.parse(day);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		LocalDate l1 = LocalDate.of(year, month, date);
		LocalDate now1 = LocalDate.now();
		Period diff1 = Period.between(l1, now1);
		
		return diff1.getDays();
	}
	
	public static void displayUpdatesFor(List Posts, int indx) {
		for(int i = 0; i< Posts.size(); i++) {
			if (((Post) Posts.get(i)).getIndex() == indx)
				System.out.println("Your post has been posted as\n" + Posts.get(i).toString());
		}
	}
	
	public static void addingAccounts(List Accounts) {
		Accounts.add(new Individual("Jane Doe", "jdoe@csulb.edu", "SerengetiJane", "XxX123", "Biology major @CSULB. Lover of the outdoors and anything creepy crawly.", "08/16/1997", " "));
		Accounts.add(new Individual("Mateo Stevens", "mathmatt03@gmail.com", "MathMatt", "fortniteislifejk", "Books, pizza, and camping trips please.", "05/03/2005", " "));
		
		Accounts.add(new Organization("World Wide Fund for Nature", "wwf@gmail.com", "WWF", "1234", "Working to conserve nature and reduce the most pressing threats to the diversity of life on Earth.", "1250 24th Street, N.W. Washington, DC 20037", "(202) 293-4800", "52-1693387", "1234 5678 9012"));
		Accounts.add(new Organization("Girl Scouts of the USA", "gsusa@gmail.com", "GirlScoutsUSA", "12345", "Offering the best leadership development experi- ence for girls in the world.", "420 Fifth Avenue at 37th Street – Ground Floor.", "(800) 478-7248", "13-1624016", "9999 0000 1111 2222"));
		
		Accounts.add(new Volunteer("Seal Beach Clean-Up", "saveSealBeach@gmail.com", "SealBeachCleanUp", "sSBcup", "A group of caring neighbors looking out for our beaches.", "10/12/2019", "10/13/2019","9am - noon", "Seal Beach Municipal Pier, Old Towne, CA 90740", "562) 555-5555"));
	}
	
}

