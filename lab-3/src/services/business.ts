import axios from "axios";

const API_URL = import.meta.env.FLIGHT_MANAGEMENT_API_URL;
const API_VERSION = import.meta.env.FLIGHT_MANAGEMENT_API_VERSION || "v1";

const fetcher = axios.create({
  baseURL: `https://codefact.udea.edu.co/modulo-18/api/v1`,
});

export async function getFlights(): Promise<TFlight[]> {
  return (await fetcher.get("/flights")).data;
}
