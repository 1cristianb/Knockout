/* Script de la db */

USE db;

INSERT INTO personaje(nombre, imagen,intercambiable, descripcion, enVenta, enMiColeccion, monto, ataque, defensa)
VALUES
('Iron Man', 'ironMan.jpg',false,
'Más conocido como Tony Stark, es un multimillonario magnate empresarial, filántropo, playboy e ingenioso científico' ,true, false, 10000.00, 700, 600),
('Thor', 'thor_.jpg',false, 'Dios del trueno y fuerza en la mitología nórdica y germánica' ,true, false, 10500.50, 850, 800),
('Valkiria', 'valkiria_.jpg',false,
'Conocida por su destreza en la batalla, a menudo se acompaña de su caballo alado Aragorn y lleva la espada encantada Dragonfang' ,true, false, 5000.0, 500, 350),
('Capitán América', 'capitanAmerica.jpg',false,
'Cuyo nombre real es Steven Grant Rogers, es un super soldado de los Estados Unidos de América' ,true, false, 8600.75, 700, 600),
('Capitana Marvel', 'capitanaMarvel.jpg',false,
'Cuyo nombre real es Carol Danvers, después de que su ADN se fusionara con el de Mar-Vell, obtiene poderes sobrehumanos' ,true, false, 9875.58, 1000, 850),
('Black Widow','blackWidow.jpg',false,
'Experta espía y combatiente cuerpo a cuerpo. Convocada por Nick Fury, es miembro fundador de la Iniciativa Vengadores.' ,true, false, 10000.00, 500, 500),
('Hawkeye', 'hawkeye_.jpg',false,
'Su nombre real es Clint Barton. Tirador experto y un combatiente cuerpo a cuerpo, siendo su arma preferida es un arco recurvo.' ,true, false, 5000.75, 450, 500),
('Hulk', 'hulk_.jpg',false,
'Ser humanoide enorme de piel verde, corpulento y musculoso que posee una gran fortaleza física.' ,true, false, 5000.80, 1500, 980),
('Kate Bishop', 'kateBishop.jpg',false,
 'Miembro de los Jóvenes Vengadores. Tomar el nombre del Ojo de Halcón (Hawkeye) después de Clint Barton' ,true, false, 1000.20, 200, 350),
('Lady Thor', 'ladyThor.jpg',false,
'Cuyo nombre es Jane Foster, científica astrofísica. Al hacerse con la legendaria arma llamada Mjölnir, obtiene los poderes de Thor' ,true, false, 7800.00, 670, 700),
('Star Lord', 'starLord.jpg',false,
'Híbrido Celestial-humano, legendario forajido, líder de Los Guardianes de la Galaxia.' ,true, false, 8900.25, 640, 400),
('Ultron', 'ultron_.jpg',false, 'Inteligencia artificial que trata de eliminar a los superheroes.' ,true, false, 6000.0, 900, 910),
('Venom', 'venom_.jpg',false,
'Simbionte con una forma amorfa, semi-líquido, que sobrevive mediante la unión con un huésped, por lo general humano.' ,true, false, 7460.23, 657, 434),
('Black Panther', 'blackPanther.jpg',false,
'Rey y protector de Wakanda, poseer habilidades mejoradas logradas a través de rituales antiguos de Wakanda.' ,true, false, 9000.00, 580, 600),
('Doctor Strange', 'doctorStrange.jpg',false,
'Poderoso hechicero y miembro destacado de los Maestros de las Artes Místicas.' ,true, false, 12500.00, 720, 830),
('Loki','loki_.jpg',false,
'Dios de las Mentiras, Prínciper de Asgard, hermano de Thor' ,true, false, 8500.78, 530, 500),
('Scarlet Witch', 'scarletWitch.jpg',false,
'Posee habilidades para alterar la realidad de formas no especificadas y es, además, una poderosa hechicera.' ,true, false, 15500.00, 1200, 1210),
('Shang-Chi', 'shangChi.jpg',false,
'Maestro de artes marciales con habilidades insuperables por muchos, heredero de los Anillos Místicos.' ,true, false, 9000.00, 886, 880),
('Deadpool', 'deadpool_.jpg',false,
'Mercenario y antiheroe, mentalmente inestable y desfigurado' ,true, false, 14000.00, 890, 1300),
('Duende Verde', 'duendeVerde.jpg',false,
'Supervillano con temática de Halloween cuyas armas se asemejan a murciélagos, fantasmas y linternas de calabaza. Es estrambótico, bocazas y políticamente incorrecto.' ,true, false, 4000.00, 740, 500);


