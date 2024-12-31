
requirements:
    Design a class diagram for BookMyShow Requirements: 
    1. We will have multiple cities. 
    2. Each city has mulitple theatres. 
    3. Each theatre has multiple screens. 
    4. Each screen has multiple seats. 
    5. There are different types of seats: PLATINUM, GOLD, SILVER. 
    6. Each screen will have multiple shows. 
    7. Every show will be for a movie and will have a start time and end time. 
    8. Each show depending upon the day, time and seat type will have different prices. 
    9. Movies, shows and screens will support features like 2D, 3D, DOLBY_IMAX, DOLBY_VISION etc. 
    10. We integrate with Razorpay to handle payments. 
    11. Users should be able to book multiple seats for a show via the app by paying for them at the time of booking.


--class diagram

    

    class city
        name, 
        list[theater] theaters
        
    class theater
        name
        address
        list [screen] screen

    class screen
        list[seat] seats
        list[feature] features
        list[show] shows

    class seat
        seatTier 
        seatNo

    enum seatTier 
        gold, 
        platinum 
        silver 

    class show
        startTime
        endTime
        name
        screen
        Map<SeatType, double> prices

    enum feature
        2d, 3d, dolby_imax, dobly_vision 

    booking
        list[seat] seats
        show show
        Customer user

    class Customer
        id, 
        name
        phone_no
        
    class PaymentProvider
        url

    class RazorPayPaymentProvider    


// outside model 
    Booking Controller
        getCities   
        getTheaters(city)
        getShows(city)
        getShows(theather)
        findShow(name)
        
        getScreen(theater)
        getSeats(screen)
        bookSeats(seats, show)
    
    


-- schema diagram 



    cities(city_id, name)
        pk: city_id
    theaters (theater_id, name, address, city_id)
        pk: theater_id, 
        fk: city_id 
    screens(screen_id, theater_id )
        pk: screen_id, 
        fk: theater_id
    seat(seat_id, seat_tier_id, seat_no, screen_id )
        pk: seat_id, 
        fk: seat_tier_id, screen_id
    seat_tiers(seat_tier_id, tier)
        pk: seat_tier_id
        
    show(show_id, startTime, endTime, name, screen_id, )
        pk: show_id, 
        fk: screen_id, 

    features(feature_id, feature)
        pk: feature_id

    screen_features(screen_id, feature_id)
        pk: screen_id, feature_id 
        fk: screen_id, feature_id, 
    
    show_seat_prices(show_id, seat_tier_id, price)
        pk: (show_id, seat_tier_id)
        fk: show_id, seat_tier_id 
     

    booking(booking_id, show_id, customer_id)
        pk: booking_id, 
        fk: show_id, customer_id

    booking_seats(booking_id, seat_id)
        pk: booking_id, seat_id
        fk: booking_id, seat_id 

    customers(customer_id, name, phone_no, email)
        pk: customer_id

    razor_payment_provider(provider_id )
        url
        

    

