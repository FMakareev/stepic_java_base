public class LeapYearCount {
    public static int leapYearCount(int year) {
        return (year - (year % 4)) / 4 - ((year - (year % 100)) / 100 - (year - (year % 400)) / 400);
    }
}
