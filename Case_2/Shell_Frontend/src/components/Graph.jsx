import React, { useState, useEffect } from "react";
import { Chart } from "primereact/chart";
import "./Graph.css";
import axios from "axios";
import { Dropdown } from "primereact/dropdown";
import { Button } from 'react-bootstrap';
import ModalTable from "./ModalTable";
import EnergyData from "../models/EnergyData.json";
// ... (imports and component definition)

export default function Graph() {
  const cities = ["Current Week", "Current Month", "Current Year"];
  const [selectedTime, setSelectedTime] = useState("Current Week");
  const [chartData, setChartData] = useState({});
  const [chartOptions, setChartOptions] = useState({});
  // const [dataList, setDataList] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const handleButtonClick = () => setShowModal(true);
  const handleCloseModal = () => setShowModal(false);
  const [energyData, setEnergyData] = useState([]);
  const [dataList, setDataList] = useState(EnergyData);
  const [responseData, setResponseData] = useState([
    {
      energyDataList: dataList,
      maxEnergyGenerated: 5.9,
      minEnergyGenerated: 5.5,
      maxEnergyConsumed: 5.8,
      minEnergyConsumed: 5.2,
    },
  ]);
  const [energyGeneration, setEnergyGeneration] = useState(0);
  const [energyConsumption, setEnergyConsumption] = useState(0);
  const [monthlyAverage, setMonthlyAverage] = useState({
    averageConsumption: 0,
    averageGeneration: 0,
    exportToGrid: 0,
  });
  const now = new Date();

  useEffect(() => {
    const monthlyAverageUrl = "http://localhost:8080/averageEnergyConsumption";
    axios.get(monthlyAverageUrl).then((response) => {
      console.log("Response from monthlyAverage request:", response);
      console.log(
        "Response from monthlyAverage request:",
        (response.data.averageGeneration).toFixed(2)
      );
      setMonthlyAverage({
        averageConsumption: parseFloat(response.data.averageConsumption).toFixed(2),
        averageGeneration: parseFloat(response.data.averageGeneration).toFixed(2),
        exportToGrid: parseFloat(response.data.exportToGrid).toFixed(2),
      });
    });
    const currentMonthUrl = "http://localhost:8080/energy-data/Current Month";
    axios.get(currentMonthUrl).then((response) => {
      console.log("Response from currentMonth request:", response);
      setEnergyData(response.data);
    });

    const currentMonth1Url = `http://localhost:8080/energy-data/current-month`;
    axios.get(currentMonthUrl).then((response) => {
      console.log("Response from currentMonth request:", response);
      setEnergyData(response.data);
    });
    console.log("selected time" + selectedTime);

    const documentStyle = getComputedStyle(document.documentElement);
    const textColor = documentStyle.getPropertyValue("--text-color");
    const textColorSecondary = documentStyle.getPropertyValue(
      "--text-color-secondary"
    );
    const surfaceBorder = documentStyle.getPropertyValue("--surface-border");

    let labels = [null];

    const apiUrl = "http://localhost:8080/energy-data/" + selectedTime;

    axios
      .get(apiUrl)
      .then((response) => {
        console.log("Response from GET request:", response);
        // Handle the response data here
        //setResponseData(response.data);

        // Define labels based on the selectedTime
        if (selectedTime === "Current Week") {
          // Implement logic for the last five weeks
          // Here, we assume each week starts on Sunday
          const startOfWeek = new Date(now);
          startOfWeek.setFullYear(2023);
          startOfWeek.setDate(now.getDate() - now.getDay()); // Go back to Monday
          for (let i = 0; i < 7; i++) {
            const day = new Date(startOfWeek);
            day.setDate(startOfWeek.getDate() + i);
            labels.push(day.toLocaleDateString("en-US", { weekday: "long" }));
          }
        } else if (selectedTime === "Current Month") {
          // Display "Week 1" to "Week 4" for the current month
          for (let i = 1; i <= 4; i++) {
            labels.push(`Week ${i}`);
          }
        } else if (selectedTime === "Current Year") {
          // Display the last five quarters, including the current quarter
          for (let i = 0; i < 12; i++) {
            const month = new Date(now);
            month.setMonth(i);
            labels.push(month.toLocaleString("default", { month: "long" }));
          }
        }

        const data = {
          labels: labels,
          datasets: [
            {
              label: "Energy Generation",
              data: [null],
              fill: false,
              tension: 0.5,
            },
            {
              label: "Energy Consumption",
              data: [null],
              fill: false,
              borderColor: documentStyle.getPropertyValue("--pink-500"),
              tension: 0.5,
            },
          ],
        };
        console.log(
          "Data list from Graph.jsx:" +
          responseData[0].energyDataList[0].energyGeneration
        );
        for (let i = 1; i < labels.length; i++) {
          var energyGeneration = 0;
          var energyConsumption = 0;
          function sum(data) {
            energyGeneration += data.energyGeneration;
            energyConsumption += data.energyConsumption;
          }
          responseData.forEach(myFunction);
          function myFunction(energyData) {
            energyData.energyDataList.forEach(sum);
            console.log("Energy data:" + energyData.energyDataList);
            console.log("Energy generation:" + energyData.energyGeneration);
            console.log("Energy consumption:" + energyData.energyConsumption);
            // energyGeneration += energyData.energyGeneration;
            // energyConsumption += energyData.energyConsumption;
            data.datasets[0].data.push(energyGeneration);
            data.datasets[1].data.push(energyConsumption);
            energyConsumption = 0;
            energyGeneration = 0;
          }
        }
        var totalEnergyGeneration = 0;
        var totalEnergyConsumption = 0;
        data.datasets[0].data.forEach((element) => {
          totalEnergyGeneration += element;
        });
        data.datasets[1].data.forEach((element) => {
          totalEnergyConsumption += element;
        });
        setEnergyConsumption(totalEnergyConsumption.toFixed(2));
        setEnergyGeneration(totalEnergyGeneration.toFixed(2));

        console.log("Data list from Graph.jsx:" + data.datasets[0].data);
        console.log("Data list from Graph.jsx:" + data.datasets[1].data);
        // Update data.datasets based on the response

        const options = {
          maintainAspectRatio: false,
          aspectRatio: 0.7,
          plugins: {
            legend: false,
          },
          scales: {
            x: {
              ticks: {
                color: textColorSecondary,
              },
              grid: {
                color: "rgba(0, 0, 0, 0)",
              },
            },
            y: {
              ticks: {
                color: textColorSecondary,
              },
              grid: {
                color: "rgba(0, 0, 0, 0)",
              },
            },
          },
        };

        setChartData(data);
        setChartOptions(options);
      })
      .catch((error) => {
        // Handle any errors that occur during the request
        console.error("Error making GET request:", error);
      });
  }, [selectedTime]);

  return (
    <div>
      <div className="shell-header">
        <div className="text-container">
          <span className="Welcome-text">
            <span className="text-style-1">Welcome</span>
          </span>

          <div>
            <span className="Welcome-text">Rahul Pal</span>
          </div>
        </div>
        <div className="Rectangle-7">
          <div className="Rectangle-8">
            <div className="Monthly-Overview-div">
              <p className="Monthly-Overview">Monthly Overview</p>
              <span className="in-kW">(in kW)</span>
            </div>
          </div>
          <div className="rect-1">
            <span className="Energy-Generation">Energy Generation</span>

            <p className="number-1">{monthlyAverage.averageGeneration}</p>
          </div>
          <div className="rect-1">
            <span className="Energy-Consumption">Energy Consumption</span>

            <p className="number-1">{monthlyAverage.averageConsumption}</p>
          </div>
          <div className="rect-2">
            <span class="Export-to-Grid">Export to Grid</span>

            <p className="number-2">{monthlyAverage.exportToGrid}</p>
          </div>
        </div>
      </div>
      <div className="Rectangle-4">
        <div className="header">
          <span className="Solar-Generation-Consumption">
            Solar Generation & Consumption
          </span>
          
        </div>
        <div></div>
        <div className="graph-card">
          <div>
            <div class="Rectangle-6">
              <div className="card">
                <Chart type="bar" data={chartData} options={chartOptions} />
                <ModalTable show={showModal} handleClose={handleCloseModal} data={EnergyData} />
              </div>
            </div>
          </div>
          <div className="right-patch">
            <div className="dropdown-custom">
              <Dropdown
                value={selectedTime}
                onChange={(e) => {
                  setSelectedTime(e.value);
                }}
                options={cities}
                placeholder="Select one"
                className="w-full md:w-14rem"
              />
            </div>

            <div className="data-card">
              <div>
                <span class="Energy-Generation-1">Energy Generation</span>
                <div>
                  <span className="number-4">{energyGeneration}</span>
                  <span className="kWh">kWh</span>
                </div>
              </div>
            </div>
            <div className="data-card">
              <div>
                <span class="Energy-Generation-2">Energy Consumption</span>
                <div>
                  <span className="number-5">{energyConsumption}</span>
                  <span className="kWh-1">kWh</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
