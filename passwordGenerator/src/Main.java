import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void Generate() {

        char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '1', '2', '4', '5', '6', '7', '8', '9', '=', '.', '-', '_', '@', '%', '^' };

System.out.println("Enter password character length:");
Scanner charSize = new Scanner(System.in);
int passwordSize = charSize.nextInt();

System.out.println("Your random  password is:");
        for (int i = 0; i < passwordSize; i++) {
            Random random = new Random();
            int character = random.nextInt(input.length);
            char password = input[character];
            System.out.print(password);

        }
    }


        public static void main (String[]args){
            Generate();

        }
    }