-- insert leandro--

insert into personaje(nombre,imagen,intercambiable,descripcion,enVenta, enMiColeccion, monto, ataque, defensa)
values('Ermac','ermac.jpg',false,
       'Ermac es una entidad compuesta de legiones de almas de los muertos, que se enviaron a guerras sin sentido, la manera en que las almas fueron fusionados en Ermac es desconocida.',true,false,5000.00, 500, 510),
      ('Johnny Cage','johnny_.jpg',false,
       'Una superestrella de las artes marciales entrenado por grandes maestros de todo el mundo.',true,false,8000.00, 560, 430),
      ('Kitana','kitana_.jpg',false,
       'Princesa del místico reino de Edenia,el arma de Kitana es un par de abanicos de acero con puntas afiladas',true,false,8500.00, 590, 490),
      ('Liu Kang','liukang_.jpg',false,
       'Liu Kang sigue las enseñanzas de la Sociedad del Loto Blanco del Shaolin y fue enviado por el Templo de la Luz a derrotar al hechicero Shang Tsung.',true,false,9000.00, 830, 870),
      ('Mileena','milena_.jpg',false,
       ' Mileena es un clon de Kitana. Su odio hacia Kitana consume sus pensamientos; desea matarla para tomar el trono de Edenia.',true,false,5600.00, 584, 500),
      ('Reptile','reptile.jpg',false,
       'Un general del ejército de la oscuridad de Shinnok, Reptile pertenece a una raza extinta de criaturas reptilianas. Fue desterrado al Netherrealm acusado del genocidio contra su propia especie.',true,false,8300.00, 500, 500),
      ('Scorpion','scorpion.jpg',false,'Espectro Ninja no muerto que busca venganza por su propia muerte a manos de Sub-Zero.',true,false,10000.00, 1000, 990),
      ('Shang Tsung','shang_.jpg',false,'Es un poderoso hechicero con la capacidad de absorber almas y cambiar de forma. Bajo el mando de Shao Kahn buscara conquistar la tierra.',true,false,9200.00, 579, 560),
      ('Shao Kahn','sk.jpg',false,'Emperador del Reino del Outworld.Lo conocen por su divina fuerza, la insensibilidad, extrema brutalidad y su afición por las ejecuciones personales, intentara conquistar la tierra mandando a Shang Tsung.',true,false,12000.00, 500, 480),
      ('Sonya Blade','sonya_.jpg',false,'miembro de una unidad superior de las Fuerzas Especiales de los Estados Unidos. Sonya representa a una mujer muy emancipada y testaruda, con obstinación y orgullo, ella se preocupa por las vidas de sus amigos y compañeros.',true,false,7900.00, 760, 600),
      ('Sub-Zero','sub.jpg',false,'Un asesino del clan Lin Kuei. Que asumió el mando, cuando su hermano fue asesinado por el espectro ninja Scorpion en el mismo torneo de Mortal Kombat',true,false,10000.0, 1000, 986),
      ('Kung Lao','kunglao.jpg',false,'Monje Shaolin y un miembro de la Sociedad del Loto Blanco que se encuentra a la sombra de su antepasado. Kung Lao es el mejor amigo de Liu Kang.',true,false,98000.0, 840, 600);

-- Insert superheroes DC--

