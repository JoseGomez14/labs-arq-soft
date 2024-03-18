import { CalendarCheckIcon } from "../Icons/Icons";
import { Input } from "../common/Input";

const DateFilter = ({ startDate, setStartDate, endDate, setEndDate }) => {
  return (
    <div>
      <div className="bg-slate-50 rounded-lg p-4 flex items-center justify-center space-x-4 max-w-full w-full gap-4">
        <CalendarCheckIcon className="w-6 h-6" />
        <div className="flex-1 flex flex-nowrap items-center justify-center gap-2">
          <span className="font-semibold text text-nowrap">Leave On</span>
          <Input
            placeholder="Departure date"
            type="date"
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
          />
        </div>
        <div className="flex-1 flex flex-nowrap items-center justify-center gap-2">
          <span className="font-semibold text-nowrap">Arrive On</span>
          <Input
            placeholder="Return date"
            type="date"
            value={endDate}
            onChange={(e) => setEndDate(e.target.value)}
          />
        </div>
      </div>
    </div>
  );
};

export default DateFilter;
