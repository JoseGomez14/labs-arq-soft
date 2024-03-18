import { PlaneLandingIcon, PlaneTakeoffIcon } from "../Icons/Icons";

import { Input } from "../common/Input";

const CitiesFilter = ({
  originCity,
  setOriginCity,
  destinationCity,
  setDestinationCity,
}) => {
  return (
    <div className="bg-slate-50 rounded-lg p-4 gap-4 flex flex-col items-start justify-center flex-nowrap w-full max-w-full">
      <div className="flex gap-4 items-center w-full">
        <PlaneTakeoffIcon className="w-6 h-6" />
        <span className="font-semibold w-[120px]">Departure</span>
        <Input
          className="w-full"
          placeholder="Search for your departure city"
          type="search"
          value={originCity}
          onChange={(e) => setOriginCity(e.target.value)}
        />
      </div>
      <div className="flex gap-4 items-center w-full">
        <PlaneLandingIcon className="w-6 h-6" />
        <span className="font-semibold w-[120px]">Destination</span>
        <Input
          className="w-full"
          placeholder="Search for your destination city"
          type="search"
          value={destinationCity}
          onChange={(e) => setDestinationCity(e.target.value)}
        />
      </div>
    </div>
  );
};

export default CitiesFilter;
