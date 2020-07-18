public class Tracker {
    private static int nextPhID = 0;

    public static int getNextLID() {
        return nextLID;
    }

    public static void setNextPhID() {
        Tracker.nextPhID++;
    }

    private static int nextLID = 0;

    public static int getNextPhID() {
        return nextPhID;
    }

    public static void setNextLID() {
        Tracker.nextLID++;
    }

    private static int nextTestID = 0;

    public static int getNextTestID() {
        return nextTestID;
    }

    public static void setNextTestID() {
        Tracker.nextTestID++;
    }

}
