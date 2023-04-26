package Kopo40;
// Main
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		int repeat;
		Hello aa = new Hello();
		do {
			aa.input();
			aa.calc();
			aa.saveData();
			System.out.print("계속 하시겠습니까? (0:YES, 1:NO) : ");
			repeat = myInput.nextInt();
		} while (repeat == 0);
		aa.output();
	}
}