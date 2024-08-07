let preguntas_aleatorias = true;
let mostrar_pantalla_juego_términado = true;
let reiniciar_puntos_al_reiniciar_el_juego = true;

let  preguntas=[

    {
        "categoria": "Cine",
        "pregunta": "¿Quién es el villano de Avengers Infinity war?",
        "respuesta": "Thanos",
        "incorrecta1": "Magneto",
        "incorrecta2": "El duende verde",
        "incorrecta3": "Electro\r"
    },
    {
        "categoria": "Comics",
        "pregunta": "¿En qué número hizo Spiderman su primer aparición?",
        "respuesta": "Amazing Fantasy #15",
        "incorrecta1": "Amazing Spiderman #1",
        "incorrecta2": "Amazing Spiderman #1",
        "incorrecta3": "Amazing Fantasy #17\r"
    },
    {
        "categoria": "Cine",
        "pregunta": "¿Cómo se llama el director de Batman VS Superman?",
        "respuesta": "Zack snyder",
        "incorrecta1": "Kevin Feige",
        "incorrecta2": "Robert De niro",
        "incorrecta3": "Victoria Alonso\r"
    },
    {
        "categoria": "Cine",
        "pregunta": "¿Cuántas peliculas tiene iron man?",
        "respuesta": "3",
        "incorrecta1": "2",
        "incorrecta2": "1",
        "incorrecta3": "Ninguna\r"
    },
    {
        "categoria": "Comics",
        "pregunta": "¿En qué comic apareció Batman?",
        "respuesta": "Detective Comics #27",
        "incorrecta1": "Detective Comics #25",
        "incorrecta2": "Batman #1",
        "incorrecta3": "Justice League #1\r"
    },
    {
        "categoria": "Cine",
        "pregunta": "¿Cómo se llama el actor que interpreta a Superman?",
        "respuesta": "Henry Cavill",
        "incorrecta1": "Ben Afleck",
        "incorrecta2": "Ryan Reynolds",
        "incorrecta3": "Robert Downey Jr\r"
    },
    {
        "categoria": "Marvel",
        "pregunta": " ¿Cómo se llama el martillo de Thor?",
        "respuesta": "Mjolnir",
        "incorrecta1": "Aesir",
        "incorrecta2": "Vanir",
        "incorrecta3": "Norn\r"
    },
    {
        "categoria": "Marvel",
        "pregunta": " ¿De qué está hecho el escudo del Capitán América?",
        "respuesta": "Vibranio",
        "incorrecta1": "Adamantium",
        "incorrecta2": "prometeo",
        "incorrecta3": "Carbonadio\r"
    },
    {
        "categoria": "Cine",
        "pregunta": " Un famoso director de estilo muy particular dirigió dos películas de Batman en los años 90, ¿de quién hablamos?",
        "respuesta": "Tim Burton",
        "incorrecta1": "Martin Scorsese",
        "incorrecta2": "Steven Spielberg",
        "incorrecta3": "Quentin Trantino\r"
    }
]


window.onload = function() {
    escogerPreguntaAleatoria();
};

let pregunta;
let posibles_respuestas;
btn_correspondiente = [
    select_id("btn1"),
    select_id("btn2"),
    select_id("btn3"),
    select_id("btn4")
];

let preguntas_hechas = 0;
let preguntas_correctas = 0;
let total_preguntas = 0;
let contador = 0;

function escogerPreguntaAleatoria() {
    let n;
    if (preguntas_aleatorias) {
        n = Math.floor(Math.random() * preguntas.length);
    } else {
        n = 0;
    }

    if (contador == 4) {

        if (mostrar_pantalla_juego_términado) {
            swal.fire({
                title: "Juego finalizado",
                text: "Puntuación: " + preguntas_correctas + "/" + (preguntas_hechas),
                icon: 'success',
                confirmButtonText: '<a href="triviaCheck?p=' + preguntas_correctas + '" style="text-decoration:none;color:white">Aceptar</a>',
            });
        }

    }
    preguntas_hechas++;
    total_preguntas++;
    contador++;
    escogerPregunta(n);
    preguntas.splice(n,1);
}

function escogerPregunta(n) {
    pregunta = preguntas[n];
    select_id("categoria").innerHTML = pregunta.categoria;
    select_id("pregunta").innerHTML = pregunta.pregunta;
    select_id("numero").innerHTML = n;
    let pc = preguntas_correctas;
    if (preguntas_hechas > 1) {
        select_id("puntaje").innerHTML = pc + "/" + (preguntas_hechas - 1);
    } else {
        select_id("puntaje").innerHTML = "";
    }

    desordenarRespuestas(pregunta);

}

function desordenarRespuestas(pregunta) {
    posibles_respuestas = [
        pregunta.respuesta,
        pregunta.incorrecta1,
        pregunta.incorrecta2,
        pregunta.incorrecta3,
    ];
    posibles_respuestas.sort(() => Math.random() - 0.5);

    select_id("btn1").innerHTML = posibles_respuestas[0];
    select_id("btn2").innerHTML = posibles_respuestas[1];
    select_id("btn3").innerHTML = posibles_respuestas[2];
    select_id("btn4").innerHTML = posibles_respuestas[3];
}

let suspender_botones = false;

function oprimir_btn(i) {
    if (suspender_botones) {
        return;
    }
    suspender_botones = true;
    if (posibles_respuestas[i] == pregunta.respuesta) {
        preguntas_correctas++;
        btn_correspondiente[i].style.background = "lightgreen";
    } else {
        btn_correspondiente[i].style.background = "pink";
    }
    for (let j = 0; j < 4; j++) {
        if (posibles_respuestas[j] == pregunta.respuesta) {
            btn_correspondiente[j].style.background = "lightgreen";
            break;
        }
    }
    setTimeout(() => {
        reiniciar();
        suspender_botones = false;
    }, 3000);
}

function reiniciar() {
    for (const btn of btn_correspondiente) {
        btn.style.background = "white";
    }
    escogerPreguntaAleatoria();
}

function select_id(id) {
    return document.getElementById(id);
}

function style(id) {
    return select_id(id).style;
}

