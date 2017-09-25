/************************************************
* COURSE:			  CS112 T -Th 1:30-3:20
* CHAPTER:	10 Handout2	 PROJECT NUMBER:	1
* PROGRAMMER: 		  Gabriel Siguenza
* DATE LAST MODIFIED: 09.23.2017
************************************************/

/*************************************************************************************************
* PROGRAM TITLE: IntegerFileIO  
* DESCRIPTION:	reads a file of numbers of type int and outputs all the numbers to another file, 
* but without any duplicate numbers.
* 
* ALGORITHM: 
* 
* 
* IMPORTED PACKAGES:  Scanner, FileInputStream, PrintWriter, FileOutputStream, FileNotFoundException
*******************************************************************************/

import java.util.Scanner;
import java.io.FileInputStream;

import java.io.PrintWriter;
import java.io.FileOutputStream;

import java.io.FileNotFoundException;


public class IntegerFileIO
{
	/************ CONSTANTS ***********/
	
	
	public static void main(String[] args)
	{
		
		/************ VARIABLE DECLARATION ************/
		Scanner inputStream, key;
		PrintWriter outputStream;
		String fileName;
		boolean valid;
		PartiallyFilledArray intArray;
		
		/************ VARIABLE INITIALIZATION ************/
		key = new Scanner(System.in);
		inputStream = null;
		outputStream = null;
		fileName = "";
		valid = false;
		intArray = new PartiallyFilledArray();
		
		/************ PROCESSING ************/
		do
		{
			try
			{
				System.out.print("Please enter the name of a txt file containing integers on each line.\n");
				System.out.print("Open file: ");
				fileName = key.nextLine();
				inputStream = new Scanner(new FileInputStream(fileName));  //Exception will be thrown by java if file name does not match.
				System.out.println("Still in try loop");  //this will only execute if no exceptions are thrown.
				valid = true;
			}
			catch (FileNotFoundException e)		//catch blocks are ignored if no exception is thrown.
			{
				System.out.println("ERROR: File " + fileName + " was not found or could not be opened.");
				System.out.println("Please try another file name.");
			}
		}while(!valid); //allows user to reenter fileName.
		
		// After do while is terminated and fileName is obtained we have to open the file and read in the contents.
		/* The file will look something like this:
		 * 				SomeFile.txt
		 * 12
		 * 34
		 * 1
		 * 5
		 * 90
		 * 65
		 * 6
		 * ... and so on.
		 */
		 
		// in order to read an int from each file we need: an array to hold the numbers maybe a class? inputStream to read the numbers in from the file. 
		/****************************************************************
		 * Here we will call some methods to handle the data from the file.
		 * Some array methods, sorting methods etc.
		 * Lets start by creating a method that reads in valid ints and sorts them into an array IN SEQUENTIAL ORDER, ignoring previously represented numbers.
		 * (Re-read programming with arrays and relevant material.)
		 ********************************************/ 
		
		// stores integers from text file into an array.
		while(inputStream.hasNextInt())
		{
			intArray.add(inputStream.nextInt());
		}
		
		inputStream.close();
		
		intArray.printArray();
		
		int[] a2 = new int[intArray.getNumberOfElements()];
		
		
		for(int i = 0; i < a2.length; i++)
		{
			a2[i] = intArray.getElement(i);
			//System.out.println("Index #" + (i + 1) + " " + a[i]);
		}
		
		intArray.sort(a2.length,a2);
		
		for(int i = 0; i < a2.length; i++)
		{
		
			intArray.resetElement(i, a2[i]);
		}
		
		for(int i = 0; i < intArray.getNumberOfElements(); i++)
		{
		
			for(int j = (i + 1); j < intArray.getNumberOfElements(); j++)
			{
				System.out.println("comparing " + a2[i] + " to " + a2[j]);
				if(intArray.getElement(i) == intArray.getElement(j))
				{
					intArray.delete(j);
				} 
			}
			
		}
		//intArray deleteDuplicates();
		System.out.println();
		intArray.printArray();
		
		// store contents in text file.
		
		//Once we have our array with ints we can use outputStream to write them into a new file, repeat the try catch blocks for user input to obtain name for the new file
		do
		{
			try
			{
				System.out.print("Please enter a name for the new text file.\n");
				System.out.print("Create file: ");
				
				fileName = key.nextLine();
				System.out.print("\nCreating new text file with name " + fileName + "...");
				
				outputStream = new PrintWriter(new FileOutputStream(fileName));  //Exception will be thrown by java if file name does not match.
				System.out.println("Still in try loop");  //this will only execute if no exceptions are thrown.
				valid = true;
				
			}
			
			// include catch blocks for incorrect input or call a method?
			catch (FileNotFoundException e)									//catch blocks are ignored if no exception is thrown.
			{
				System.out.println("ERROR: File " + fileName + " could not be written.");
				System.out.println("Please try another file name."); //not sure if I should include this or remove.
			}
			
		}while(!valid); //allows user to reenter fileName.
		
		// Im thinking were gonna need another class or method to perform an algorithm for sorting the numbers and making sure there are no duplicates.
		// May have to study sorting arrays from the book. 
		for(int i = 0; i < intArray.getNumberOfElements(); i++)
		{
			
			outputStream.println("" + intArray.getElement(i));
		}
		
		outputStream.close();
		
	}
		
		
}
