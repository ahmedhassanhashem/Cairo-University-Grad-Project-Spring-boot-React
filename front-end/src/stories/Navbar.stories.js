import { Navbar } from "./Navbar";

console.log({ Navbar });
export default {
  title: "Example/Navbar",
  component: Navbar,
  // This component will have an automatically generated Autodocs entry: https://storybook.js.org/docs/7.0/react/writing-docs/docs-page
  tags: ["autodocs"],
  parameters: {
    // More on how to position stories at: https://storybook.js.org/docs/7.0/react/configure/story-layout
    layout: "fullscreen",
  },
};

export const Default = {
  args: {
    user: {
      name: "Jane Doe",
    },
  },
};
