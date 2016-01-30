/**
 * @author Nicholas Hays & Ethan Rowell
 */
public class Burger {
	private int myPattyCount;
	private boolean myWorks;
	private String myPattyType;
	private MyStack<String> myOrder;
	private MyStack<String> myRecipe;
	private MyStack<String> myIngredients;
	private MyStack<String> myTempStack;

	/*
	 * constructor that initializes a Burger with only a bun and patty if
	 * theWorks is false and a Baron Burger if theWorks is true.
	 */
	public Burger(boolean theWorks) {
		myWorks = theWorks;
		myOrder = new MyStack<String>();
		myRecipe = new MyStack<String>();
		myIngredients = new MyStack<String>();
		myTempStack = new MyStack<String>();
		myPattyCount = 1;
		myPattyType = "Beef";
		myIngredients.push("Bun");
		myIngredients.push(myPattyType);
		myIngredients.push("Bun");
		if (theWorks) {
			addCategory("Sauce");
			addCategory("Cheese");
			addCategory("Veggies");
		}
		createRecipe();
		makeBurger();
	}

	private void createRecipe() {
		myRecipe.push("Pickles");
		myRecipe.push("Bun");
		myRecipe.push("Mayonnaise");
		myRecipe.push("Baron-Sauce");
		myRecipe.push("Lettuce");
		myRecipe.push("Tomato");
		myRecipe.push("Onions");
		if (myPattyCount > 1) {
			for (int i = 1; i < myPattyCount; i++) {
				myRecipe.push(myPattyType);
			}
		}
		myRecipe.push("Pepperjack");
		myRecipe.push("Mozzarella");
		myRecipe.push("Cheddar");
		myRecipe.push(myPattyType);
		myRecipe.push("Mushrooms");
		myRecipe.push("Mustard");
		myRecipe.push("Ketchup");
		myRecipe.push("Bun");
	}

	/*
	 * this method changes all patties in the Burger to the pattyType.
	 */
	public void changePatties(String pattyType) {
		if (pattyType == myPattyType) return;
		while (!myOrder.isEmpty()) {
			if (myOrder.peek().equals(myPattyType)) {
				myOrder.pop();
				myOrder.push(pattyType);
			} else {
				myTempStack.push(myOrder.pop());
			}
		}
		refillOrderStack();
		myPattyType = pattyType;
		updateRecipe();
	}

	private void refillOrderStack() {
		while (!myTempStack.isEmpty()) {
			myOrder.push(myTempStack.pop());
		}
	}

	private void updateRecipe() {
		while (!myRecipe.myIsEmpty) {
			myRecipe.pop();
		}
		createRecipe();
	}

	/*
	 * this method adds one patty to the Burger up to the maximum of 3.
	 */
	public void addPatty() {
		myPattyCount++;
		updateRecipe();
		addIngredient(myPattyType);
	}

	/*
	 * this method removes one patty from the Burger down to the minimum of 1.
	 */
	public void removePatty() {
		if (myPattyCount > 1) {
			myPattyCount--;
			updateRecipe();
			removeIngredient(myPattyType);
		} else {
			System.out.println("cannot proceed: patty count must be 1");
		}
	}

	/*
	 * this method adds all items of the type to the Burger in the proper
	 * locations.
	 */
	public void addCategory(String type) {
		if (type.equals("Sauce")) {
			myIngredients.push("Mayonnaise");
			myIngredients.push("Baron-Sauce");
			myIngredients.push("Mustard");
			myIngredients.push("Ketchup");
		} else if (type.equals("Cheese")) {
			myIngredients.push("Cheddar");
			myIngredients.push("Mozzarella");
			myIngredients.push("Pepperjack");
		} else if (type.equals("Veggies")) {
			myIngredients.push("Mushrooms");
			myIngredients.push("Onions");
			myIngredients.push("Tomato");
			myIngredients.push("Lettuce");
			myIngredients.push("Pickles");
		}
		swapIngredients();
		makeBurger();
	}

	private void swapIngredients() {
		while (!myOrder.myIsEmpty) {
			myIngredients.push(myOrder.pop());
		}
	}

	/*
	 * this method removes all items of the type from the Burger.
	 */
	public void removeCategory(String type) {
		if (type.equals("Sauce")) {
			removeIngredient("Mayonnaise");
			removeIngredient("Baron-Sauce");
			removeIngredient("Mustard");
			removeIngredient("Ketchup");
		} else if (type.equals("Cheese")) {
			removeIngredient("Cheddar");
			removeIngredient("Mozzarella");
			removeIngredient("Pepperjack");
		} else if (type.equals("Veggies")) {
			removeIngredient("Mushrooms");
			removeIngredient("Onions");
			removeIngredient("Tomato");
			removeIngredient("Lettuce");
			removeIngredient("Pickles");
		}
	}

	/*
	 * this method adds the ingredient type to the Burger in the proper
	 * location.
	 */
	public void addIngredient(String type) {
		myIngredients.push(type);
		swapIngredients();
		makeBurger();
	}

	/*
	 * this method removes the ingredient type from the Burger.
	 */
	public void removeIngredient(String type) {
		while (!myOrder.myIsEmpty) {
			if (type.equals(myOrder.peek())) {
				myOrder.pop();
				break;
			} else {
				myTempStack.push(myOrder.pop());
			}
		}
		refillOrderStack();
	}

	private void makeBurger() {
		while (!myRecipe.myIsEmpty) {
			if (hasIngredient(myRecipe.peek())) {
				myOrder.push(myRecipe.pop());
			} else {
				myRecipe.pop();
			}
		}
		createRecipe();
	}

	private boolean hasIngredient(String type) {
		boolean hasIngredient = false;
		while (!myIngredients.myIsEmpty) {
			if (type.equals(myIngredients.peek())) {
				myIngredients.pop();
				hasIngredient = true;
				break;
			}
			myTempStack.push(myIngredients.pop());
		}
		while (!myTempStack.isEmpty()) {
			myIngredients.push(myTempStack.pop());
		}
		return hasIngredient;
	}

	/*
	 * this method removes the ingredient type from the Burger.
	 */
	@Override
	public String toString() {
		StringBuilder orderString = new StringBuilder();
		orderString.append("[");
		while (!myOrder.myIsEmpty) {
			orderString.append(myOrder.pop());
			if (!myOrder.myIsEmpty) {
				orderString.append(", ");
			} else {
				orderString.append("]");
			}
		}
		return orderString.toString();
	}
}
