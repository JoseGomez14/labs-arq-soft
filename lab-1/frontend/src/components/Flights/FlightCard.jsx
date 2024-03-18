import {
  ClockIcon,
  DollarSignIcon,
  PlaneLandingIcon,
  PlaneTakeoffIcon,
  UsersIcon,
} from "../Icons/Icons";

import { Button } from "../common/Button";
import Image from "next/image";

const FlightCard = ({ flight }) => {
  const {
    idx,
    origin,
    destination,
    airline,
    departureDate,
    arrivalDate,
    price,
  } = flight;

  console.log(flight);

  const departureDateFormated = new Intl.DateTimeFormat("en-US", {
    dateStyle: "short",
    timeStyle: "short",
  }).format(new Date(departureDate));

  const arrivalDateFormated = new Intl.DateTimeFormat("en-US", {
    dateStyle: "short",
    timeStyle: "short",
  }).format(new Date(arrivalDate));

  const timeDiff =
    Math.abs(new Date(departureDate) - new Date(arrivalDate)) / 36e5;

  const timeDiffFormated = `${Math.floor(timeDiff)}h ${Math.floor(
    (timeDiff % 1) * 60
  )}m`;

  const airlineLogo = `/${airline
    .toLowerCase()
    .replace(".", "")
    .replace(" ", "_")}.png`;

  return (
    <div className="space-y-4 bg-slate-50 p-8 rounded-lg">
      <div className="flex items-center space-x-2">
        <span className="text-lg font-medium">
          {idx} {origin} to {destination}
        </span>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-3 items-center gap-4">
        <div className="flex items-center space-x-2">
          <Image
            alt="Airline logo"
            className="rounded-lg"
            height="40"
            src={airlineLogo}
            style={{
              aspectRatio: "40/40",
              objectFit: "cover",
            }}
            width="40"
          />
          <span className="text-sm font-semibold">{airline}</span>
        </div>
        <div className="flex items-center space-x-2">
          <ClockIcon className="w-4 h-4" />
          <span className="text-sm">{timeDiffFormated}</span>
        </div>
        <div className="flex items-center space-x-2">
          <PlaneTakeoffIcon className="w-4 h-4 shrink-0" />
          <span className="text-sm">Departs {departureDateFormated}</span>
        </div>
        <div className="flex items-center space-x-2">
          <DollarSignIcon className="w-4 h-4" />
          <span className="text-sm font-semibold">{price}</span>
        </div>
        <div className="flex items-center space-x-2">
          <UsersIcon className="w-4 h-4" />
          <span className="text-sm">1 stop</span>
        </div>
        <div className="col-span-2 md:col-auto flex items-center space-x-2">
          <PlaneLandingIcon className="w-4 h-4" />
          <span className="text-sm">Arrives {arrivalDateFormated}</span>
        </div>
        <Button className="sm">Select</Button>
      </div>
    </div>
  );
};

export default FlightCard;
