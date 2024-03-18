import { BuildingIcon } from "../Icons/Icons";

const AirlineFilter = ({ arline, setAirline }) => {
  return (
    <div className="bg-slate-50 rounded-lg p-4 gap-4 flex flex-col items-start justify-center flex-nowrap w-full max-w-full">
      <div className="flex gap-4 items-center w-full">
        <BuildingIcon className="w-6 h-6" />
        <span className="font-semibold w-[120px]">Airline</span>
        <select
          className="bg-transparent p-3 bg-white rounded-lg outline-none w-full"
          value={arline}
          onChange={(e) => setAirline(e.target.value)}
        >
          <option value="">Airline for your flight</option>
          <option value="Avianca">Avianca</option>
          <option value="LATAM">LATAM</option>
          <option value="Wingo">Wingo</option>
          <option value="JetFly">JetFly</option>
          <option value="Airways Inc.">Airways Inc.</option>
        </select>
      </div>
    </div>
  );
};

export default AirlineFilter;
