window.addEventListener('DOMContentLoaded', event => {
    const notify = document.querySelector('#news');
    const btn = document.querySelector('#numbers');

    notify.addEventListener('click', event => {
        btn.setAttribute('data-badge', 0 );
    });

    $("#news").popover({
        'title': 'Notificaciones',
        'html': true,
        'placement': 'bottom',
        'content': $(".alert_list").html()
    });

    $('.turn_off_alert').live('click', function (event) {
        console.log("click");
        var alert = $(this).parent();
        var alert_id = alert.data("alert_id");
        alert.hide("fast");

    })

});


