window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
    var x = document.getElementsByClassName('dataTable-dropdown');

    for (var i = 0; i < x.length; i++) {
        x[i].style.display= "none";
    }

    document.getElementsByClassName('dataTable-input')[0].placeholder="Buscar";
    document.getElementsByClassName('dataTable-info')[0].style.display="none";

});