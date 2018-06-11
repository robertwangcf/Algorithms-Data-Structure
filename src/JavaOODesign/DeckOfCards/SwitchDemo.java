package JavaOODesign.DeckOfCards;

/**
 * Created by Robert on 5/26/2018.
 */
public class SwitchDemo {
    private static int add(int i) {
        return i + 1;
    }
    public static void main(String[] args) {

        int month = 8;
        String monthString;
        switch (month) {
            case 1:
                int i = 0;
                if (i > 1) {
                    System.out.print(i);
                }
                add(1);
                monthString = "January";
                break;
            case 2:  monthString = "February";
                break;
            case 3:  monthString = "March";
                break;
            case 4:  monthString = "April";
                break;
            case 5:  monthString = "May";
                break;
            case 6:  monthString = "June";
                break;
            case 7:  monthString = "July";
                break;
            case 8:  monthString = "August";
                break;
            case 9:  monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: monthString = "Invalid month";
                break;
        }
        System.out.println(monthString);
    }
}
