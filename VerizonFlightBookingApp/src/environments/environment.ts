// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
const HOSTNAME: string = "localhost";
const PORT_NUMBER: number = 3333;
const APPLICATION_NAME: string = '/verizon_group_project';
export const environment = {
  production: false,
  adminAPIUrl: 'http://' + HOSTNAME + ':' + PORT_NUMBER + APPLICATION_NAME + '/AdminAPI',
  travelerAPIUrl: 'http://' + HOSTNAME + ':' + PORT_NUMBER + APPLICATION_NAME + '/TravelerAPI',
  flightAPIUrl: 'http://' + HOSTNAME + ':' + PORT_NUMBER + APPLICATION_NAME + '/FlightAPI',
  airportAPIUrl: 'http://' + HOSTNAME + ':' + PORT_NUMBER + APPLICATION_NAME + '/AirportAPI',
  bookingAPIUrl: 'http://' + HOSTNAME + ':' + PORT_NUMBER + APPLICATION_NAME + '/BookingAPI'

};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
