import java.util.Random;
import java.util.Scanner;

import blackjack2.Card;

public class game {

	public static void main(String[] args) {
		int total = 0;
		boolean draw = false;
		boolean play = true;
		int nextCardVal = 0;
		Random nextCardID = new Random();
		Scanner input = new Scanner(System.in);
		
		while (play == true) {
			Card card = new Card();
			total = 0;
			
			for (int i = 0; i < 3; i++) {
				nextCardVal = nextCardID.nextInt(13) + 1;
				card.printCard(nextCardVal);
				total += nextCardVal;
			}
			System.out.println(total);
			
			if (total < 21) {
				System.out.print("Draw? (Y/N)");
				String ans = input.nextLine();
				
				if (ans.equals("Y") || ans.equals("y")) {
					draw = true;
				}
				else {
					draw = false;
				}
				
				while (total < 21 && draw == true) {
					nextCardVal = nextCardID.nextInt(13) + 1;
					card.printCard(nextCardVal);
					total += nextCardVal;
					System.out.println(total);
					
					if (total < 21) {
						System.out.print("Draw? (Y/N)");
					}
					else {
						draw = false;
						break;
					}
					
					if (ans.equals("Y") || ans.equals("y")) {
						draw = true;
					}
					else {
						draw = false;
					}
				}
				if (total > 21 || total < 21) {
					System.out.println("You lose.");
				}
				else {
					System.out.println("You win!");
				}
			}
			else if (total == 21) {
				System.out.println("You win!");
			}
			else {
				System.out.println("You lose.");
			}
			System.out.print("Play again? (Y/N)");
			String ansr = input.nextLine();
			
			if (ansr.equals("Y") || ansr.equals("y")) {
				play = true;
			}
			else {
				play = false;
			}
			System.out.println("Thanks for playing!");
		}

	}

}
