"use client";

import AirlineFilter from "./AirlineFilter";
import { Button } from "../common/Button";
import CitiesFilter from "./CitiesFilter";
import DateFilter from "./DateFilter";
import PriceFilter from "./PriceFilter";
import { searchFlights } from "@/services/flightSearchApi";
import { useMutation } from "react-query";
import { useState } from "react";

export const FilterBox = ({ setFlights }) => {
  const [filterType, setFilterType] = useState("all"); // all, o&d, price, airline, date

  const [maxPrice, setMaxPrice] = useState(200);

  const [airline, setAirline] = useState("");
  const [origin, setOrigin] = useState("");
  const [destination, setDestination] = useState("");
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");

  const { mutate } = useMutation({
    mutationKey: ["flights", origin, destination, startDate, endDate, maxPrice],
    mutationFn: searchFlights,
    onSuccess: (data) => {
      setFlights(data);
    },
  });

  const handleSearch = () => {
    mutate({
      filterType: filterType,
      searchParams: {
        origin,
        destination,
        startDate,
        endDate,
        maxPrice,
        minPrice: 0,
        airline,
      },
    });
  };

  return (
    <div className="bg-slate-50 rounded-lg py-4 px-2 items-center flex flex-col justify-center">
      <div className="bg-slate-50 rounded-lg p-4 gap-4 flex flex-col items-start justify-center flex-nowrap w-full max-w-full">
        {filterType === "all" && (
          <>
            <DateFilter
              startDate={startDate}
              setStartDate={setStartDate}
              endDate={endDate}
              setEndDate={setEndDate}
            />
            <CitiesFilter
              originCity={origin}
              setOriginCity={setOrigin}
              destinationCity={destination}
              setDestinationCity={setDestination}
            />
            <PriceFilter value={maxPrice} setValue={setMaxPrice} />
            <AirlineFilter airline={airline} setAirline={setAirline} />
          </>
        )}
        {filterType === "o&d" && (
          <CitiesFilter
            originCity={origin}
            setOriginCity={setOrigin}
            destinationCity={destination}
            setDestinationCity={setDestination}
          />
        )}

        {filterType === "price" && (
          <PriceFilter value={maxPrice} setValue={setMaxPrice} />
        )}
        {filterType === "airline" && (
          <AirlineFilter arline={airline} setArline={setAirline} />
        )}
        {filterType === "date" && (
          <DateFilter
            startDate={startDate}
            setStartDate={setStartDate}
            endDate={endDate}
            setEndDate={setEndDate}
          />
        )}
      </div>
      <div className="flex gap-2">
        <select
          value={filterType}
          onChange={(e) => setFilterType(e.target.value)}
          className="bg-transparent p-3 bg-white rounded-lg outline-none"
        >
          <option value="all">All</option>
          <option value="o&d">Origin & Destination</option>
          <option value="price">Price</option>
          <option value="airline">Airline</option>
          <option value="date">Date</option>
        </select>
        <Button onClick={handleSearch}>Search</Button>
      </div>
    </div>
  );
};
