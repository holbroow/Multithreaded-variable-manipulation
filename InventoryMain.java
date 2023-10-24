public class InventoryMain {
    private static boolean endOfInstructions = false; // indicator to show that all instructions have occurred.

    public static int inventorySize = 0; // inventory size variable being accessed and altered by threads
    public static final Object inventorySizeLock = new Object(); // Lock to allow proper and robust synchronization between threads

    public static void main (String[] args) {

        int addOpAmount = Integer.parseInt(args[0]); // take values from the command line as parameters
        int removeOpAmount = Integer.parseInt(args[1]);


        while (endOfInstructions == false) { // while statement that allows for alternating thread initiation as opposed to two 'for loops'.
            if (addOpAmount != 0) {
                new Add().start();
                addOpAmount--;
            }
            if (removeOpAmount != 0) {
                new Remove().start();
                removeOpAmount--;
            }
            if (addOpAmount == 0 && removeOpAmount == 0) {
                System.out.printf("Final inventory size = %d", inventorySize);
                endOfInstructions = true;
            }
        }
    }
}