//file: src/components/Sidebar1.js
import React from 'react';

class Sidebar1 extends React.Component {
    constructor() {
        super();
        this.state = {
            destacados: null
        }
    }

    componentDidMount() {
        this.loadData();
    }

    async loadData() {
        console.log('Recuperar datos de Sidebar');
        /*aqui no responde json se queda esperando y nunca responde*/let response = await fetch('http:/localhost:8081/api/peliculas');//http:/localhost:8081/api/destacados
        console.log('Esperando datos de Sidebar ');
        let json = await response.json();
        console.log(json);
        this.setState({destacados: json});
    }



    render() {
        let destacados = <div></div>
        if (this.state.destacados) {
            <li className="list-group-item">
                <div className="row">
                    <div className="col-2">
                        <img src="img/peliDejateQuerer_1.jpg" alt="Película Dejate querer" />
                    </div>
                    <div className="col-lg-10">
                        <h6>D&eacutejate querer</h6>
                    </div>
                </div>
            </li>
        }
        return (
            <div id="mostrador" className="col-lg-4">
                
                <h4>Destacados</h4>
                <ul className="list-group">
                    {destacados}
                </ul>

                <h4>Trailers</h4>
                <ul className="list-group">
                    <li className="list-group-item">
                        <div className="row">
                            <div className="col-2">
                                <img src="img/peliDejateQuerer_1.jpg" alt="Película Dejate querer" />
                            </div>
                            <div className="col-lg-10">
                                <h6>D&eacutejate querer</h6>
                            </div>
                        </div>
                    </li>
                </ul>
                
                
            </div>
        );

       
    }
}

export default Sidebar1;