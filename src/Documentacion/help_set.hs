<?xml version='1.0' encoding='UTF-8'?>
<helpset version="1.0">
	<title>Ayuda aplicación lista de notas.</title>
	<maps>
		<!-- Pagina por defecto al mostrar la ayuda -->
		<homeID>formularioAplicacion</homeID>
		<!-- Qué mapa deseamos -->
		<mapref location="map_file.jhm"/>
	</maps>
	<!-- Las Vistas que deseamos mostrar en la ayuda-->
	<view>
		<name>Tabla Contenidos</name>
		<label>Tabla de contenidos</label>
		<type>javax.help.TOCView</type>
		<data>toc.xml</data>
	</view>
        <!-- Indice que mostramos en la ayuda --> 
	<view>
		<name>Indice</name>
		<label>El índice</label>
		<type>javax.help.IndexView</type>
		<data>indice.xml</data>
	</view>
        <!-- Sistema de busqueda de la ayuda -->
	<view>
		<name>Buscar</name>
		<label>Buscar</label>
		<type>javax.help.SearchView</type>
		<data engine="com.sun.java.help.search.DefaultSearchEngine">JavaHelpSearch</data>
	</view>
</helpset>