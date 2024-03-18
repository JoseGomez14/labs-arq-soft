import { twMerge } from "tailwind-merge";

export const Input = ({ children, ...props }) => {
  return (
    <input
      {...props}
      className={twMerge(
        props.className,
        "py-2 px-4 rounded ease-in-out transition-colors duration-300"
      )}
    >
      {children}
    </input>
  );
};
