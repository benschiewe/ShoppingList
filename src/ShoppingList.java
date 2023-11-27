import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        // Pre-created ArrayList for pantry fruit items
        ArrayList<String> pantry = new ArrayList<>();
        pantry.add("Apples");
        pantry.add("Bananas");
        pantry.add("Oranges");
        pantry.add("Grapes");
        pantry.add("Mangoes");                                  //Create and fill list of pantry items

        ArrayList<String> groceryList = getGroceryListInput();  //Populate groceryList with user input

        boolean isShoppingNeeded = false;

        for (String item : groceryList) {
            if (!pantry.contains(item)) {       //If the pantry is missing an element from groceryList...
                if (!isShoppingNeeded) {        //Print only if this is the first missing item
                    System.out.println("You need to go shopping for..."); //To make the output look nice
                }
                System.out.println(item);       //Print the missing item
                isShoppingNeeded = true;        //Now we need to go shopping
            }
        }
        if (!isShoppingNeeded) {        //If the pantry contains every element in groceryList...
            System.out.println("No shopping needed!");
        }
    }

    // Get user input, return ArrayList containing items needed for recipe
    private static ArrayList<String> getGroceryListInput() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> groceryList = new ArrayList<>();

        System.out.println("Enter your list of items (type 'done' when finished):");

        String currItem;
        do {
            System.out.print("Item: ");
            currItem = scanner.nextLine().trim();                   //Trim whitespace from user input

            if (!currItem.equalsIgnoreCase("done")) {   //If input != "done"
                groceryList.add(currItem);                          //Add currItem to groceryList
            }

        } while (!currItem.equalsIgnoreCase("done"));   //Loop until user enters "done"

        scanner.close();                                            //Close scanner
        return groceryList;                                         //Return groceryList to main()
    }
}
