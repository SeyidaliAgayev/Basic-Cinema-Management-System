package util;
import static util.InputUtil.*;
public class MenuUtil {
    public static byte firstEntryMenu() {
        System.out.println("""
                           [1].Cinema
                           [2].Customer
                           """
        );
        return byteInput("Choose an option: ");
    }

    public static byte cinemaEntryMenu() {
        System.out.println("""
                           [0].Finish Program!
                           [1].Add Film
                           [2].Update Film
                           [3].Delete Film
                           [4].Show Film
                           [5].Search Film
                           """
        );
        return byteInput("Choose an option: ");
    }
    public static byte customerEntryMenu() {
        System.out.println("""
                           [0].Finish Program!
                           [1].Sign Up
                           [2].Log In
                           [3].Update 
                           [4].Delete
                           [5].Search
                           [6].Show
                           """
        );
        return byteInput("Choose an option: ");
    }
    public static byte filmVisionStatusMenu() {
        System.out.println("""
                           [1].In Vision!
                           [2].Not in Vision!
                           """
        );
        return  byteInput("Choose an option: ");
    }
    public static byte customerEntrySearch() {
        System.out.println(
                """
                [1].Name
                [2].Surname
                [3].Username
                """);
        return byteInput("Choose an option to search: ");
    }
}
