class MediaLibrary {
    constructor(baseUrl) {
      this.baseUrl = baseUrl;
    }
    //estos metodos se podrian parametrizar en un solo pasando cadena "/destacados" o cualquier otra
    //pero asi tambien te puede quedar más claro lo que estas encapsulando y los datos que pides
    async loadFeatured() {
      const response = await fetch(`${this.baseUrl}/destacados`);
      const featured = await response.json();
      return featured;
    }
  
    async loadMovies() {
      const response = await fetch(`${this.baseUrl}/peliculas`);
      const movies = await response.json();
      return movies;
    }
  
    async loadSeries() {
      const response = await fetch(`${this.baseUrl}/series`);
      const series = await response.json();
      return series;
    }
  
    async loadMovieDetails(id) {
      const response = await fetch(`${this.baseUrl}/peliculas/${id}`);
      const movie = await response.json();
      return movie;
    }
  
    async loadSeriesDetails(id) {
      const response = await fetch(`${this.baseUrl}/series/${id}`);
      const series = await response.json();
      return series;
    }
    

}

function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};

var peliculaSolicitada_id = getUrlParameter('id');

/*funciones para imprimir codigo embebido en en html*/
async function introPeliculaDetalleNuevasEnDOMpaginaHtml (id) {
    const library = new MediaLibrary('/api');
    const peliculaDetalles = await library.loadMovieDetails(id);
    //console.log(peliculasDetalles);
    const divDetallesTitulo = document.getElementById("titulo");
    const divDetallesPeliculaSelect = document.getElementById("peliculaSelect");
    const divDetallesPeliculaSelectReparto = document.getElementById("peliculaSelectReparto");

    console.log(peliculaDetalles[0]);

    divDetallesTitulo.innerHTML =`
        <div class="row">
            <div class="col-12"><h2>${peliculaDetalles[0].title}</h2></div>
            <div class="col-12"><h4>${peliculaDetalles[0].yearFilm}</h4></div>
            <hr class="separador">
            <div class="col-12"><button>Ver en NetFlux</button></div>
        </div>
    `;

    divDetallesPeliculaSelect.innerHTML =`
      <div class="col-4">
        <div>
            <img src="${peliculaDetalles[0].imgUrl}" alt="Pel&iacute;cula Dejate querer">
        </div>
      </div>
      <div class="col-8">
          <div class="row"><h3>${peliculaDetalles[0].title}</h3></div>
          <div class="row"><h6>A&ntilde;o ${peliculaDetalles[0].yearFilm}</h6></div>
          <div class="row"><h6>Duraci&oacute;n: </h6></div>
          <hr class="separador">
          <div class="row">
              <p>${peliculaDetalles[0].description}</p>
          </div>
      </div>
    `;

    divDetallesPeliculaSelectReparto.innerHTML =`
      <div class="row">
          <h4>Reparto del T&iacute;tulo</h4>
      </div>
      <div class="row">
          <div class="row"><h5>Creado por:</h5></div>
          <div class="row"><h6>Creadores de la serie o pel&iacute;cula</h6></div>
          <div class="row mt-2"><h6>Reparto:</h5></div>
      </div>
      <div class="row">
    `;

    for (const actor of peliculaDetalles[0].infocast) {

      divDetallesPeliculaSelectReparto.innerHTML = divDetallesPeliculaSelectReparto.innerHTML +`
            <div class="col-lg-4 col-md-6 col-sm-6">${actor.name}</div>
      `;
    }
    divDetallesPeliculaSelectReparto.innerHTML = divDetallesPeliculaSelectReparto.innerHTML +`
      </div>
    `;
}
