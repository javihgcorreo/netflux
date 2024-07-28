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
      const response = await fetch(`${this.baseUrl}/peliculas/novedades`);
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

  /*funciones para imprimir codigo embebido en en html*/
  async function introPeliculasNuevasEnDOMpaginaHtml () {
    const library = new MediaLibrary('/api');

    const movies = await library.loadMovies();

    const divDetalles = document.getElementById("pelisNuevas");

    divDetalles.innerHTML =`<div class="row"><h3>Nuevas Pel&iacute;culas</h3></div>
    `;
      for (const pelicula of movies) {
        //const li = document.createElement("li");
        //li.textContent = pelicula.title;
        /*li.addEventListener("click", async function() {
            // Cargar los detalles de la película
            //cargarDetallesPelicula(pelicula.id);
            movieDetail = await library.loadMovieDetails(pelicula.id);
            console.log(movieDetail);
            cargarDetallesPelicula(movieDetail[0]);
        });
        listaPeliculas.appendChild(li);*/
        console.log(pelicula.title+", "+pelicula.url+", "+pelicula.imgUrl);

        divDetalles.innerHTML = divDetalles.innerHTML+`
          <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="thumbnail">
                  <img src="${pelicula.imgUrl}" alt="Pel&iacute;cula ${pelicula.title}" onerror="mostrarCuadroTamaño(this)">
                  <div class="caption">
                      <h3><a href="segunda_pagina.html?id=${pelicula.id}">${pelicula.title}</a></h3>
                  </div>
              </div>
          </div>
        `;

      }
      divDetalles.innerHTML = divDetalles.innerHTML+`<div><!--end div row de nodo pelicula row-->
      `;
   }

   async function introSeriesNuevasEnDOMpaginaHtml () {
    const library = new MediaLibrary('/api');

    const series = await library.loadSeries();

    const divDetalles = document.getElementById("seriesNuevas");

    divDetalles.innerHTML =`<div class="row"><h3>Nuevas Series</h3></div>
    `;
      for (const serie of series) {

        console.log(serie.title+", "+serie.url+", "+serie.imgUrl);

        divDetalles.innerHTML = divDetalles.innerHTML+`
          <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="thumbnail">
                  <img src="${serie.imgUrl}" alt="Pel&iacute;cula ${serie.title}"  onerror="mostrarCuadroTamaño(this)">
                  <div class="caption">
                      <h3><a href="segunda_pagina.html">${serie.title}</a></h3>
                  </div>
              </div>
          </div>
        `;

      }
      divDetalles.innerHTML = divDetalles.innerHTML+`<div><!--end div row de nodo serie row-->
      `;
   }

   async function introDestacadosTrailersEnDOMpaginaHtml () {
    const library = new MediaLibrary('/api');

    const destacados = await library.loadFeatured();
    const trailers = await library.loadFeatured();

    const divDetalles = document.getElementById("mostrador");

    divDetalles.innerHTML =`<h4>Destacados</h4>
          <ul class="list-group">
    `;
      for (const destacado of destacados) {

        console.log(destacado.title+", "+destacado.url+", "+destacado.imgUrl);

        divDetalles.innerHTML = divDetalles.innerHTML+`
          <li class="list-group-item">
              <div class="row">
                  <div class="col-2">
                      <img src="${destacado.imgUrl}" alt="${destacado.title}" onerror="mostrarCuadroTamaño(this)">
                  </div>
                  <div class="col-lg-10">
                      <h6>${destacado.title}</h6>
                  </div>
              </div>
          </li>
        `;

      }
      divDetalles.innerHTML = divDetalles.innerHTML+`</ul><!--end ul lista destacados-->
      `;

      divDetalles.innerHTML = divDetalles.innerHTML+`<h4>Trailers</h4>
          <ul class="list-group">
    `;
      for (const trailer of trailers) {

        console.log(trailer.title+", "+trailer.url+", "+trailer.imgUrl);

        divDetalles.innerHTML = divDetalles.innerHTML+`
          <li class="list-group-item">
              <div class="row">
                  <div class="col-2">
                      <img src="${trailer.imgUrl}" alt="${trailer.title}" onerror="mostrarCuadroTamaño(this)">
                  </div>
                  <div class="col-lg-10">
                      <h6>${trailer.title}</h6>
                  </div>
              </div>
          </li>
        `;

      }
      divDetalles.innerHTML = divDetalles.innerHTML+`</ul><!--end ul lista trailer-->
      `;
   }

   function mostrarCuadroTamaño(img) {
    // Obtener el padre del elemento img
    const parent = img.parentNode;

    // Crear un nuevo elemento div para el cuadro
    const cuadro = document.createElement('div');
    cuadro.classList.add('alert', 'alert-warning'); // Utilizamos clases de Bootstrap

    // Crear un icono (opcional)
    const icono = document.createElement('i');
    icono.classList.add('bi-exclamation-triangle-fill'); // Icono de Bootstrap

    // Crear un elemento p para mostrar el tamaño
    const tamaño = document.createElement('p');
    tamaño.textContent = `Tamaño esperado: ${img.naturalWidth}x${img.naturalHeight} px`;

    // Agregar el icono y el tamaño al cuadro
    cuadro.appendChild(icono);
    cuadro.appendChild(tamaño);

    // Reemplazar la imagen con el cuadro
    parent.replaceChild(cuadro, img);
}