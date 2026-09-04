public class InventoryBalancer {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        int maxVal = sectionA[0];
        String maxLoc = "Section A, Item 1";

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxVal) { maxVal = sectionA[i]; maxLoc = "Section A, Item " + (i+1); }
        }
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxVal) { maxVal = sectionB[i]; maxLoc = "Section B, Item " + (i+1); }
        }
        String status = (totalA == totalB)? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB +
        " | Status: " + status + " | Highest Quantity: " + maxVal + " (" + maxLoc + ")");
    }
    public static void main(String[] args) {
        int[] a = {20,15,30};
        int[] b = {25,10,30};
        analyzeInventory(a,b);
    }
}