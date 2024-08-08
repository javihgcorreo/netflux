import React, { Component, useState, useEffect } from 'react';

class SidebarDestacados extends Component {
  constructor(props) {
    super(props);
    this.state = {
      destacados: [],
    };
  }

  componentDidMount() {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8081/api/destacados');
        const data = await response.json();
        this.setState({ destacados: data });
      } catch (error) {
        console.error('Error al obtener datos:', error);
      }
    };

    fetchData();
  }

  render() {
    const { destacados } = this.state;

    return (
      <div id="destacados" className="destacados">
        <h4>Destacados</h4>
        <ul className="list-group">
          {destacados.map((destacado, index) => (
            <li key={index} className="list-group-item">
              <div className="row">
                <div className="col-3">
                  <img src={destacado.imgURL} alt={destacado.title} />
                </div>
                <div className="col-9">
                  <a href={destacado.url} target="_blank" rel="noopener noreferrer">
                    <h6>{destacado.title}</h6>
                  </a>
                  <p>{destacado.type}</p>
                </div>
              </div>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default SidebarDestacados;