/*
Dylan Best
CS 0401
Professor Laboon
Assignment 2
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class Assignment2
{
	public static void main(String[] args)
	{	
		int customer, member, plainPizza = 0, pepPizza = 0, option = 0, pieWhole = 0, pieSlice = 0, cherryPie = 0, piCharm = 0;
		double subtotal = 0, payment = 0, discount = 0, discountSubtotal = 0, tax = 0, total = 0, change = 0;
		Scanner sc = new Scanner(System.in);
		DecimalFormat f = new DecimalFormat("0.00");
		
		System.out.println("Welcome to Pies, Pies and Pis!");
		boolean service = true; //boolean to keep program running until user says there are no customers in line
		while(service)
		{
			System.out.println("Is there a customer in line? (1 = yes, 2 = no)");
			customer = sc.nextInt();
					
			if(customer == 1) //
			{
				System.out.println("Are you a Pie Card member? (1 = yes, 2 = no)");
				member = sc.nextInt();
				
				if(member == 1) //member receives discounts
				{
					System.out.println("Welcome Back, Pie Card holder!");
					System.out.println("	You will receive:");
					System.out.println("Pepperoni pizza for the price of plain");
					System.out.println("$0.25 off a slice of cherry pie");
					System.out.println("$2.00 off a whole cherry pie");
					System.out.println("10% off each Pi charm");
					System.out.println("10% off if the order is $100.00 or more");
					System.out.println("---------------------------------------");
					
					boolean menu = true; //boolean to return the user back to the menu choosing an item
					while(menu)
					{
						System.out.println("	Please choose an option:");
						System.out.println("1) Update Pizza Order");
						System.out.println("2) Update Cherry Pie Order");
						System.out.println("3) Update Charm Order");
						System.out.println("4) Check Out");
						option = sc.nextInt();
						
						switch(option) //helps the customer buy what they want based off their menu choice
						{
							case 1: 
							System.out.println("Here is your current order:");
							if(plainPizza == 0 && pepPizza == 0)
							{
								System.out.println("No pizzas ordered.");
							}
							else
							{
								System.out.println(plainPizza + " plain pizzas ordered.");
								System.out.println(pepPizza + " pepperoni pizzas ordered.");
							}
							System.out.println("How many plain pizzas would you like for $10.00 each?");
							plainPizza = sc.nextInt();
							System.out.println("How many pepperoni pizzas would you like for $10.00 each?");
							pepPizza = sc.nextInt();
							break;
							
							case 2:
							System.out.println("Here is your current order:");
							if(pieWhole == 0 && pieSlice == 0)
							{
								System.out.println("No cherry pies ordered.");
							}
							else
							{
								System.out.println(pieWhole + " cherry pies ordered.");
								System.out.println(pieSlice + " cherry pie slices ordered.");
							}
							System.out.println("How many cherry pie slices would you like for:");
							System.out.println("$1.75 per slice");
							System.out.println("8.00 per pie (6 slices)");
							cherryPie = sc.nextInt();
							pieWhole = cherryPie/6;
							pieSlice = cherryPie%6;
							break;
							
							case 3:
							System.out.println("Here is your current order:");
							if(piCharm == 0)
							{
								System.out.println("No pi charms ordered.");
							}
							else
							{
								System.out.println(piCharm + " pi charms ordered.");
							}
							System.out.println("How many pi charms would you like for $45.00?");
							piCharm = sc.nextInt();
							break;
							
							case 4: //checking out
							System.out.println("Here is your subtotal:");
							if(plainPizza == 0 && pepPizza == 0 && pieWhole == 0 && pieSlice == 0 && piCharm == 0)
							{
								System.out.println("No items purchased! Thanks anyway for shopping!");
								menu = false;
							}
							else
							{
								if(plainPizza > 0)
								{
									System.out.println(plainPizza + " plain pizzas at $10.00ea.:	$" + f.format(10*plainPizza) + ".00");
								}	
								else{}
								if(pepPizza > 0)
								{	
									System.out.println(pepPizza + " pepperoni pizzas at $10.00ea.:	$" + f.format(10*pepPizza) + ".00");
								}
								else{} 
								if(pieWhole > 0)
								{
									System.out.println(pieWhole + " whole cherry pies at $8.00ea.:	$" + f.format(8*pieWhole) + ".00");
								}
								else{}
								if(pieSlice > 0)
								{
									System.out.println(pieSlice + " cherry pie slices at $1.75ea.:	$" + f.format(1.75*pieSlice) + ".00");
								}
								else{}
								if(piCharm > 0)
								{
									System.out.println(piCharm + " 14K gold Pi charms at $45.00ea.:	$" + f.format(45*piCharm) + ".00");
								}
								else{}
								{
									subtotal = 10*plainPizza + 10*pepPizza + 8*pieWhole + 1.75*pieSlice + 45*piCharm;
									System.out.println("-----------------------------------------------------");
									if(subtotal >= 100.00) //since user is member, checks if the price is over $100.00
									{
										System.out.println("Subtotal:				$" + f.format(subtotal));
										discount = subtotal*0.10;
										System.out.println("Bonus discount of 10%:			($" + f.format(discount) + ")");
										System.out.println("						--------------");
										discountSubtotal = subtotal*0.90;
										System.out.println("New subtotal:				$" + f.format(discountSubtotal));
										tax = discountSubtotal*0.07;
										System.out.println("Tax:					$" + f.format(tax));
										System.out.println("					--------------");
										total = discountSubtotal + tax;
										System.out.println("Total:					$" + f.format(total));
									}
									else
									{
										System.out.println("Subtotal:				$" + f.format(subtotal));
										tax = subtotal*0.07;
										System.out.println("Tax:					$" + f.format(tax));
										System.out.println("					--------------");
										total = subtotal + tax;
										System.out.println("Total:					$" + f.format(total));
									}
									do //do-while to make sure they enter a valid payment amount
									{
										System.out.println("Please enter your payment amount:");
										payment = sc.nextDouble();
									}
									while(payment < total);
									change = payment - total;
									System.out.println("Your change:				$" + f.format(change));
									System.out.println("Thank you for shopping at PP&P!");
									menu = false; //this customer is done, takes user out of menu and back to if there is a customer in line
								}	
							}
						}
					}
				}
				else //same as everything above except the customer is not a member
				{
					boolean menu = true;
					while(menu)
					{
						System.out.println("	Please choose an option:");
						System.out.println("1) Update Pizza Order");
						System.out.println("2) Update Cherry Pie Order");
						System.out.println("3) Update Charm Order");
						System.out.println("4) Check Out");
						option = sc.nextInt();
						
						switch(option)
						{
							case 1: 
							System.out.println("Here is your current order:");
							if(plainPizza == 0 && pepPizza == 0)
							{
								System.out.println("No pizzas ordered.");
							}
							else
							{
								System.out.println(plainPizza + " plain pizzas ordered.");
								System.out.println(pepPizza + " pepperoni pizzas ordered.");
							}
							System.out.println("How many plain pizzas would you like for $10.00 each?");
							plainPizza = sc.nextInt();
							System.out.println("How many pepperoni pizzas would you like for $12.00 each?");
							pepPizza = sc.nextInt();
							break;
							
							case 2:
							System.out.println("Here is your current order:");
							if(pieWhole == 0 && pieSlice == 0)
							{
								System.out.println("No cherry pies ordered.");
							}
							else
							{
								System.out.println(pieWhole + " cherry pies ordered.");
								System.out.println(pieSlice + " cherry pie slices ordered.");
							}
							System.out.println("How many cherry pie slices would you like for:");
							System.out.println("$2.00 per slice");
							System.out.println("10.00 per pie (6 slices)");
							cherryPie = sc.nextInt();
							pieWhole = cherryPie/6;
							pieSlice = cherryPie%6;
							break;
							
							case 3:
							System.out.println("Here is your current order:");
							if(piCharm == 0)
							{
								System.out.println("No pi charms ordered.");
							}
							else
							{
								System.out.println(piCharm + " pi charms ordered.");
							}
							System.out.println("How many pi charms would you like for $50.00?");
							piCharm = sc.nextInt();
							break;
							
							case 4:
							System.out.println("Here is your subtotal:");
							if(plainPizza == 0 && pepPizza == 0 && pieWhole == 0 && pieSlice == 0 && piCharm == 0)
							{
								System.out.println("No items purchased! Thanks anyway for shopping!");
								menu = false;
							}
							else
							{
								if(plainPizza > 0)
								{
									System.out.println(plainPizza + " plain pizzas at $10.00ea.:	$" + f.format(10*plainPizza) + ".00");
								}
								else{}
								if(pepPizza > 0)
								{
									System.out.println(pepPizza + " pepperoni pizzas at $10.00ea.:	$" + f.format(12*pepPizza) + ".00");
								}
								else{}
								if(pieWhole > 0)
								{
									System.out.println(pieWhole + " whole cherry pies at $8.00ea.:	$" + f.format(10*pieWhole) + ".00");
								}
								else{}
								if(pieSlice > 0)
								{
									System.out.println(pieSlice + " cherry pie slices at $1.75ea.:	$" + f.format(2*pieSlice) + ".00");
								}
								else{}
								if(piCharm > 0)
								{
									System.out.println(piCharm + " 14K gold Pi charms at $45.00ea.:	$" + f.format(50*piCharm) + ".00");
								}
								else{}
								{
									subtotal = 10*plainPizza + 12*pepPizza + 10*pieWhole + 2*pieSlice + 50*piCharm;
									System.out.println("-----------------------------------------------------");
									System.out.println("Subtotal:				$" + f.format(subtotal));
									tax = subtotal*0.07;
									System.out.println("Tax:					$" + f.format(tax));
									System.out.println("					--------------");
									total = subtotal+ tax;
									System.out.println("Total:					$" + f.format(total));
									do
									{
										System.out.println("Please enter your payment amount:");
										payment = sc.nextDouble();
									}
									while(payment < total);
									change = payment - total;
									System.out.println("Your change:				$" + f.format(change));
									System.out.println("Thank you for shopping at PP&P!");
									menu = false;
								}	
							}
						}
					}	
				}
			}	
			else
			{
				service = false; //ends the program when there are no more customers
			}
		}	
	}
}	