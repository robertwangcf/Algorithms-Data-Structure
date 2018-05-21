package String;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Robert on 5/16/2018.
 */
class ThrowExcep
{
    static int fun()
    {
        try
        {
            throw new NullPointerException("demo");
        }
        catch(NullPointerException e)
        {
            System.out.println("Caught inside fun().");
             // rethrowing the exception

        }
        finally {
            return 1;
        }
    }

    public static void main(String args[])
    {
        try
        {
            System.out.println(fun());
        }
        catch(NullPointerException e)
        {
            System.out.println("Caught in main.");
        }
    }
}

class Quora	{

    // The default constructor
    public Quora()	{

    }

    public int write() {
        System.out.print("1");
        return 1;
    }

}

class QuoraKid extends Quora	{

    // The default constructor
    public QuoraKid()	{

    }

    public int write() {
        System.out.print("I am son");
        return 2;
    }

}

class QuoraTest	{
    public static void main(String[] args)	{
        Quora quora1 = new Quora();

        // Notice here that quora2 variable might of the type Quora, but
        // actually contains an instance of QuoraKid, a subclass of Quora.
        Quora quora2 = new QuoraKid();

        System.out.println(quora2.write());
        System.out.println(quora1 instanceof QuoraKid);
        System.out.println(quora2 instanceof Quora);
    }
}
public class CompressString {
    public static void main(String args[]) {
        byte[] b = {'h', 'e', 'l', 'l', 'o'};

        try {

            // create a new output stream
            OutputStream os = new FileOutputStream("test.txt");

            // craete a new input stream
            InputStream is = new FileInputStream("test.txt");

            // write something
            os.write(b);

            // read what we wrote
            for (int i = 0; i < b.length; i++) {
                System.out.print("" + (char) is.read());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    public static int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = slow;
        int curCount = 1;
        boolean checkedLastDigit = false;
        while (fast <= chars.length - 1 - 1) {
            if (chars[fast] != chars[fast + 1]) {
                slow = updateCountAndMoveSlowpointer(chars, slow, curCount) + 1;
                curCount = 1;
            } else {
                if (fast == chars.length - 2) {
                    checkedLastDigit = true;
                }
                curCount++;
            }
            fast++;
        }
        //finally do a check based on checkedLastDigit flag.
        if (checkedLastDigit == false) {
            return slow++;
        } else {
            return updateCountAndMoveSlowpointer(chars, slow, curCount);
        }
    }

    private static int updateCountAndMoveSlowpointer(char[] chars, int slow, int curCount) {
        char[] countArray = Integer.valueOf(curCount).toString().toCharArray();
        for (char num : countArray) {
            chars[++slow] = num;
        }
        return slow;
    }
}
