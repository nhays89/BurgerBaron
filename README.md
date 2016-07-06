#BurgerBaron

Program built in java that incorporates doubly linked lists to faciliatate a burger ordering service; in particular, a 'baron' burger.The baron burger has a specific list of ingredients that make it unique. The baron burger recipe is as follows (top to bottom): 

### Recipe
---
* Pickle ‐ Skewered to the burger with the Baron’s Blade. 
* Top Bun 
* Mayonnaise
* Baron Sauce 
* Lettuce
* Tomato 
* Onions
* Pepperjack 
* Mozzarella 
* Cheddar 
* Patty ‐ If there is more than one patty then the cheese goes on the bottom patty.
* Mushrooms 
* Mustard 
* Ketchup 
* Bottom Bun. 

The Burger Baron has customers that will order in different ways, and the owner wants his menus to automatically construct the burger ingredients in the proper order so he can display it to his gourmet burger chef’s.  

Here are some sample orders: 
* "Single Veggie Baron Burger"
* "Double Baron Burger with no Cheese but Mozzarella"
* "Single Burger with Veggies but no Lettuce"
* "Double Chicken Burger with Ketchup Cheddar Onions" 

As you can see, the customer has a limited selection of ingredients, but they can add and remove ingredients from the burger as they so desire but can only do so in a specific order. There are two styles in which a burger can be interpreted:

###Order Format
---
1. "'Patty Count' 'Patty Type' Baron Burger with no 'omissions' but 'exceptions'"
2.  "'Patty Count' 'Patty Type' Burger with 'additions' but no 'exceptions'".

The 'omissions' and 'additions' may include ingredients or categories of ingredients:

Categories ‐ "Cheese", "Sauce", "Veggies"; 
Ingredients ‐ "Cheddar", "Mozzarella", "Pepperjack", "Lettuce", "Tomato", "Onions", "Pickle", "Mushrooms", "Ketchup", "Mustard", "Mayonnaise", and "Baron-Sauce".


The 'exceptions' are always ingredients only and are exceptions to the categories listed in the 'omissions' or 'addition'.
The program can take text orders in the format described and construct a baron or non-baron burger with all ingredients listed. 
