import React, { Component } from 'react';
import SidebarDestacados from './SidebarDestacados';
import SidebarTrailers from './SidebarTrailers';

class Sidebar extends Component {
  constructor(props) {
    super(props);
    this.state = {
      // Si necesitas algún estado adicional para el Sidebar, decláralo aquí
    };
  }

  render() {
    return (
      <div id="mostrador" className="col-lg-4">
        <SidebarDestacados />
        <SidebarTrailers />
      </div>
    );
  }
}

export default Sidebar;

