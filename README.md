# GestionadordeInventarioTecmilenioCum
# Resumen Ejecutivo
-Descripcion: Esta es una aplicacion de escritorio desarollada en Java Swing su funcion principal es servir como un sistema de inventario para Tiendas, disenada para permitir el registro, edicion, eliminacion y consulta de productos mediante una interfaz sencilla y eficiente. Los datos del inventario no se guardan dentro de una base de datos, decidi que para esta aplicacion se guardarian localmente dentro de un archivo .TXT, permitiendo la simplicidad de uso para todos los usuarios.

-Problema identificado: En muchas tiendas pequenas suelen gestionar su inventario en libreta o a veces contando a diario, ya sea por el costo de un sistema empresarial o falta de conocimiento tecnico, es por eso que se creo este Gestionador de inventario haciendolo simple, sin complicacion de instalacion, portable y mejor de todo gratis para todo usuario.

-Solucion: Esta aplicacion es la solucion que encontre para las tiendas pequenas que no tienen los recursos o el conocimiento tecnico, esta aplicacion ofrece Gestionar productos (agregar, editar y eliminar), manejo de inventario atraves de una tabla visual, estados de productos segun la cantidad de Stock (buena cantidad, inventario bajo, conseguir mas) con el estado siendo escogido por el usuario, guardado de datos atravez de un archivo/documento .TXT, seguridad atravez de Login y un menu principal bastante sencillo de utilizar.

-Arquitectura: Esta aplicacion tiene como estructura 3 capas para su funcionamiento de forma correcta.
Capa Visual: dentro se encuentran clases como LoginFrame, MenuPrincipal, InventarioFrame, AgregarProductoFrame y EditarProductoFrame.
Capa Logica: esta Tiene las dos clases Inventario y Producto.
Capa de Datos: esta es la ultima capa, es si esta aplicacion no esta vinculada a una base de datos, decidi hacerlo un poco mas simple y hacerla que tuviera un guardado de datos local a base de un .TXT y aqui es donde entra ese archivo, aqui entra Inventario.txt.

# Requerimientos
-Servidores: Esta aplicacion en si no utiliza servidores/base de datos, todos se ejecuta localmente (se utiliza un .txt para guardar los datos introducidos).

-Paquetes adicionales: Esta aplicacion utiliza unicamente: Java Swing y IO estandar de Java para los archivos.

-Version de Java: se recomienda Java JDK 17 o Superior.

# Instalacion
-Como instalar el Ambiente de Desarollo?: 
1.-Primero Descargar e instalar NetBeans y asegurar de tener Java JDK 17+
2.-Clonar el repositorio: git clone https://github.com/CalebAguilar007/GestionadordeInventarioTecmilenioCum.git
3.-Abrir el proyecto en NetBeans.

-Ejecutar Pruebas manualmente: a continuacion mostrare los pasos de como ejecutar pruebas manualmente.
1.- una vez hayas instalado el proyecto/aplicacion vas a tener que ejecutar MainClass.java (o darle al boton de run).
2.-Se tendra que revisar y validar que: el login funcione correctamente, el menu principal se despliegue correctamente, que los datos dentro de Inventario.txt se cargen correctamente, que los botones funciones de manera debida y que el archivo Inventario.txt se actualize despues de cada cabio realizado.
3.-si todo lo anterios funciona correctamente significa que la aplicacion funciona como se debe (si funcionaba correctamente la ultima vez que lo revise.)

-Implementar solucion en Produccion: bueno siendo totalmente honesto de momento esta aplicacion es solo local por lo que explicare como implementarla en un ambiente local:
1.-Asegurar que se haya instalado correctamente el JAR para despues poderlo exportar a NetBeans, una vez lo hayas exportado en NetBeans asegurar de darle al boton de Clean and Build (no deberia de mostrar ningun error).
2.-Asegurar de que en tu carpeta tengas el Jar instalado y El Archivo Inventario.txt (si no me equivoco ya deberia de venir al clonar el repositorio pero en caso de que no si no me equivoco al darle al boton de run si no lo encuentra deberia de crearlo automaticamente.)
3.-por ultimo Ejecutar el JAR.

