import React, { useState, useEffect } from "react";
import "./App.css";

const App = () => {
  // State Variables
  const [brands, setBrands] = useState([]);
  const [cities, setCities] = useState([]);
  const [unavailableItems, setUnavailableItems] = useState([]);
  const [selectedBrand, setSelectedBrand] = useState("");
  const [selectedCity, setSelectedCity] = useState("");
  const [searchQuery, setSearchQuery] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  // Fetch brands on component mount
  useEffect(() => {
    fetchBrands();
  }, []);

  // Fetch brands from API
  const fetchBrands = async () => {
    try {
      setLoading(true);
      const response = await fetch("http://localhost:8080/api/brands");
      if (!response.ok) {
        throw new Error("Failed to fetch brands");
      }
      const data = await response.json();
      setBrands(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  // Fetch cities for the selected brand
  const fetchCities = async (brandId) => {
    try {
      setLoading(true);
      const response = await fetch(`http://localhost:8080/api/cities/${brandId}`);
      if (!response.ok) {
        throw new Error("Failed to fetch cities");
      }
      const data = await response.json();
      setCities(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  // Fetch unavailable items for the selected city
  const fetchUnavailableItems = async (cityId) => {
    try {
      setLoading(true);
      const response = await fetch(`http://localhost:8080/api/unavailable-items?cityId=${cityId}`);
      if (!response.ok) {
        throw new Error("Failed to fetch unavailable items");
      }
      const data = await response.json();
      setUnavailableItems(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  // Handle brand selection
  const handleBrandChange = (brandId) => {
    setSelectedBrand(brandId);
    setSelectedCity("");
    setCities([]);
    if (brandId) {
      fetchCities(brandId);
    }
  };

  // Handle submit button click
  const handleSubmit = () => {
    if (selectedBrand && selectedCity) {
      fetchUnavailableItems(selectedCity);
    }
  };

  // Filter items based on search query
  const filteredItems = unavailableItems.filter((item) =>
    item.name.toLowerCase().includes(searchQuery.toLowerCase())
  );

  return (
    <div className="App" style={{ padding: "20px", fontFamily: "Arial" }}>
      <div className="Heading"><h1>Gone Gourmet</h1>
      </div>
      <div className="Description">
      <h2>Select Brand and City.</h2>
      
      {/* Loading Indicator */}
      {loading && <p>Loading...</p>}

      {/* Error Message */}
      {error && <p style={{ color: "red" }}>{error}</p>}

      {/* Brand Selection Dropdown */}
      <div>
        <label htmlFor="brand">Select Brand:</label>
        <select
          id="brand"
          value={selectedBrand}
          onChange={(e) => handleBrandChange(e.target.value)}
        >
          <option value="">-- Select a Brand --</option>
          {brands.map((brand) => (
            <option key={brand.id} value={brand.id}>
              {brand.name}
            </option>
          ))}
        </select>
      </div>

      {/* City Selection Dropdown */}
      <div style={{ marginTop: "20px" }}>
        <label htmlFor="city">Select City:</label>
        <select
          id="city"
          value={selectedCity}
          onChange={(e) => setSelectedCity(e.target.value)}
          disabled={!selectedBrand}
        >
          <option value="">-- Select a City --</option>
          {cities.map((city) => (
            <option key={city.id} value={city.id}>
              {city.name}
            </option>
          ))}
        </select>
      </div>

      {/* Submit Button */}
      <div style={{ marginTop: "20px" }}>
        <button onClick={handleSubmit} disabled={!selectedBrand || !selectedCity}>
          Submit
        </button>
      </div>
      </div>

      {/* Unavailable Items Card */}
      {unavailableItems.length > 0 && (
        <div
          style={{
            marginTop: "20px",
            border: "1px solid #ccc",
            padding: "20px",
            borderRadius: "8px",
          }}
        >
          <h2>Unavailable Items</h2>
          {/* Search Bar */}
          <input
            type="text"
            placeholder="Search items..."
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
            style={{
              width: "100%",
              padding: "8px",
              marginBottom: "20px",
              borderRadius: "4px",
              border: "1px solid #ccc",
            }}
          />
          {/* Items List */}
          {filteredItems.length > 0 ? (
            filteredItems.map((item) => (
              <div
                key={item.id}
                style={{
                  padding: "10px",
                  borderBottom: "1px solid #eee",
                  display: "flex",
                  justifyContent: "space-between",
                }}
              >
                <span>{item.name}</span>
                <span style={{ fontStyle: "italic", color: "gray" }}>
                  {item.reason}
                </span>
              </div>
            ))
          ) : (
            <p>No items found.</p>
          )}
        </div>
      )}
    </div>
  );
};

export default App;
