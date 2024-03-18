"use client";

import FilghtsList from "@/components/Flights/FilghtsList";
import { FilterBox } from "@/components/Search/FilterBox";
import { useState } from "react";

export default function FlightsSearch() {
  const [flights, setFlights] = useState([]);

  return (
    <main className="w-full max-w-3xl mx-auto px-4 mt-8">
      <h2 className="text-2xl font-semibold">¡Find your perfect flight!</h2>
      <br />
      <div className="space-y-6">
        <FilterBox setFlights={setFlights} />
        <FilghtsList flights={flights} />
      </div>
    </main>
  );
}
