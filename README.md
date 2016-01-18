# BurgerBaron
Assignment  The Burger Baron will make custom burgers including any of the toppings on his famous Baron  Burger.  The Baron Burger is made on the special Baron Bun and has on it  
● Patties ­ Beef, Chicken, or Veggie  
● Cheese ­ Cheddar, Mozzarella, and Pepperjack  
● Veggies ­ Lettuce, Tomato, Onions, Pickle, and Mushrooms  
● Sauces ­ Ketchup, Mustard, Mayonnaise, and Baron­Sauce    
The Burger Baron’s official recipe constructs the Baron Burger in this order (top to bottom):  
● Pickle ­ Skewered to the burger with the Baron’s Blade.  
● Top Bun  
● Mayonnaise  
● Baron Sauce 
● Lettuce  
● Tomato  ● Onions  ● Pepperjack  ● Mozzarella  ● Cheddar  ● Patty ­ If there is more than one patty then the cheese goes on the bottom patty.  ● Mushrooms  ● Mustard  ● Ketchup  ● Bottom Bun      The Burger Baron has customers that will order in different ways and he wants his menus to  automatically construct the burger ingredients in the proper order so he can display it to his 
gourmet burger chef’s.  Here are some sample orders:  ● Single Veggie Baron Burger.  ● Double Baron Burger with no Cheese but Mozzarella.  ● Single Burger with Veggies but no Lettuce.  ● Double Chicken Burger with Ketchup Cheddar Onions and Mushrooms.    That is, most customers use one of two styles to order.  ● <Patty Count> <Patty Type> Baron Burger with no <omissions> but <exceptions>  ● <Patty Count> <Patty Type> Burger with <additions> but no <exceptions>    The <omissions> and <additions> may include ingredients or categories of ingredients:  ● Categories ­ Cheese, Sauce, Veggies  ● Ingredients ­ Cheddar, Mozzarella, Pepperjack, Lettuce, Tomato, Onions, Pickle,  Mushrooms, Ketchup, Mustard, Mayonnaise, and Baron­Sauce    The <exceptions> are always ingredients only and are exceptions to the categories listed in the  <omissions> or <additions>.    Each of the components can be omitted when ordering with the following defaults.  ● <Patty Count> defaults to Single.  ● <Patty Type> defaults to Beef  ● <omissions>, <additions>, <exceptions> default to empty.    The Burger Baron takes orders one at a time and gives them a number 0 to 99.  The input to  your program will be a file with one line per burger.   ● Your program should assign each order a number starting with 0.   ● Each line will be a string in the format above.   ● Your output (to System.out) will be the ingredients of the ordered burger listed from top  to bottom.  
