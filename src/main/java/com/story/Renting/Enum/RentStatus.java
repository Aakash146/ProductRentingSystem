package com.story.Renting.Enum;

public enum RentStatus {
    REQUESTED,  // Customer request for rent.
    RENTING,    // Customer is using the product they rented for.
    DELAYED,    // Customer is not able to return the product on time.
    RETURNED_WITH_FINE, // Customer returned the product with fine.
    RETURNED,  // Customer returned the product without delay.
    CANCELLED // Customer cancelled the product before renting.
}