# Configuracion
-Configuracion del Producto: Esta Aplicacion utiliza el Archivo Inventario.txt y dentro de este Archivo se guarda la informacion de cada producto introducido y cada producto tiene que llenar cada linea con informacion las lineas son las siguientes (sin alterar el orden porque se puede acomodar al gusto del usuario.) ID,Nombre,Cantidad,Precio,Categoria,LimitePedir,LimiteAceptable.

-Configuracion de requerimientos: El Archivo Inventario.txt debe exisitir dentro del mismo directorio que el JAR y este tiene que tener permisos de lectura y escritura.

# Uso
-Manual de Usuario Final: a continuacion voy a explicar como un usuario puede utilizar la aplicacion.
1.-primero abrir la aplicacion.
2.-Introducir el usuario y contrasena: El usuario predeterminado es Usuario1 y la contrasena es Tienda246
3.-una vez introducida la contrasena y usuario, el menu principal aparecera con dos opciones Gestionar inventario o salir, salir cierra la aplicacion y el boton de Gestionar inventario te permite ir a la pantalla de gestionar inventario.
4.-Dentro de Gestionar Inventario podras encontrar una tabla (reorganizable a tu gusto) donde podras almacenar tus productos con cantidades precio y otras informaciones importantes, y en la parte inferior de la aplicacion podras encontrar los botones de agregar, editar, actualizar, borrar y regreasr al menu, cada boton cumple una funcion.
5.-el boton de agregar te permite crear nuevos productos, el boton de editar te permite editar nombre,id,precio,cantidad adquirida,entre otros, el boton de acutalizar debe de actualizar la tabla en caso que se realizae algun cambio (algo un poco inecesario ya que casi todo se actualiza inmediatamanete pero ya vere si despues lo retiro o si lo dejo por si acaso) y por ultimo el boton de regresar al menu te regresa al menu con el boton de salir y gestionar inventario.
6.-Fin de la simulacion.

-referencia para usuario Administrador: El administrados puede hacer diferentes cosas entre ellas pueden, Modificar el archivo Inventario.txt manualmente, cambiar credenciales en la clase LoginFrame para poder poner otro usuario y contrsenia personalisados, Agregar nuevos modulos, entre otros.

# Contribucion
-Como contribuir?: las contribuciones son lo que hacen de esta aplicacion unica y con las capacidades de volverse algo util y bueno para los usuarios, se les agradece a todos los uduarios que gusten contribuir y brindarle de su toque unico a esta aplicacion, a continuacion mostrare como pueden clonar el repositorio y hacer commits para subirlo a un branch (en este caso Dev):
1.- primero se tiene que clonar el repositorio: git clone https://github.com/CalebAguilar007/GestionadordeInventarioTecmilenioCum.git
2.-asegurate de abrir tu gitbash dentro de la carpeta del proyecto y ejecutar el comando: git checkout dev (para cambiar a la branch Dev).
3.-despues de hacer cambios asegurarte de ejecutar el comando: git add .
4.-Despues utilizar: git commit -m "nueva funcion por implementar que hayas hecho"
5.-y por ultimo ejecutar el comando: git push origin Dev
6.-despues dentro del Github puedes tambien crear un pull request para mandar los cambios realizados en Dev para la version Main (la principal).
7.-Esperar a revision por mi parte para despues acceptar el merge y que los cambios se realizen dentro de la version main.

les agradesco todas contribuciones que gusten realizar, estare esperando con emocion a ver sus ideas divertidas y no olviden que su creatividad no tiene limites.

# Roadmap
-Road map actual: el Roadmap actual con todos los requerimientos planeados ya fue completado, puede que en el futuro se puedan crear nuevas implementaciones pero de momento ya todo fue terminado, a continuacion mostrare los requerimientos que se implementaron: 
1.-Crear el login
2.-Crear la ventana de gestion de inventario
3.-crear formulario crear producto
4.-creacion de menu interactuable
5.-Editar cantidades de inventario
6.-Crear estado cambiable de inventario (cambia automaticamente)
7.-crear Archivo de guardado de datos tipo .txt

estas serian todas los requerimientos planeados e implementados de forma correcta dentro del roadmap.

