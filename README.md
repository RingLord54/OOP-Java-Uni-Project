# OOP-Java-Uni-Project

## About
This Object Oriented Programming Project uses Java to create a basic functioning Retail Warehouse Management System, where products can be added and removed and statistics can be viewed as well. This project was completed as part of an OOP module done during the first year of my Computer Science course at University. Although in the "part01" source folder there is a command-line based version of this system. I will be detailing the more User-Friendly version found in the "part03" source folder!

## Getting Started
In order to start using the Retail Management System Application, run the `WarehouseApplication` Java file found within the "Part03" source folder. This will open up a larger, more Graphical, command line interface which can be used to perform operations.

As soon as the new window opens up you will be presented with 8 different menu options, which in order are:
1. Add new Product
2. Delete a Product
3. List all Products for a Department
4. List all Products
5. Add Stock for a Product
6. Sales Report
7. Record Purchase
8. Exit

You are then also prompted to enter which process you wish to carry out by entering the process' assigned number. So, for example, if you wish to add a new Product to the Warehouse catalog then you would enter "1". I will now briefly go over each of the 7 main processes. 8 will be excluded because when 8 is entered into the menu selection prompt, as expected the application ends and you then have to manually close the window of the command line interface.

## Adding a New Product
When you select "1" to add a new Product to the Warehouse catalog you are prompted to enter the details of the Product. These details include:
- Manufacturer
- Model
- Price (in £s)
- The Department the Product belongs to
- The Quantity of the Product
- The Product Description
- The Product Image Pathway

Just as some extra notes, when entering the Department value, if it does not match any of the predfined Departments "Other" will be assigned to the Product. Furthermore, if the Image Pathway is incorrect then no image will show for the Product when you try to list all of the Products (only way to fix the Image Pathway is to delete the Product and then re-add)

## Deleting a Product
When you select "2" to delete a Product, a list of all the current Products in the Warehouse Catalog are displayed. You are then prompted to select which Product you wish to delete. However, if you don't want to delete a Product then you can exit by entering "0" on this menu.

If you do decide to delete a Product, in order to prevent the event of the wrong Product being deleted, you are then prompted to either enter "Yes" to successfully delete the Product or "No" in order to keep the Product and go back to the main menu.

## Listing all of the Products in a specific Department
When you select "3" to List all of the Products in a specific Department, you are prompted to enter which Department's Products you wish to view. When you enter your answer, all of the Products that have that specific Department value will be displayed along with all of their information. However, if the Department value doesn't match any of the predefined Department values then all of the Products categorised as "Other" will be displayed.

## Listing all of the Products
When you select "4" a simple function will run in order to print all of the current Products in the Warehouse's catalog. The shown Products will also be categorised by Department.

## Adding more Stock to a Product
When you select "5" to add more Stock to a Product, the structure is very similar to when you want to delete a Product. This is because a list of all of the current Products will be displayed and you're then prompted to enter which Product you want to add more Stock to. However, if you do not wish to add more Stock to any of the Products then you can enter "0" to exit the menu and go back to the main menu instead.

Although, if you do decide to add more Stock to a product, you're then prompted to enter how much Stock you wish to add to the selected Product. If a negative value is entered then you will be prompted again to enter a value.

## Viewing the Sales Report
When you select "6" a simple function will run in order to print all of the current Products in the Warehouse's catalog, but in order of most purchases to least. The information displayed for each Product is there:
- Manufacturer
- Model
- Purchases
- Price
- Total Profit

## Record a Purchase
When you select "7" to record the purchase of a Product, the structure is very similar to when you want to delete a Product. This is because a list of all of the current Products will be displayed and you're then prompted to enter which Product you want to record a purchase for. However, if you do not wish to record a purchase for any of the Products then you can enter "0" to exit the menu and go back to the main menu instead.

Although, if you do decide to record a purchase for a product, then similarly to adding stock to a Product, you're then prompted to enter how many purchases of that Product were made. You can only enter a value that's larger than or equal to the current Stock level of the Product you're recording purchases for though.
