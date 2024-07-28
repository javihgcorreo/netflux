//file: src/components/Sidebar.js
import React from 'react';

class Sidebar extends React.Component {
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
        /*let response = await fetch('http:/localhost:8081/api/destacados');//http:/localhost:8081/api/destacados
        console.log('Esperando datos de Sidebar');
        let json = await response.json();
        console.log(json);*/
        //this.setState({destacados: json});
    }



    render() {
        console.log('voy a renderizar Sidebar');

        let destacados = <div>hola</div>
        /*let myhtml = <h1></h1>;*/
        /*if (this.state.destacados) { //suponemos que destacados es un objeto
            destacados = this.state.destacados.map(item => (
                <div className="row">
                    <div className="col-2">
                        <img src="img/peliDejateQuerer_1.jpg" alt="Película Dejate querer" />
                    </div>
                    <div className="col-lg-10">
                        <h6>{item.title}hola</h6>
                    </div>
                </div>
            ));//
        }*/
        return (
            <div id="mostrador" className="col-lg-4">
                
                <h4>Destacados</h4>
                <ul className="list-group">
                    <li className="list-group-item">
                            {destacados}
                    </li>
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

export default Sidebar;