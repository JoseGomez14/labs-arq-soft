import { twMerge } from "tailwind-merge";

export const Button = ({ children, ...props }) => {
  return (
    <button
      {...props}
      className={twMerge(
        props.className,
        "bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded ease-in-out transition-colors duration-300"
      )}
    >
      {children}
    </button>
  );
};
