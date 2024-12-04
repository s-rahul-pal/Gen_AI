import React from "react";
import "./SideBar.css";
import solarlogo from "../images/solar-logo.png";
import dashboardImage from "../images/Dashboard-2.png";
import manageAccounts from "../images/manage_accounts.png";
import manageAccounts2x from "../images/manage_accounts2x.png";
import manageAccounts3x from "../images/manage_accounts3x.png";
import logoutImage from "../images/logout.png";

const SideBar = () => {
  const manageAccount = [manageAccounts2x, manageAccounts, manageAccounts3x];
  return (
    <div className="Rectangle-2">
      <div className="sidebar-header">
        <img alt="logo" src={solarlogo} className="image-1"></img>

        <span className="Solargy-Dashboard">Solargy Dashboard</span>
        <div className="Line-1"></div>
        <span className="Powered-by-Shell-Global">Powered by Shell Global</span>
      </div>
      <div className="Rectangle-3">
        <img src={dashboardImage} className="Vector"></img>

        <span className="Dashboard">Dashboard</span>
      </div>
      <div className="Rectangle-69">
        <img src={manageAccounts2x} className="manage_accounts" />

        <span className="Profile-Settings">Profile Settings</span>
      </div>
      <div className="Rectangle-69">
        <img src={logoutImage} className="Vector"></img>

        <span className="Logout">Logout</span>
      </div>
    </div>
  );
};

export default SideBar;
