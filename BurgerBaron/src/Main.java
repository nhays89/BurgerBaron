import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nicholas Hays & Ethan Rowell
 */
public class Main {
	private static int orderCount;

	public Main() {
		// does nothing
	}

	public static void main(String[] args) throws IOException {

		if (args.length > 0) {
			System.out.println("Args");
			// used for parsing command line args
			for(String arg : args) {
				parseLine(arg);
			}
		} else {
			System.out.println("File");
			// used for designating input file
			BufferedReader reader = new BufferedReader(new FileReader("customer.txt"));
			while (reader.ready()) {
				String order = reader.readLine();
				parseLine(order);
				orderCount++;
			}
			reader.close();
		}

		// test below:
		// customerOrder.testMyStack();
		// customerOrder.testBurger();
	}

	/**
	 * parse input string from customer order.
	 * 
	 * @throws IOException
	 */
	public static void parseLine(String line) throws IOException {
		if (line.equals(""))
			return;
		int numOfPatties = 1;
		String pattyType = "Beef";
		boolean theWorks = false;
		Burger burger = null;
		String[] words = line.split(" ");
		for (String word : words) {
			if (word.equals("Baron")) {
				theWorks = true;
			}
			if (word.equals("Veggie") || word.equals("Chicken")) {
				pattyType = word;
			}
			if (word.equals("Double")) {
				numOfPatties = 2;
			}
			if (word.equals("Triple")) {
				numOfPatties = 3;
			}
		}
		burger = new Burger(theWorks);
		for (int i = 1; i < numOfPatties; i++) {
			burger.addPatty();
		}
		burger.changePatties(pattyType);
		outer: for (int i = 0; i < words.length; i++) {
			if (words[i].equals("with")) {
				if (words[i + 1].equals("no")) {
					for (int j = i + 2; j < words.length; j++) {
						if (words[j].equals("but")) {
							for (int k = j + 1; k < words.length; k++) {
								burger.addIngredient(words[k].toString());
							}
							break outer;
						}
						burger.removeCategory(words[j]);
						burger.removeIngredient(words[j]);
					}
				} else {
					for (int j = i + 1; j < words.length; j++) {
						if (words[j].equals("but")) {
							for (int k = j + 2; k < words.length; k++) {
								burger.removeIngredient(words[k].toString());
							}
							break outer;
						}
						if (words[j].equals("Sauce") || words[j].equals("Cheese") || words[j].equals("Veggies")) {
							burger.addCategory(words[j]);
						} else {
							burger.addIngredient(words[j].toString());
						}
					}
				}
			}
		}
		System.out.println("Processing Order " + orderCount + ": " + line);
		System.out.println(burger.toString());
		System.out.println();
	}

	/*
	 * â€� test method for MyStack.
	 */
	public void testMyStack() {
		// test burger with different data type
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(10);
		stack.push(9);
		stack.push(8);
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
		stack.pop(); // throw EmptyStackException
		// ..
	}

	/*
	 * test method for the burger class
	 */
	public void testBurger() {
		System.out.println("Baron Burger Test:");
		System.out.println("Processing Order test: Baron Burger with no Sauce Pickles but Baron-Sauce");
		Burger bTest1 = new Burger(true);
		bTest1.removeCategory("Sauce");
		bTest1.removeIngredient("Pickles");
		bTest1.addIngredient("Baron-Sauce");
		System.out.println(bTest1.toString());
		System.out.println();
		System.out.println("Non-Baron Burger Test:");
		System.out.println(
				"Processing Order test: Triple Chicken Burger with Sauce Cheese Veggies but no Lettuce Mozarella Mayonnaise");
		Burger bTest2 = new Burger(false);
		bTest2.addPatty();
		bTest2.addPatty();
		bTest2.changePatties("Chicken");
		bTest2.addCategory("Sauce");
		bTest2.addCategory("Cheese");
		bTest2.addCategory("Veggies");
		bTest2.removeIngredient("Lettuce");
		bTest2.removeIngredient("Mozarella");
		System.out.println(bTest2.toString());
		// ...
	}

}