insert into personaje(nombre,imagen,intercambiable,descripcion,enVenta, enMiColeccion, monto, ataque, defensa)
values('Superman','superman_.jpg',false,'Superheroe nacido en el planeta de Krypton.Sus poderes provienen de la absorción solar,entre ellos se encuentran: super fuerza,super velocidad,factor curativo,volar,visión de rayos X,etc. ',true,false,15000.0, 1200, 1000),
      ('Aquaman','aquaman_.jpg',false,'Rey de Atlantis,forma parte de la Liga de La Justicia.Tiene control de los mares y criaturas marinas.Posee super fuerza y resistencia. ',true,false,8500.0, 840, 700),
      ('Batman','batman_.jpg',false,' Millonario que por las noches se convierte en un justiciero.Tiene una basta experiencia en multiples artes marciales.Cuenta con una inteligencia superior',true,false,10000.0, 620, 600),
      ('Black Adam','blackAdam_.jpg',false,' Black Adam es un antiguo egipcio llamado Teth-Adam (es decir, "Poderoso humano"), que es elegido por el mago Shazam para ser su sucesor debido a su presunta pureza moral. ',true,false,10500.0, 937, 900),
      ('Brainiac','brainiac_.jpg',false,'Es un villano humanoide de piel verde.Posee poderes telepáticos y psicoquinéticos cuyos límites se desconocen ',true,false,12300.0, 993, 800),
      ('Deadshot','deadshot_.jpg',false,'Floyd Lawton, más conocido como Deadshot, es un pistolero a sueldo, conocido por ser el segundo asesino más letal de todo el universo de DC Comics',true,false,8500.0, 840, 800),
      ('Flash','flash_.jpg',false,'Superheroe integrante de La Liga de La Justicia.Posee super velocidad,puede atravesar las paredes ,lanzar rayos y hasta viajar en el tiempo.',true,false,12000.0, 500, 600),
      ('Lex Luthor','lexLuthor_.jpg',false,'Alexander J. Luthor, conocido simplemente como Lex Luthor, es un supervillano y el archienemigo de Superman.Es un millonario con una gran inteligencia. ',true,false,10200.0, 500, 340),
      ('Mujer Maravilla','mujerMaravilla_.jpg',false,'Princesa guerrera de las Amazonas.Forma parte de La Liga de La Justicia.',true,false,11000.0, 1010, 978),
      ('Deadthstroke','deadthstroke_.jpg',false,'Mercenario y villano, mentalmente inestable y con una gran habilidad en el manejo de las espadas ',true,false,7500.0, 530, 500);

INSERT INTO usuario(activo,email,habilitado,password,rol,ultimaConexion,nivel_id)
values (1,'test@gmail.com',1,'123',0,null,null);

INSERT INTO comic(pdf, portada, titulo)
VALUES
('1_Civil_War_1.pdf', 'Civil_War_1_page-0001.jpg','Civil War #1'),
('2_SheHulk_8.pdf', 'She-Hulk_8_page-0001.jpg', 'She-Hulk #8'),
('3_Wolverine_42.pdf', 'Wolverine_42_page-0001.jpg', 'Wolverine #42'),
('4_Amazing_SpiderMan_532.pdf', 'Amazing_Spider-Man_532_page-0001.jpg', 'Amazing Spider-Man #532'),
('5_Civil_War_Front_Line_1.pdf', 'Civil War Front Line_1_page-0001.jpg', 'Civil War Front Line #1'),
('6_Civil_War_2.pdf', 'Civil_War_2_page-0001.jpg', 'Civil War #2'),
('7_Thunderbolts_103.pdf', 'Thunderbolts_103_page-0001.jpg', 'Thunderbolts #103'),
('Moon_Knight_Vol_6_1_7.pdf', 'Moon Knight Vol 6 1-7_page-0001.jpg', 'Moon Knight'),
('Nova_Vol_6_01.pdf', 'Nova - Vol. 6 - 01 - All-New, All-Different Marvel_page-0001.jpg', 'Nova - Vol. 6 - #01'),
('Nova_Vol_6_02.pdf', 'Nova - Vol. 6 - 02 - All-New, All-Different Marvel_page-0001.jpg', 'Nova - Vol. 6 - #02');



