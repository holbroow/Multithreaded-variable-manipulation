public class Add extends Thread {
    public void run() {
        synchronized (InventoryMain.inventorySizeLock) { // synchronizes using a Lock
            InventoryMain.inventorySize++; // increment the inventory size
            System.out.printf("Added. Inventory size = %d\n", InventoryMain.inventorySize); // print the operation and current state of inventorySize
        }
    }
}