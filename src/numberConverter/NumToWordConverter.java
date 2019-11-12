package numberConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class NumToWordConverter {

	private static HashMap<Integer, String> hm = new HashMap();
	private static HashMap<Integer, String> hm1 = new HashMap();

	private static void createDictionary() {
		hm.put(0, "");
		hm.put(1, "One");
		hm.put(2, "Two");
		hm.put(3, "Three");
		hm.put(4, "Four");
		hm.put(5, "Five");
		hm.put(6, "Six");
		hm.put(7, "Seven");
		hm.put(8, "Eight");
		hm.put(9, "Nine");
		hm.put(10, "Ten");		
		hm.put(11, "Eleven");
		hm.put(12, "Twelve");
		hm.put(13, "Thirteen");
		hm.put(14, "Forteen");
		hm.put(15, "Fifteen");
		hm.put(16, "Sixteen");
		hm.put(17, "Seventeen");
		hm.put(18, "Eighteen");
		hm.put(19, "Nineteen");
		hm.put(20, "Twenty");
		hm.put(30, "Tthirty");
		hm.put(40, "Forty");
		hm.put(50, "Fifty");
		hm.put(60, "sixty");
		hm.put(70, "Seventy");
		hm.put(80, "Eighty");
		hm.put(90, "Ninety");
		
		
		
		hm1.put(0, "Zero");
		hm1.put(1, "");
		hm1.put(100, "Hundred");
		hm1.put(2, "Thousand");
		hm1.put(3, "Million");
		hm1.put(4, "Billion");
	}

	public static String convertToWord(String num) {
		String tempString = "";
		if (num == null) {
			return tempString;
		}
		if (num.length() > 12) {
			return tempString;
		}
		if (!num.contains(",") && Double.valueOf(num) == 0) {
			tempString = tempString + hm1.get(Integer.valueOf(num));
			return tempString;
		}

		ArrayList<String> number = new ArrayList<>();

		if (num.contains(","))
			for (String str : (num.split(","))) {
				number.add(str);
			}
		else {
			if (num.length() % 3 > 0) {
				number.add(num.substring(0, num.length() % 3));
			}
			num = num.substring(num.length() % 3);

			for (int i = 0; i < num.length() - 1; i++) {

				number.add(num.substring(i, i + 3));
				i = i + 2;

			}

		}
		
		int length = number.size();

		for (String str : number) {

			int i = Integer.valueOf(str);

			if (i > 99) {

				tempString = tempString + hm.get(i / 100) + " " + hm1.get(100) + " and";
				if (i % 10 == 0 || i % 100 <= 20)
					tempString = tempString + " " + hm.get((i % 100)) + " " + hm1.get(length) + " ";
				else {
					tempString = tempString + " " + hm.get(((i % 100) / 10) * 10) + " " + hm.get((i % 10)) + " "
							+ hm1.get(length) + " ";
				}

				length = length - 1;

			} else {
				if (i % 10 == 0 || i % 100 <= 20)
					tempString = tempString + " " + hm.get((i % 100)) + " " + hm1.get(length) + " ";
				else {
					tempString = tempString + " " + hm.get(((i % 100) / 10) * 10) + " " + hm.get((i % 10)) + " "
							+ hm1.get(length) + " ";
				}
				length = length - 1;
			}		

		}

		return tempString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createDictionary();

		System.out.println(convertToWord("56945780"));

		System.out.println(convertToWord("569457811111"));

		System.out.println(convertToWord("0000"));

		System.out.println(convertToWord("56,945,781"));
	}

}
