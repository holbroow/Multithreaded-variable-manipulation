public class Remove extends Thread {
    public void run() {
        synchronized (InventoryMain.inventorySizeLock) { // synchronizes using a Lock
            InventoryMain.inventorySize--; // decrement the inventory size
            System.out.printf("Removed. Inventory size = %d\n", InventoryMain.inventorySize); // print the operation and current state of inventorySize
        }
    }
}