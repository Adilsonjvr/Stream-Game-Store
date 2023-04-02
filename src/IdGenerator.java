public class IdGenerator {
    private static long nextId = 1;
    
    public static long getNextId() {
        return nextId++;
    }
}
