import "../styles/globals.css";

import { Inter } from "next/font/google";
import { Providers } from "./providers/Providers";

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
  title: "Flights App - Lab 1",
  description: "Flights Search Frontend App - Lab 1",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <Providers>{children}</Providers>
      </body>
    </html>
  );
}
