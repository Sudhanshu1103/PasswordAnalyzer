import java.util.*;
public class PasswordAnalyzer 
{ 
    private static final int min_password_size = 8; 
    private static final int length_points = 3; 
    private static final int uppercase_points = 4;
    private static final int lowercase_points = 2;
    private static final int digit_points = 3;
    private static final int symbol_points = 6;
    private static final int repeat_penalty = 2;
    private static final int adjacent_penalty = 3;

    private static final String spec_char_list = "!@#%^&*()_+=-`~[]\\{}|;':\",./<>?"; 

    // to check whether character is in string
    private static boolean charInString(String s, char c)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == c)
            {
                return true;
            }
        }
        return false;
    }

    public static int checkPasswordQuality(String s)
    { 
        int score = 0; 
        int passwordlength = s.length();
        boolean hasupperchar = false;
        boolean haslowerchar = false;
        boolean hasdigitpresent = false;
        boolean hasspecialsymbol = false;

        // to score for length
        if (passwordlength >= min_password_size)
        {
            score += passwordlength * length_points;
        } 
        else 
        {
            score -= (min_password_size - passwordlength) * length_points; //if length is short
        }

        // to check every character and score 
        for (int i = 0; i < passwordlength; i++)
        {
            char currentChar = s.charAt(i);
            if (Character.isUpperCase(currentChar)) hasupperchar = true;
            else if (Character.isLowerCase(currentChar)) haslowerchar = true;
            else if (Character.isDigit(currentChar)) hasdigitpresent = true;
            else if (charInString(spec_char_list, currentChar)) hasspecialsymbol = true;

            // penalty for repeated characters
            for (int j = 0; j < i; j++)
            {
                if (s.charAt(i) == s.charAt(j)) 
                {
                    score -= repeat_penalty;
                    break;
                }
            }

            // penalty for adjacent repeated characters
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) 
            {
                score -= adjacent_penalty;
            }
        }

        // extra points
        if (hasupperchar) score += uppercase_points;
        if (haslowerchar) score += lowercase_points;
        if (hasdigitpresent) score += digit_points;
        if (hasspecialsymbol) score += symbol_points;
        return score;
    }

    public static String evaluateScore(int fs) 
    { 
        if (fs < 30)
        {
            return "password is very weak can be breached"; 
        } 
        else if (fs < 60)
        {
            return "password is not weak but still can be breached"; 
        }
        else 
        {
            return "Strong password"; 
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in); 
        System.out.print("Type in a password "); 
        String password = sc.nextLine(); 
        sc.close();

        int finalScore = checkPasswordQuality(password); 
        String assessmentResult = evaluateScore(finalScore); 
        System.out.println("Password you entered: " + password);
        System.out.println("Security Score: " + finalScore);
        System.out.println("Verdict: " + assessmentResult); 
    }
}