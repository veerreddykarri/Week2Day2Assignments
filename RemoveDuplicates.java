package week2.day2.Assignments;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String text = "We learn java basics as part of java sessions in java week1";
        String[] splitText = text.split(" ");
        int count = 0;
        for (int i = 0; i < splitText.length; i++) {
            for (int j = i + 1; j < splitText.length; j++) {
                if (splitText[i].equals(splitText[j])) {
                    count++;
                }
            }
            if (count > 1) {
                text = text.replace(splitText[i], "");
            }
            count=0;
        }
        System.out.println(text.replace("  "," "));
    }
}
