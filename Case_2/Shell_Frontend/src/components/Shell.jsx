import React from "react";
import SideBar from "./SideBar";

import "./Shell.css";
import Graph from "./Graph";
const Shell = () => {
  return (
    <div className="Shell">
      <div className="Rectangle-1">
        <div>
          <SideBar />
        </div>
        <div>
          <Graph />
        </div>
      </div>
    </div>
  );
};

export default Shell;
