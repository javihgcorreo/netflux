import React, { Component, useState, useEffect } from 'react';

class PeliculasNovedosas extends Component {
  constructor(props) {
    super(props);
    this.state = {
      novedades: [],
    };
  }

  componentDidMount() {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8081/api/peliculas/novedades');
        const data = await response.json();
        this.setState({ novedades: data });
      } catch (error) {
        console.error('Error al obtener datos:', error);
      }
    };

    fetchData();
  }

  render() {
    const { novedades } = this.state;

    return (
      <div id="novedades">
      <h4>Nuevas Pel&iacute;culas</h4>
    
      <div className="row">
       
        {novedades.map((novedad, index) => (
            <div key={index} className="col-lg-3 col-md-6 col-sm-6">
              <div className="thumbnail">
                  <img src={novedad.imgURL} alt={novedad.title} />
                <div className="col-9">
                  <a href={novedad.url} target="_blank" rel="noopener noreferrer" title=''>
                    <h6>{novedad.title}</h6>
                  </a>
                  <p>{novedad.type}</p>
                </div>
              </div>
           </div>
          )
        )}
        
      </div>
      </div>
    );
  }
}


export default PeliculasNovedosas;