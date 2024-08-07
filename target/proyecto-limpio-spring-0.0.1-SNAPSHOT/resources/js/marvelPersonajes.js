const marvel = {
    render: () => {
        const urlAPI = 'https://gateway.marvel.com/v1/public/characters?ts=1&apikey=d32ee2d8560aa7a891a57f003db572de&hash=670c3c3c5a506ad6fac3c5f674528638';
        const container = document.querySelector('#marvel-row');
        let contentHTML = '';

        fetch(urlAPI)
            .then(res => res.json())
            .then((json) => {
                for (const hero of json.data.results) {
                    let urlHero = hero.urls[0].url;
                    contentHTML += `
            <div class="col-md-4">
                <a href="${urlHero}" target="_blank">
                  <img src="${hero.thumbnail.path}.${hero.thumbnail.extension}" alt="${hero.name}" class="img-thumbnail">
                </a>
                <h3 class="title">${hero.name}</h3>
            </div>`;
                }
                container.innerHTML = contentHTML;
            })
    }
};
marvel.render();