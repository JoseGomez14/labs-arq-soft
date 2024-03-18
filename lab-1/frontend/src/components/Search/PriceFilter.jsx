const PriceFilter = ({ value, setValue }) => {
  return (
    <div className="relative mb-6 max-w-full w-[650px] flex self-center flex-col">
      <span className="font-semibold w-[120px]">Price</span>
      <label htmlFor="labels-range-input"></label>
      <input
        id="labels-range-input"
        type="range"
        value={value}
        onChange={(e) => setValue(e.target.value)}
        min="0"
        max="600"
        className="w-full h-2 bg-gray-200 rounded-lg appearance-none cursor-pointer dark:bg-gray-700"
      />
      <span className="text-sm text-gray-500 dark:text-gray-400 absolute start-0 -bottom-6">
        Min ($0)
      </span>
      <span className="text-sm text-gray-500 dark:text-gray-400 absolute start-1/3 -translate-x-1/2 rtl:translate-x-1/2 -bottom-6">
        $200
      </span>
      <span className="text-sm text-gray-500 dark:text-gray-400 absolute start-2/3 -translate-x-1/2 rtl:translate-x-1/2 -bottom-6">
        $400
      </span>
      <span className="text-sm text-gray-500 dark:text-gray-400 absolute end-0 -bottom-6">
        Max ($600)
      </span>
    </div>
  );
};

export default PriceFilter;
