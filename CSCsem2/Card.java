package CSCsem2;

import java.util.Random;
import java.util.Scanner;

public class Card {

	static Random rando = new Random();
	static Scanner scnr = new Scanner(System.in);
	
	static void cut(int num, String[] array) {
		String hold1;
		String hold2;
		
		for(int i = 0; i<=num;i++) {
			if (i == 0)
			{
				hold1 = array[(array.length-1)];
				array[(array.length-1)]=array[i];
				for(int j = 0; j<array.length;j++) {
					hold2=array[(array.length-2)];
					array[(array.length-2)] = hold1;
					hold1 = hold2;
				}
			}
			else {
				hold1 = array[(array.length-i)];
				array[(array.length-i)]=array[i];
				for(int j = 0; j<array.length;j++) {
					hold2=array[(array.length-j-1)];
					array[(array.length-j-1)] = hold1;
					hold1 = hold2;
				}
			}
		}
	}
	
	static String deal(String[] array) {
		int e = rando.nextInt(array.length);
		return array[e];
	}
	
	static void newOrder(String[] array) {
		int count = 0;
		int[] FaceValue = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		Faces[] Suit = {Faces.Hearts,Faces.Clubs,Faces.Diamonds,Faces.Spades};
	
		for(int i = 0; i<Suit.length; i++) {
			for(int e = 0; e<FaceValue.length;e++) {
				if(FaceValue[e]==1) {
					array[count]=("Ace of " + Suit[i]);
				}
				else if(FaceValue[e]==11){
					array[count]=("Jack of " + Suit[i]);
				}
				else if(FaceValue[e]==12){
					array[count]=("Queen of " + Suit[i]);
				}
				else if(FaceValue[e]==13){
					array[count]=("King of " + Suit[i]);
				}
				else{
					array[count]=(FaceValue[e]+" of " + Suit[i]);
				}
				count++;
			}
		}
	}
	
	static int search(String card, String[] array) {
		int e = 0;
		for(int i = 0;i<array.length;i++) {
			if(card.equals(array[i])){
				e = i;
			}
		}
		return e;
	}
	
	static void shuffle(String[] array){
		for(int i = 0;i<array.length;i++) {
			int e = 0;
			if(e<i) {
				e = rando.nextInt(array.length);
			}
			String store = array[i];
			array[i]=array[e]; 
			array[e]=store;
		}
	}
	
	static int size(String[] array) {
		return array.length;
	}
	
	static String turnOver(String[] array) {
		return array[0];
	}
	
	public static void main(String[] args) {
		
		String[] deck1 = {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
		newOrder(deck1);
		String input = "";
		String Read = "";
		Boolean repeat = true;
		int inputNmbr;
		int cardsDrawn = 0;
		
		System.out.println("Thank you for starting up this program! The commands are:"
				+ "\n draw \n deal \n cut(input number) \n shuffle \n size \n turnOver");
		
		while(repeat == true){
			while(input.equals("")) {
				input = scnr.nextLine();
			}
			switch(input) {
			case "cut":
				cardsDrawn = 0;
				inputNmbr = scnr.nextInt();
				cut(inputNmbr,deck1);
				break;
			case "deal":
				cardsDrawn = 0;
				System.out.println(deal(deck1));
				break;
			case "newOrder":
				cardsDrawn = 0;
				newOrder(deck1);
				break;
			case "search":
				System.out.println(search("10 of Hearts",deck1));
				break;
			case "shuffle":
				shuffle(deck1);
				cardsDrawn = 0;
				break;
			case "size":
				System.out.println(size(deck1)-cardsDrawn);
				break;
			case "turnOver":
				System.out.println(turnOver(deck1));
				break;
			case "draw":
				System.out.println(deck1[cardsDrawn]);
				cardsDrawn++;
				break;
			default:
					input = scnr.nextLine();
				break;
			}
			System.out.println("Keep Going? (y/n)");
			Read = scnr.next();
			if (Read.equals("n"))
				repeat = false;
			if (Read.equals("y"))
				input=("");
		}
		//System.out.println(input);
		//deck created
		/*System.out.println(deck1[1]);
		shuffle(deck1);
		System.out.println(deck1[1]);
		newOrder(deck1);
		System.out.println(deck1[1]);
		System.out.println(deal(deck1));
		System.out.println(search("10 of Hearts",deck1));
		System.out.println(size(deck1));
		System.out.println(turnOver(deck1));
		cut(16,deck1);
		System.out.println(deck1[1]); */
	}
}
