import { Traveler } from './traveler';
import { Flight } from './Flight';

export class Booking{
    flight: Flight;
    traveler: Traveler;
    dateOfTravel: Date;
    bookingId: number;
    numberOfTravelers: number;
}