package bus;

import java.util.*;

/**
 * Даден е списък с времената на пристигане и заминаване на всички автобуси от
 * дадена автогара. Да се напише програма, която използвайки TreeSet и HashSet
 * класовете по даден интервал (начало, край) намира броя автобуси, които
 * успяват да пристигнат и да напуснат автогарата. Пример: Имаме данните за
 * следните автобуси: [08:24-08:33], [08:20-09:00], [08:32-08:37],
 * [09:00-09:15]. Даден е интервалът [08:22-09:05]. Броят автобуси, които идват
 * и си тръгват в рамките на този интервал е 2.
 * 
 * @author a
 *
 */
public class BusStation {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		//
		int countBus = 0;
		System.out.println("Please define time period for the query:");
		System.out.println("Earliest hour of arrival: ");
		int earlyH = input.nextInt();
		System.out.println("Earlest minutes of arrival: ");
		int earlyM = input.nextInt();
		System.out.println("Latest hour of departure: ");
		int lastH = input.nextInt();
		System.out.println("Latest minutes of departure: ");
		int lastM = input.nextInt();

		int earlyT = (earlyH * 100) + earlyM;
		int lastT = (lastH * 100) + lastM;
		try {

			while (!input.nextLine().equals("end")) {

				System.out.println(
						"Please insert time data for a bus or press any letter key if you wish to see the results of the query.");
				System.out.println("Hour of arrival: ");
				int hourAr = input.nextInt();
				System.out.print("  Minutes of arrival: ");
				int minutesAr = input.nextInt();
				System.out.println("Hour of departure: ");
				int hourDep = input.nextInt();
				System.out.println("Minutes of departure: ");
				int minutesDep = input.nextInt();
				System.out.println("The data was entered in the information system successfuly!");
				System.out.println();

				int timeAr = (hourAr * 100) + minutesAr;
				int timeDep = (hourDep * 100) + minutesDep;
				if ((timeAr >= earlyT && timeAr <= timeDep) && (timeDep >= timeAr && timeDep <= lastT)) {
					countBus++;
				}
			}
		} catch (InputMismatchException ime) {

		} finally {
			input.close();
			System.out.println();
			System.out.println();
			if (countBus == 1) {
				System.out.printf("%d bus will arrive and departure between 08:22 and 09:05", countBus);
			} else {
				System.out.printf("%d buses will arrive and departure between 08:22 and 09:05", countBus);
			}
		}

	}

}
