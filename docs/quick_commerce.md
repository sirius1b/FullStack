requirements:

    There are multiple stores which have items that users need delivered at their doorsteps.
    There are multiple delivery partners who can pickup items from a store and deliver it to a user's home.
    Some partners can be online i.e. they should be considered for making a delivery where as some can be offline, these partners should not be considered for making delivery.
    At any given point in time we can have multiple available partners and multiple orders (is a user trying to order grocery items) live in the system. To match a partner with a task, we want to consider the distance between the partner's current location and the distance from the pickup store, partner who is closest to the store should get the task assigned. Although the criteria for matching a partner and a task can change in the future.
    Every store has a limited inventory of items. Before accepting an order we need to make sure that we have the required quantity of items to fulfil that order.
    The partners mobile app will send their latest location every few seconds, we need to store this information so that we can track partners.


class diagram

    stores 
        location
        assignmentStrategy 
        Map<Items,Integer> availableItems

        + verifyAvailability(Map<Items,Integer> requiredItems)

    user
        addresses List<Address>
        name
        location

    Address
        address: string
        location
    

    deliveryPaartner
        location
        status DeliveryPartnerStatus
        name


    enum DeliveryPartnerStatus
        IDLE
        OFFLINE
        IN_DELIVERY
        
    Orders
        user
        address
        Map<Item, Integer> items
        deliver_partner 
        orderStatus
        store

    OrderStatus
        Submitted
        Picked_UP
        Delivered
        pickUpTime
        submissionTime
        
    Item
        name

    Location
        latitude
        longitude

    PartnerAssignmentStrategy 

    ClosestPartnerAssignment --> PartnerAssignmentStrategy


-- schema 



    stores(store_id, address_id, partner_strategy_type_id, )
        pk: store_id, 
        fk: partner_strategy_type_id, address_id 


    locations(location_id, latittude, longitude)
        pk: location_id, 


    users(user_id, name, email, phone_no)
        pk: user_id, 

    user_addresses(user_id, address_id)
        pk: (user_id, address_id)
        fk: user_id, address_id 


    addresses(address_id, location_id, address)
        pk: address_id,
        fk: location_id 


    
    delivery_partner(partner_id, location_id, partner_status_id, name) 
        pk: partner_id, 
        fk: location_id, partner_status_id

    partern_status(partner_status_id, status)
        pk: partner_status_id 
        
    order_status(order_status_id, status)
        pk: order_status_id 
    
    order(order_id, user_id, address_id, partner_id, order_status_id, store_id)
        pk: order_id, 
        fk: user_id, partner_id, order_status_id , store_id, address_id 

    order_items(order_id, item_id, quantity) 
        pk: order_id, item_id 
        fk: order_id, item_id 
    
    store_items(store_id, item_id, quantity) 
        pk: store_id, item_id 
        fk: store_id, item_id 

    partner_strategy_type(partner_strategy_type_id, type)
        pk: partner_strategy_type_id





    



