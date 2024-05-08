/// <reference path="../.astro/types.d.ts" />
/// <reference types="astro/client" />

type TAirplaneModel = {
  description: string;
  id: number;
  family: string;
  capacity: number;
  cargoCapacity: number;
  volumeCapacity: number;
};

type TAirport = {
  id: number;
  name: string;
  type: string;
  city: string;
  country: string;
  runways: number;
};

type TScale = {
  description: string;
  id: number;
  airplaneModel: TAirplaneModel;
  originAirport: TAirport;
  destinationAirport: TAirport;
  departureDate: string;
  arrivalDate: string;
};

type TFlight = {
  id: number;
  flightNumber: string;
  basePrice: number;
  taxPercent: number;
  surcharge: number;
  flightType: string;
  scales: TScale[];
};
