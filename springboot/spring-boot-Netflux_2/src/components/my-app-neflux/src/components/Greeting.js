//file: src/components/Greeting.js
import React from 'react';

class Greeting extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: null
        }
    }

    componentDidMount() {
        this.loadData();
    }

    async loadData() {
        let response = await fetch('url');
        let json = await response.json();
        this.setState({data: json});
    }

    render() {
        let myhtml = <h1></h1>;
        if (this.state.data) //suponemos que data es un objeto
            myhtml = <h1>{this.state.data.titulo}</h1>
        return (
        <h1>{this.props.message}</h1>
        );
    }
}

export default Greeting;