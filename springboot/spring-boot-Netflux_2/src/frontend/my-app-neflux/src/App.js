//file: src/App.js
import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import Greeting from './components/Greeting';
import Sidebar from './components/Sidebar';
import Sidebar1 from './components/Sidebar1';

function App() {
  return (
  <div className='container'>
    <div className="container">
        
        <div className="container-fluid">
          <div className="div-con-contenido">
                  <div className="col-lg-1">
                      <a className="navbar-brand" href="#"><img src="img/iconNetflux.png" className="img-fluid max-width-30px d-block" alt="Logo" /></a>
                  </div>
                  <div className="col-lg-4">
                      <h1>NetFlux Catalog</h1>
                  </div>
          </div>
          <div className="div-con-contenido">
              <div className="row">
                  <nav className="navbar navbar-expand-lg navbar-light bg-light">
                  
                      <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                          <span className="navbar-toggler-icon"></span>
                      </button>
                      <div className="collapse navbar-collapse" id="navbarNav">
                          <ul className="navbar-nav ml-auto">
                              <li className="nav-item active">
                                  <a className="nav-link" href="#">Inicio</a>
                              </li>
                              <li className="nav-item">
                                  <a className="nav-link" href="#">Películas</a>
                              </li>
                              <li className="nav-item">
                                  <a className="nav-link" href="#">Televisión</a>
                              </li>
                              <li className="nav-item">
                                  <a className="nav-link" href="#">Documentales</a>
                              </li>
                              <li className="nav-item">
                                  <a className="nav-link" href="#">Recomendaciones</a>
                              </li>
                              <li className="nav-item">
                                  <a className="nav-link" href="#">Trailers</a>
                              </li>
                          </ul>
                      </div>
                  
                  </nav>
              </div>
          </div>
      </div>
    </div>

    <div className="container mt-4">
        <div id="novedades" className="row">
            <h2>Novedades del c&aacute;talogo de NetFlux</h2>
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor odio dolorem tenetur eos aliquam iusto, voluptatem rerum laborum corporis, neque totam hic! Numquam officiis dicta esse dolorum ipsam maiores nostrum!</p>
        </div>
        <div id="cuerpo_productos" className="row mt-4">
            <div id="productos" className="col-lg-8">
                <div id="pelisNuevas" className="row">
                  <p>peliculas nuevas</p>
                </div>
                <div id="seriesNuevas" className="row">
                   <p>series nuevas</p>
                </div>
            </div>

            <Sidebar1 />

        </div>
    </div>

    <footer className="footer">
        <div className="container">
            <p>&copy; 2023 NetFlux Company Right</p>
        </div>
    </footer>
    
  </div>
  );
}

export default App;
