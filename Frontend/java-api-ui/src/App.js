import './App.css';
import axios from "axios";
import React, { useEffect, useState } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import { Dropdown, DropdownButton } from 'react-bootstrap';

function App() {

  useEffect(() => {
    fetchProdData();
  }, []);

  const fetchProdData = async () => {
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
  const [data, setData] = useState([]);
  const [totalFee,setTotalFee]=useState([]);

  const [customers, setCustomers] = useState([]);
  const [selectedProductsList, setSelectedProductsList] = useState([]);
  const [amount, setAmount] = useState(0);

  useEffect(() => {
    fetchData();
  }, []);

  //axios
  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/Customers');
      setCustomers(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const [name, setName] = useState(""); // Name değerinin state'i
  const [surname, setSurname] = useState(""); // Surname değerinin state'i
  const [isPhone, setIsPhone] = useState(); // isPhone değerinin state'i

  const handleGetAmount = () => {
    const totalAmount = selectedProductsList.reduce((acc, product) => acc + product.price, 0);
    setAmount(totalAmount);
    console.log("Toplam tutar: " + totalAmount);
    console.log(selectedProductsList);
    //productName in ne olduğunu bilmiyor tekrar göz geçir bakayım şu merete

      console.log(isPhone);selectedProductsList.forEach((product) => {
        const test=product.productName;
        console.log("gelen veri: "+test);
        console.log("isPhone 1: "+isPhone);
        if(product.productName=="Telephone") setIsPhone(true);
        console.log("isPhone 2:"+isPhone);
      });
     
    // Burada Axios API çağrısını gerçekleştirin ve 'totalAmount' değerini kullanarak işlem yapın
    // Örnek olarak:
    axios.get(`http://localhost:8080/GetAmount/${name}/${surname}/${totalAmount}/${isPhone}`)
      .then(response => {
        // İşlem başarılı olduysa gelen verileri kullanabilirsiniz
        console.log(response.data);
        setTotalFee(response.data);
      })
      .catch(error => {
        // Hata durumunda hata mesajını kullanabilirsiniz
        console.log(error);
      });
    //  setTotalFee(bill.data);
     // console.log(totalFee);
      
  };
  return (
    <div className="App">
      <div className='App-header'>
        <ul className="list-group"> Customer list:
          {customers.map((customer) => (
            <li key={customer.id} className="list-group-item">{customer.name} {customer.surname}</li>
          ))}
        </ul>
        <br></br>
        <form style={{ alignContent: "left" }}>
          <label>
            Name:
            <input id="Name" type="text" name="Customer Name" onChange={(event) => setName(event.target.value)} />
          </label>
          <label>
            Surname:
            <input id='Surname' type="text" name="Customer Surname" onChange={(event) => setSurname(event.target.value)} />
          </label>

          <DropdownButton id="dropdown-button" title="All Products">
            {data.map((item, index) => (
              <Dropdown.Item key={index} onClick={() => handleItemClick(item)}>
                {item.productName} : ${item.price}
              </Dropdown.Item>
            ))}
          </DropdownButton>
  
          <br />
          <h4>Selected Products:</h4>
          {selectedProductsList.map((product, index) => (
            <div key={index}>
              <p>{product.productName}: ${product.price}</p>
            </div>
          ))}

          
          <br></br>
          <input type="button" value="Get Amount" onClick={handleGetAmount} />
        </form>
        <br />
        <h4>Amount: {amount}</h4>
        <h4>With Discounts: {totalFee}</h4>
      </div>
    </div>
  );
}

export default App;
