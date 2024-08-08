import React, { Component } from 'react';

class SidebarTrailers extends Component {
  constructor(props) {
    super(props);
    this.state = {
      trailers: [],
    };
  }

  componentDidMount() {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8081/api/trailers');
        const data = await response.json();
        this.setState({ trailers: data });
      } catch (error) {
        console.error('Error al obtener datos:', error);
      }
    };

    fetchData();
  }

  render() {
    const { trailers } = this.state;

    return (
      <div id="trailers">
        <h4>Trailers</h4>
        <ul className="list-group">
          {trailers.map((trailer, index) => (
            <li key={index} className="list-group-item">
              <div className="row">
                <div className="col-3">
                  <img src={trailer.imgURL} alt={trailer.title} />
                </div>
                <div className="col-9">
                  <a href={trailer.url} target="_blank" rel="noopener noreferrer">
                    <h6>{trailer.title}</h6>
                  </a>
                  <p>{trailer.type}</p>
                </div>
              </div>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default SidebarTrailers;