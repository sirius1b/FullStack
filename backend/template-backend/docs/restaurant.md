
requirements:

A restaurant has a name, an address, cuisines served, menu, waiters, chefs.
Cuisines can be Italian, French, Chinese, Japanese, Indian, Continental etc.
A menu contains a list of dishes divided into multiple sections like Soups, Appetizers etc.
A dish has a name, description, type (veg / non-veg / vegan), price, a recipe for the chefs to follow.
A dish also has a list of ingredients and its amount required to cook the dish.
Ingredients can be measured either in grams for solids or ml (mililitres) for liquids/semiliquids.
A waiter has a name, email, phone number and level (Junior, Senior, Manager).
A chef has a name, email, phone number and level (Commis Chef, Sous chef, Head Chef, Executive chef).
We need to track orders made by customers during their visit so that we can generate a bill at the end. Note: customer during a visit will order multiple times and each time an order can contain multiple dishes in it.

steps:
    requirement gathering 
    class model design ; 
        fields [x]
        references/ cardinality [x] 
        methods [ ]
    schema design [x]


class diagram -- 

    restaurant
        name,  d
        address , d
        menu d
        list[employee]
        serves list[cuisine] d

        getMenu() -> menu
        getCuisines() -> list[cuisine]


    cuisine d
        Italian 
        french
        chinese
        japanese
        indian
        continental

    menu 
        list[menu_section]

    menu_section
        list[dishes]

    dish
        name string
        description string
        dish_type DishType
        price double
        recipe Recipe

    recipe 
        procedure string
        ingrediants Map[ingrediant, double(quantity)] 
        
    Unit
        gram
        millilitres

    ingrediant
        name
        ingrediant_type
        getUnit()

    ingrediant_type
        solid
        liquid
        semiliquid

    employee 
        name
        email
        phone-number

    waiter --inherits--> employee
        waiter_level 

    waiter_level
        junior 
        senior
        manager

    chef --inherits--> employee
        chef_level

    chef_level
        commis
        sous
        head
        executive

    DishType
        VEG, 
        NON_VEG
        VEGAN

    table
        table_no

    Customer
        name
        order(restaurant, dishes) 

    Order
        customer
        table
        Map <Dishes, Integer>
        orderStatus

    OrderStatus
        Pending
        Delivered
        Paid
    
    Bill
        list[orders]
        customer    
        billAmount


schema diagram -- 

    restaurant(restaurant_id, name, address, menu_id )
        pk: restuarant_id,
        fk: menu_id -> menu(menu_id)


    cuisine(cuisine_id, name)
        pk:cuisine_id


    restaurant_cuisines(restaurant_id, cuisine_id)
        pk: (restaurant_id, cuisine_id)
        fk: (restaurant_id, cuisine_id)

    menu(menu_id, restaurant_id)
        pk: (menu_id, restaurant_id)
        fk: (menu_id, restaurant_id)

    menu_section(section_id, menu_id, section_name, )
        pk: section_id, 
        fk: menu_id

    dish (dish_id, section_id, name, description, dish_type_id, price, recipe_id )

        pk: dish_id
        fk: section_id, dish_type_id, recipe_id

    recipe(recipe_id, procedure varchar)

        pk: recipe_id, 


    recipe_ingrediants(recipe_id, ingrediant_id, quantity)

        pk: recipe_id, ingrediant_id
        fk: ingrediant_id, recipe_id

    ingrediants(ingrediant_id, name, ingrediant_type_id)
        pk: ingrediant_id, 
        fk: ingrediant_type_id

    ingrediant_type_id(id, type, unit_id)
        pk: ingrediant_type_id
        fk: unit_id 

    units(unit_id, unit)
        pk: unit_id 

    dish_type(dish_type_id, type)
        pk: dish_type_id

    waiter_level(waiter_level_id, level)
        pk: waiter_level_id
        
    employee_id(employee_id, name, email, phone_number)
        pk: employee_id 

    waiter(waiter_id, employee_id, waiter_level_id)
        pk: waiter_id 
        fk: employee_id, waiter_level_id

    chef(chef_id, employee_id, chef_level_id)
        pk: chef_id 
        fk: employee_id, chef_level_id

    chef_level(chef_level_id, level)
        pk: chef_level_id 


    table(table_id, table_no)
        pk: table_id 
        
    customer(customer_id, name, email, phone_number)
        pk: customer_id

    order(order_id, customer_id, table_id, order_status_id)
        pk: order_id 
        fk: customer_id, table_id, order_status_id 


    order_status(status_id, status)
        pk: order_status_id 

    order_dishes(order_id, dish_id, quantity)
        pk: order_id
        fk: dish_id 

    bills(bill_id, customer_id, bill_amount, bill_status_id)
        pk: bill_id, 
        fk: customer_id, bill_status_id

    bill_order(bill_id, order_id)
        pk: bill_id, 
        fk: order_id
    
    bill_status(bill_status_id, status)