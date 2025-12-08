# GestionadordeInventarioTecmilenioCum
# Resumen Ejecutivo
-Descripcion: Esta es una aplicacion de escritorio desarollada en Java Swing su funcion principal es servir como un sistema de inventario para Tiendas, disenada para permitir el registro, edicion, eliminacion y consulta de productos mediante una interfaz sencilla y eficiente. Los datos del inventario no se guardan dentro de una base de datos, decidi que para esta aplicacion se guardarian localmente dentro de un archivo .TXT, permitiendo la simplicidad de uso para todos los usuarios.

-Problema identificado: En muchas tiendas pequenas suelen gestionar su inventario en libreta o a veces contando a diario, ya sea por el costo de un sistema empresarial o falta de conocimiento tecnico, es por eso que se creo este Gestionador de inventario haciendolo simple, sin complicacion de instalacion, portable y mejor de todo gratis para todo usuario.

-Solucion: Esta aplicacion es la solucion que encontre para las tiendas pequenas que no tienen los recursos o el conocimiento tecnico, esta aplicacion ofrece Gestionar productos (agregar, editar y eliminar), manejo de inventario atraves de una tabla visual, estados de productos segun la cantidad de Stock (buena cantidad, inventario bajo, conseguir mas) con el estado siendo escogido por el usuario, guardado de datos atravez de un archivo/documento .TXT, seguridad atravez de Login y un menu principal bastante sencillo de utilizar.

-Arquitectura: Esta aplicacion tiene como estructura 3 capas para su funcionamiento de forma correcta.
Capa Visual: dentro se encuentran clases como LoginFrame, MenuPrincipal, InventarioFrame, AgregarProductoFrame y EditarProductoFrame.
Capa Logica: esta Tiene las dos clases Inventario y Producto.
Capa de Datos: esta es la ultima capa, es si esta aplicacion no esta vinculada a una base de datos, decidi hacerlo un poco mas simple y hacerla que tuviera un guardado de datos local a base de un .TXT y aqui es donde entra ese archivo, aqui entra Inventario.txt.
