// src/components/ModalTable.jsx
import React from 'react';
import { Modal, Table } from 'react-bootstrap';
import './ModalTable.css';

const ModalTable = ({ show, handleClose, data }) => {
  return (
    <div className='modalContainer'>
    <Modal show={show} onHide={handleClose} className='modal'>
      <Modal.Header closeButton>
        <Modal.Title>Energy Data</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>Date</th>
              <th>Energy Consumption</th>
              <th>Energy Generation</th>
              <th>Export To Grid</th>
            </tr>
          </thead>
          <tbody>
            {data.map((item) => (
              <tr key={item.id}>
                <td>{item.date}</td>
                <td>{item.energyConsumption}</td>
                <td>{item.energyGeneration}</td>
                <td>{item.exportToGrid}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </Modal.Body>
    </Modal>
    </div>
  );
};

export default ModalTable;