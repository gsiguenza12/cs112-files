package lab1;

public class FizzBuzz
{
    public static void main(String[] args)
    {
        System.out.println("Hello World\n");

        for(int i = 0; i < 100; i++)
        {
            if((i + 1) % 15 == 0)
            {
                System.out.println("FizzBuzz");
            }

            else if((i + 1) % 5 == 0)
            {
                System.out.println("Buzz");
            }

            else if((i + 1) % 3 == 0)
            {
                System.out.println("Fizz");
            }

            else {
                System.out.println(i + 1);
            }
        }

    }
}