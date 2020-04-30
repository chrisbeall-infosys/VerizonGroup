import { Airport } from './airport';

export class Flight {
    fromAirport: Airport;
    toAirport: Airport;
    flightId: number;
    fare: number;
    taxes: number;
};