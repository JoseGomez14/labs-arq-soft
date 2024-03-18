import axios from "axios";

const fetcher = axios.create({
  baseURL: "http://localhost:8080/flights/search",
});

export const getFlightsByDate = async ({ startDate, endDate }) => {
  const { data } = await fetcher.get("/date", {
    params: {
      startDate,
      endDate,
    },
  });
  return data;
};

export const getFlightsByAirline = async ({ airline }) => {
  const { data } = await fetcher.get("/airline", {
    params: {
      airline,
    },
  });
  return data;
};

export const getFlightsByPrice = async ({ minPrice, maxPrice }) => {
  const { data } = await fetcher.get("/price", {
    params: {
      minPrice,
      maxPrice,
    },
  });
  return data;
};

export const getFlightsByOriginAndDestination = async ({
  origin,
  destination,
}) => {
  const { data } = await fetcher.get("/originanddestination", {
    params: {
      origin,
      destination,
    },
  });
  return data;
};

export const getFlights = async ({
  startDate,
  endDate,
  airline,
  minPrice,
  maxPrice,
  origin,
  destination,
}) => {
  const { data } = await fetcher.get("/all", {
    params: {
      startDate,
      endDate,
      airline,
      minPrice,
      maxPrice,
      origin,
      destination,
    },
  });
  return data;
};

export const searchFlights = async ({ filterType, searchParams }) => {
  if (filterType === "all") {
    return await getFlights(searchParams);
  } else if (filterType === "date") {
    return await getFlightsByDate(searchParams);
  } else if (filterType === "airline") {
    return await getFlightsByAirline(searchParams);
  } else if (filterType === "price") {
    return await getFlightsByPrice(searchParams);
  } else if (filterType === "o&d") {
    return await getFlightsByOriginAndDestination(searchParams);
  }
};
