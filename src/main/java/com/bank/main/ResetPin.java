package com.bank.main;

import java.util.Scanner;

import com.bank.dto.Customer;
import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImp1;

public class ResetPin {
	public static void resetPin(Customer c) 
	 { 
	  Scanner sc=new Scanner(System.in); 
	  CustomerDAO cdao=new CustomerDAOImp1();  
	  System.out.println("Enter your Phone number"); 
	  long phone=sc.nextLong(); 
	  System.out.println("Enter your Mail ID");   
	  String mail=sc.next(); 
	  if(phone==c.getPhone()&&mail.equals(c.getMail())) 
	  { 
	   System.out.println("Set a new Pin"); 
	   int pin=sc.nextInt(); 
	   System.out.println("Confirm the Pin"); 
	   int confirm=sc.nextInt(); 
	   if(pin==confirm) 
	   { 
	    c.setPin(pin); 
	    boolean res=cdao.updateCustomer(c); 
	//updateCustomer() already overridden in deposit module inside CustomerDAOImpl 
	    if(res) 
	    { 
	     System.out.println("Pin updated succdessfully"); 
	    } 
	    else 
	    { 
	     System.out.println("Failed to update the Pin"); 
	    } 
	     
	   } 
	   else 
	   { 
	    System.out.println("Pin mismatch or incorrect Pin");    } 
	  
	  } 
	  else 
	  { 
	   System.out.println("Incorrect Phone number or mail ID"); 
	  } 
	 } 

}
