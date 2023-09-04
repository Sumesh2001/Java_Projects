import java.util.*;

//Books
class books
{
	String athor,b_name,b_isu="not yet Issued";
	int b_no,b_edition,iss,samp;
	void accept(int range)
	{
		Scanner a=new Scanner(System.in);
		
		System.out.println("\nEnter Data for "+(range+1)+" Book  ");
		System.out.print("\nEnter Book Name : ");
		b_name=a.nextLine();
		System.out.print("Enter Book ISSN Number : ");
		b_no=a.nextInt();
		
		System.out.print("Enter book Edition Number : ");
		b_edition=a.nextInt();
		a.nextLine();
		System.out.print("Enter Book Author Name : ");
		athor=a.nextLine();
		
		
		
	}
	void issue(int is)
	{
		if(is==1)
		{
			b_isu="issued";
			
		}
		else if(is==0)
		{
			b_isu="not yet Issued";
		}
		
	}
	void sample(int sam)
	{
		samp=sam;
	}
	void display()
	{
		System.out.print("\nBook number is "+b_no);
		System.out.print(" name "+b_name);
		System.out.println(" : "+b_isu);
	}
	void c_display()
	{
		System.out.println("\nBook number is : "+b_no);
		System.out.println("Book name : "+b_name);
		System.out.println("Book Edition : "+b_edition);
		System.out.println("Book Author Name is : "+athor);
		System.out.println("Book : "+b_isu);
	}
}

//User
class user
{
	String s_name,book;
	int eno,rec=0;
	void accept(int range)
	{
		Scanner a=new Scanner(System.in);
		System.out.println("\n\nEnter Data for "+(range+1)+" Student  ");
		System.out.print("\nEnter name : ");
		s_name=a.nextLine();
		System.out.print("Enter Enrollment number : ");
		eno=a.nextInt();
	}
	void display()
	{
		System.out.print("\nEnrollment number "+eno);
		System.out.println(" name "+s_name);
		
	}
	void d_name()
	{
		System.out.print(s_name+"\t\t");
	}
	void issue(String b_name,int samp)
	{
		book=b_name;
		rec=samp;
	}
}

//Main
class project
{
	public static void main(String args[])
	{
		books b[]=new books[100];
		user u[]=new user[100];
		
		for(int i=0;i<20;i++)
		{
			b[i]=new books();
			u[i]=new user();
		}
		int u_cap1=0,u_cap2=0,u_cap3;
		int b_cap1=0,b_cap2=0,b_cap3;
		
		
		String name,pwd;
		int choice;
		Scanner a= new Scanner(System.in);
		
		do
		{
		System.out.print("\n\n1.Admin\n2.User\nEnter Your Choice : ");
		choice=a.nextInt();
		System.out.println("");
		switch(choice)
		{
			case 1:
							
				String c_n="Sumesh";
				String c_pwd="1234";
				int str1,str2,enroll;
				
				a.nextLine();
				System.out.print("Enter Admin User-name : ");
				name=a.nextLine();
				System.out.print("Enter Password : ");
				pwd=a.nextLine();
				
				
				str1=name.compareTo(c_n);
				str2=pwd.compareTo(c_pwd);
	
				if(str1==0&&str2==0)
				{
					System.out.print("\n\n1.Add User\n2.Add books \n3.Show all books\n4.Show all user\n5.Show Record\nEnter The Choice : ");
					int ch=a.nextInt();
					System.out.println(" ");
					switch(ch)
					{
						case 2:
						//add books
						System.out.println("\nEnter Number of Books to be added");
						
						b_cap1=a.nextInt();
						b_cap2=b_cap2+b_cap1;
						b_cap3=b_cap2-b_cap1;
						for(int i=b_cap3;i<b_cap2;i++)
						{
							
							b[i].accept(i);
						
						}
						break;
						case 3:
						//show all books
						for (int i=0;i<b_cap2;i++)
						{
							
							b[i].display();
						}
						System.out.println("Check Complete details :\n1.Yes\n2.No ");
						int opition=a.nextInt();
						switch(opition)
						{
							case 1:
							System.out.println("Enter Book number");
							int ch_b=a.nextInt();
							for (int i=0;i<b_cap2;i++)
							{
								if(ch_b==i)
								{	
									b[i].c_display();
									System.out.println("\nContinue!!!!");
								}
							}
							
							break;
							case 2:
							System.out.println("Continue!!!!");
						}
						break;
						//add user
						case 1:
						System.out.print("\nEnter Number of Students to be added : ");
						
						u_cap1=a.nextInt();
						u_cap2=u_cap2+u_cap1;
						u_cap3=u_cap2-u_cap1;
						for (int i=u_cap3;i<u_cap2;i++)
						{
							u[i].accept(i);
						}
						break;
						//Show all User
						case 4:
						for (int i=0;i<u_cap2;i++)
						{
							
							u[i].display();
						}
						
						
						
						break;
						//Show All Record
						case 5:
						System.out.println("Name\t\tBook");
						for (int i=0;i<u_cap2;i++)
						{
							if(u[i].rec==1)
							{
								u[i].d_name(); 
								System.out.println(u[i].book);
							}
						}
						
					}
				}
				else
				{
					System.out.println("\nInvalid User");
				}
			break;
			case 2:
			
				System.out.println("\n\nEnter Enrollment number : ");
				enroll=a.nextInt();
				for (int i=0;i<u_cap2;i++)
				{
					if(enroll==u[i].eno)
					{
						
						System.out.print("Welcome ");
						u[i].d_name();
						System.out.print("\n");
						int u_ch;
						
						do
						{ 
						
						System.out.print("\n1.Check book\n2.Issue book\n3.Return book\n4.Home\nEnter choice : ");
						u_ch=a.nextInt();
						switch(u_ch)
						{
							case 1:
							//check book status
							for (int j=0;j<b_cap2;j++)
							{
							
								b[j].display();
							}
								System.out.println("Check Complete details :\n1.Yes\n2.No ");
								int opition=a.nextInt();
								switch(opition)
								{
									case 1:
									System.out.println("Enter Book number");
									int ch_b=a.nextInt();
									for (int j=0;j<b_cap2;j++)
									{
										if(ch_b==j)
										{	
											b[j].c_display();
											System.out.println("\nContinue!!!!");
										}
									}
							
									break;
									case 2:
									System.out.println("Continue!!!!");
								}
							
								
							break;
							case 2:
							//issue book
							System.out.print("Enter Book number : ");
							int issu=a.nextInt();
							
							if (b[issu-1].samp==0)
							{	
								b[issu-1].issue(1);
								System.out.println("Book Successfully issued");
								b[issu-1].sample(1);
								u[i].issue(b[issu-1].b_name,1);
								
							}
							else if(b[issu-1].samp==1)
							{
								System.out.println("Book Already issued");
							}
							else
							{
								System.out.println("Invalid Choice");
							}
							
							
							break;
							case 3:
							//return book
							
							System.out.println("Enter Book number");
							int iss=a.nextInt();
							b[iss-1].issue(0);
							b[iss-1].sample(0);
							
						}
						
						}while(u_ch<=3);
						
					}
				}
				
			
		}
		}while(choice<=2);
			
	}
}
