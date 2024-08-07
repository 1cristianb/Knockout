document.addEventListener('DOMContentLoaded', () => {
    ShowSelected();
    });

function ShowSelected(){

            if(window.location == 'http://localhost:8080/KnockOut_war_exploded/comprarPersonaje?order=min'){

            var option = document.querySelector('option[value="min"]' );


            option.setAttribute('selected','true')
            }


            if(window.location == 'http://localhost:8080/KnockOut_war_exploded/comprarPersonaje?order=max'){

                    var option = document.querySelector('option[value="max"]' );


                    option.setAttribute('selected','true')
            }

            if(window.location == 'http://localhost:8080/KnockOut_war_exploded/comprarPersonaje?order=name'){

            var option = document.querySelector('option[value="name"]' );

             option.setAttribute('selected','true')
    }

    }
