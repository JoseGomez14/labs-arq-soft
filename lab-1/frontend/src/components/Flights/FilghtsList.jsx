import FlightCard from "./FlightCard";

const FilghtsList = ({ flights }) => {
  return (
    <div>
      <div className="space-y-2">
        <h2 className="text-2xl font-semibold">Flights</h2>
        <div className="h-2" />
      </div>
      <div className="space-y-4 flex gap-10 flex-col">
        {flights.map((flight) => {
          return (
            <div key={flight.id + "flight"}>
              <FlightCard flight={flight} />
              <div className="border-t border-gray-200 w-full" />
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default FilghtsList;
