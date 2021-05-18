package week2.day2.Assignments;

public class ReverseString {
    public static void main(String[] args) {
        String test = "feeling good";
        String reverseString = "";
        for (int i = test.length() - 1; i >= 0; i--) {
            reverseString = reverseString + test.charAt(i);
        }
        System.out.println(reverseString);
    }
}
