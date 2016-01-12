
AP Computer Science A

Ch 8-9 Project
Cowway’s Game of Life

Directions: Construct a UML diagram for this scenario. Then, implement all the objects listed according to specifications given. All variables should be private. Write additional methods, including accessors, constructors, and mutators as needed in order to implement each method. 

World Object:
•	contains an array of all the farms in the world
•	int representing the current time in hours
•	method for incrementing the time by one hour


Farm (object):
•	contains a 2D array of FarmObject objects representing the coordinate grid of the farm (empty squares represented by a null object)
•	contains an array of FarmObject objects representing all the existing FarmObject objects


FarmObject (abstract): usable after inheritance not interface
•	contains ints for x and y coordinates on the farm
•	contains an abstract method doStuffForAnHour(int hour)
•	contains method for removing object from the farm
	
Cow extends FarmObject
Fields
•	String for name
•	int for level of hungriness
•	int for age
•	int sicknessLevel

Behavior:
•	From 6AM to 6PM, a cow traverses one square in a random direction each hour. 
•	If the chosen square is occupied by something that is not grass or the cow would go off the grid, do nothing for that hour.
•	At any other time, the cow is asleep, and does nothing.
•	If the cow attempts to move to a square filled with grass, the grass is removed, the cow’s hungriness decreases by the amount of grass, and the cow moves to the square.
•	Every hour, the cow's hungriness level increases by 2 and age by 1.	
•	If hungriness level reaches 100 or age reaches 90001, the cow dies and is removed from the farm.
•	Cow has a (0.0001*age*sicknessLevel)% chance of dying each hour. Dead cows are removed from the farm.


NocturnalCow extends Cow
•	Moves at night instead of at day (6PM to 6AM) and is asleep at any other time (does nothing)

FlyingCow extends Cow
•	Moves to a random square (not occupied by a cow) on the farm every hour

Grass extends FarmObject
•	int for amount of grass
•	Every hour, the amount of grass increases by 1.
•	Every hour, has a 0.1*(amount of grass)% chance of creating another patch of grass in a random adjacent square that is not occupied by a cow (up/down/left/right). 

PoisonedGrass extends Grass
•	The amount of poisoned grass increases by 2 every hour instead of 1.
•	If a cow eats poisoned grass, it becomes sick, with sickness level equal to the amount of poisoned grass eaten.


	Turn in a hardcopy report of your UML diagram (first page) followed by your Java code.  To get the most out of this project, write a tester class and see if you can get everything to compile and run.  It is not a requirement that your code compiles and works, but it would be great if you would volunteer to demonstrate your working code, and how you organized it, on the big screen.  You will be graded on organization, flow, and inheritance design of your classes and methods as they appear in your report.

	Work as an individual or as a group, whichever you prefer.  Everyone will turn his or her own report, however.

Due:  Monday, Jan 11, at beginning of class.

Category:  Homework, 20 points.

Demonstrate working code:  up to 10 bonus points.
