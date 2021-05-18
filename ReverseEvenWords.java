package week2.day2.Assignments;

public class ReverseEvenWords {
    public static void main(String[] args) {
        String test = "I am a software tester";
        String finalResult = reverseEvenWords(test);
        System.out.println(finalResult.substring(1));
    }
    public static String reverseEvenWords(String test) {
        String[] splitString = test.split(" ");
        String result = "";
        for (int i = 0; i < splitString.length; i++) {
            if (i % 2 == 1) {
                splitString[i] = reverse(splitString[i]);
            }
            result = result + " "+ splitString[i];
        }
        return result;
    }
    public static String reverse(String test) {
        String reverseWord = "";
        for (int i = test.length() - 1; i >= 0; i--) {
            reverseWord = reverseWord + test.charAt(i);
        }
        return reverseWord;
    }
}
