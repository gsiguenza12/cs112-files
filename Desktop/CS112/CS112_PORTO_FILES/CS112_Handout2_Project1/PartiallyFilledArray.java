/************************************************
* COURSE:			  CS112 T -Th 1:30-3:20
* CHAPTER:			PROJECT NUMBER:	
* PROGRAMMER: 		  Gabriel Siguenza
* DATE LAST MODIFIED: 00.00.0000
************************************************/

/************************************************
* PROGRAM TITLE:	  
* DESCRIPTION:		  
* 
* ALGORITHM: 
* 
* IMPORTED PACKAGES:  N/A
************************************************/
public class PartiallyFilledArray
{
	
	/************ CONSTANTS ***********/
	public static final int MAX_LENGTH = 100000; 
	
	/************ VARIABLE DECLARATION ************/
	private int[] intArray;
	private int numUsed;
	private int maxCapacity;

	/************ CONSTRUCTORS ************/
	PartiallyFilledArray()
	{
		intArray = new int[MAX_LENGTH];
		maxCapacity = MAX_LENGTH;
		numUsed = 0;
	}
	
	PartiallyFilledArray(int arraySize)
	{
		if(arraySize <= 0)
		{
			System.out.println("Array size zero or negative.");
		}
		
		intArray = new int[arraySize];
		maxCapacity = arraySize;
		numUsed = 0;
	}
	
	PartiallyFilledArray(PartiallyFilledArray original)
	{
		if(original == null)
		{
			System.out.println("Fatal error");
		}
		intArray = new int[original.maxCapacity];
		numUsed = original.numUsed;
		
		for(int i = 0; i < numUsed; i++)
		{
			intArray[i] = original.intArray[i];
		}
	}
	
	
	
	/************ ACCESSORS ************/
	public int getNumberOfElements()
	{
		return numUsed;
	}
	
	public int getCapacity()
	{
		return maxCapacity;
	}
	
	public int getNumber(int index)
	{
		if (index < 0 || index >= numUsed)
		{
			System.out.println("Error: Illegal or unused index");
			System.exit(0);
		}
		
		return intArray[index];
	}
	
	public boolean empty()
	{
		return (numUsed == 0);
	}
	
	public boolean full()
	{
		return (numUsed == MAX_LENGTH);
	}
		
	/************ MUTATORS ************/
	public void add(int newElement)
	{
		if(numUsed >= intArray.length)
		{
			System.out.println("Array is filled to capacity");
			System.exit(0);
		}
		else
		{
			intArray[numUsed] = newElement;
			numUsed ++;
		}
	}
	
	public int getElement(int index)
	{
		if(index < 0 || index >= numUsed)
		{
			System.out.println("Illegal index!");
		}
		return intArray[index];
	}
	
	public void resetElement(int index, int newValue)
	{
		if (index < 0 || index >= maxCapacity) 
		{
			System.out.println("Illegal Index!");
			System.exit(0);
		}
		else
		{
			intArray[index] = newValue;
		}
	}
	
	public void deleteLast()
	{
		if(empty())
		{
			System.out.println("Deleting from an empty array!");
			System.exit(0);
		}
		else
		{
			numUsed--;
		}
	}
	
	public void delete(int index)
	{
		if(index < 0 || index >= numUsed)
		{
			System.out.println("Illegal Index!");
			System.exit(0);
		}
		
		for(int i = index; i < numUsed; i++)
		{
			intArray[i] = intArray[i + 1];
		}
		numUsed--;
	}
	
	/************ CLASS METHODS ************/
	public void printArray()
	{
		for(int i = 0; i < numUsed; i++)
		{
			System.out.println("Index #" + (i + 1) + " = " + intArray[i]);
		}
	}
	
	public static void sort(int numUsed, int[] intArray)
		{
			int index, indexOfNextSmallest;
			
			for(index = 0; index < numUsed; index++)
			{
				indexOfNextSmallest = indexOfNextSmallest(index, numUsed, intArray);
				interchange(index,indexOfNextSmallest, intArray);
			}
			
			
		}
		
		public static int indexOfNextSmallest(int startIndex, int numUsed, int[] intArray)
		{
			int min = intArray[startIndex];
			int indexOfMin = startIndex;
			int index;
			
			for(index = startIndex + 1; index < numUsed; index++)
			{
				if(intArray[index] < min)
				{
					min = intArray[index];
					indexOfMin = index;
				}
			}
			return indexOfMin;
		}
		
		public static void interchange(int i, int j, int[] intArray)
		{
			int temp;
			temp = intArray[i];
			intArray[i] = intArray[j];
			intArray[j] = temp; 
			
		}	
	//toString()
	
	//equals()
	
	
}
