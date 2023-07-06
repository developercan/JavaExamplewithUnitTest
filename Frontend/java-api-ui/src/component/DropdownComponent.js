import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Dropdown, DropdownButton } from 'react-bootstrap';
import "bootstrap/dist/css/bootstrap.min.css";
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

const DropdownComponent = ({ setSelectedProducts }) => {
  const [data, setData] = useState([]);
  const [selectedProductsList, setSelectedProductsList] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/Products');
      setData(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleItemClick = (item) => {
    setSelectedProductsList((prevSelectedProducts) => [...prevSelectedProducts, item]);
  };

  useEffect(() => {
    console.log(selectedProductsList);
  }, [selectedProductsList]);

  return (
    <div>
      <DropdownButton id="dropdown-button" title="All Products">
        {data.map((item, index) => (
          <Dropdown.Item key={index} onClick={() => handleItemClick(item)}>
            {item.productName} : ${item.price}
          </Dropdown.Item>
        ))}
      </DropdownButton>
      <p>Selected Product Count: {selectedProductsList.length}</p>
      {selectedProductsList.length > 0 && (
        <div>
          <br />
          <h4>Selected Products:</h4>
          {selectedProductsList.map((product, index) => (
            <div key={index}>
              <p>{product.productName}: ${product.price}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default DropdownComponent;
