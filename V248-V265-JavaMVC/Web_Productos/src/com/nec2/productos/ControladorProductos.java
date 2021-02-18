package com.nec2.productos;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.List;


/**
 * Servlet implementation class Controlador
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloProductos modeloProductos;
	
	@Resource(name="jdbc/Productos")
	
	private DataSource miPool;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
		
		modeloProductos = new ModeloProductos(miPool);
		
	}catch(Exception e){
		
		throw new ServletException(e);
	}
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Leer el parámetro que le llega del formulario
		String elComando = request.getParameter("instruccion");
		
		//Si no se envía el parámetro, listar productos
		if(elComando==null) elComando = "listar";
			
		//Redirigir el flujo de ejecución al método adecuado
		switch(elComando) {
		
		case "listar":
			
			obtenerProductos(request, response);
			
			break;
			
		case "insertarBBDD":
		
			agregarProductos(request, response);
		
			break;
			
		case "cargar":
			
			try {
				cargaProductos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "actualizarBBDD":
			
			try {
				actualizaProducto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "eliminar":
			
			try {
				eliminarProducto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		default:
			
			obtenerProductos(request, response);
			
		}

	}


	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		//Capturar el Código artículo
		String codArticulo=request.getParameter("CArticulo");
		
		//Borrar producto de la BBDD
		modeloProductos.eliminarProducto(codArticulo);
		
		//Volver al listado de producto
		obtenerProductos(request, response);
		
	}


	private void actualizaProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		//Leer los datos que le vienen del formulario actualizar
		String codArticulo=request.getParameter("codArt");
		String Seccion=request.getParameter("seccion");
		String NombreArticulo=request.getParameter("numArt");
		String Fecha=request.getParameter("fecha");
		String Precio=request.getParameter("precio");
		String Importado=request.getParameter("importado");
		String PaisOrigen=request.getParameter("paisOrigen");

		//Crear un objeto de tipo producto con la info del formulario
		Productos ProductoActualizado = new Productos(codArticulo, Seccion, NombreArticulo, Fecha, Precio, Importado, PaisOrigen);
		
		//actualizar la BBDD con la info del objeto producto
		modeloProductos.actualizarProducto(ProductoActualizado);
		
		//Volver al listado con la info actualizada
		obtenerProductos(request, response);
		
	}


	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//Leer el Códiogo artículo que viene del listado
		String codigoArticulo=request.getParameter("CArticulo");
		
		//Enviar codigoarticulo a modelo
		Productos elProducto=modeloProductos.getProductos(codigoArticulo);
		
		//Colocar atributo correspondiente al Código artículo
		request.setAttribute("ProductoActualizar", elProducto);
		
		//Enviar producto al formulario de actualizar (jsp)
		RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizarProducto.jsp");
		dispatcher.forward(request, response);
		
	}


	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//leer la informacion del producto que viene del formulario
		String codArticulo=request.getParameter("codArt");
		String Seccion=request.getParameter("seccion");
		String NombreArticulo=request.getParameter("numArt");
		String Fecha=request.getParameter("fecha");
		String Precio=request.getParameter("precio");
		String Importado=request.getParameter("importado");
		String PaisOrigen=request.getParameter("paisOrigen");

		
		//Crear un objeto del tipo producto
		Productos nuevoProducto = new Productos(codArticulo, Seccion, NombreArticulo, Fecha, Precio, Importado, PaisOrigen);
		
		//Enviar el objeta al modelo e insertar el producto en la BBDD
		try {
			modeloProductos.agregarNuevoProducto(nuevoProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//Volver al listado de Productos.
		obtenerProductos(request, response);
		
		
	}


	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//Obtener la lista de productos desde el modelo
		List<Productos> productos;
		
		try {
			
			productos = modeloProductos.getProductos();

		//Agregar la lista de productos al request
			
			request.setAttribute("LISTAPRODUCTOS", productos);
		
		//Enviar request a la pagina jsp
			
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
			
			miDispatcher.forward(request, response);
			
		//Crear la página jsp
			
		}catch(Exception e) {
			
			
		}
		
	}

}
