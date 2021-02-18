package com.nec2.productos;

import java.sql.*;
import java.util.*;
import javax.sql.DataSource;

public class ModeloProductos {
	
	private DataSource origenDatos;
	
	public ModeloProductos(DataSource origenDatos){
		
		this.origenDatos = origenDatos;
	}
	
	public List<Productos> getProductos() throws Exception{
		
		List<Productos> productos = new ArrayList<>();
		
		Connection miConexion = null;
		
		Statement miStatement = null;
		
		ResultSet miResultSet = null; 
		
		//-------Establecer la Conexion-------------//
		
		miConexion = origenDatos.getConnection();
		
		//-------Crear sentencia SQL y el Statement-//
		
		String instruccionSql = "SELECT * FROM PRODUCTOS";
		
		miStatement = miConexion.createStatement();
		
		//-------Ejecutar SQL-----------------------//
		
		miResultSet = miStatement.executeQuery(instruccionSql);
		
		//-------Recorrer el ResulltSet obtenido----//
		
		while(miResultSet.next()) {
			
			String codArt = miResultSet.getString("CÓDIGOARTÍCULO");
			
			String seccion = miResultSet.getString("SECCIÓN");
			
			String numArt = miResultSet.getString("NOMBREARTÍCULO");
			
			String  precio = miResultSet.getString("PRECIO");
			
			String fecha = miResultSet.getString("FECHA");
			
			String importado = miResultSet.getString("IMPORTADO");
			
			String paisOrigen = miResultSet.getString("PAÍSDEORIGEN");
			
			Productos tempProductos = new Productos(codArt,seccion,numArt,precio,fecha,importado,paisOrigen);
			
			productos.add(tempProductos);
		}
		
		return productos;
	}

	public void agregarNuevoProducto(Productos nuevoProducto) throws Exception {
		// TODO Auto-generated method stub
		
		Connection miConexion=null;
		
		PreparedStatement miStatement = null;
		
		//Obtener la conexion con la BBDD
		
		try {
			
			miConexion = origenDatos.getConnection();
	
		//Crear instruccion SQL para insertar el producto
		String sql = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, SECCIÓN, NOMBREARTÍCULO, PRECIO,FECHA, IMPORTADO, PAÍSDEORIGEN)"
		+ "VALUES(?,?,?,?,?,?,?)";
		
		miStatement = miConexion.prepareStatement(sql);
		
		//Establecer parámetros para el Producto
		miStatement.setString(1, nuevoProducto.getCodArt());
		miStatement.setString(2, nuevoProducto.getSeccion());
		miStatement.setString(3, nuevoProducto.getNumArt());
		miStatement.setString(4, nuevoProducto.getPrecio());
		miStatement.setString(5, nuevoProducto.getFecha());
		miStatement.setString(6, nuevoProducto.getImportado());
		miStatement.setString(7, nuevoProducto.getPaisOrigen());
		
		//Ejecutar la instruccion SQL
		miStatement.execute();
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
}finally {
			
			miStatement.close();
			miConexion.close();
			
			
		}
		
	}

	public Productos getProductos(String codigoArticulo) {
		// TODO Auto-generated method stub
		
		Productos elProducto = null;
		
		Connection miConexion = null;
		
		PreparedStatement miStatement = null;
		
		ResultSet miResultset = null;
				
		String cArticulo=codigoArticulo;
		
		try {
			
		//Establecer la Conexion con la BBDD
			
			miConexion=origenDatos.getConnection();
		
		//Crear SQL que busque el producto
			String sql = "SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
		
		//Crear la consulta preparada
			miStatement=miConexion.prepareStatement(sql);
		
		//Establecer los parámetros
			miStatement.setString(1, cArticulo);
		
		//Ejecutar la consulta 
			miResultset=miStatement.executeQuery();
		
		//Obtener los datos de respuesta
			if(miResultset.next()) {
				
				String c_art = miResultset.getString("CÓDIGOARTÍCULO");
				
				String seccion = miResultset.getString("SECCIÓN");
				
				String numArt = miResultset.getString("NOMBREARTÍCULO");
				
				String  precio = miResultset.getString("PRECIO");
				
				String fecha = miResultset.getString("FECHA");
				
				String importado = miResultset.getString("IMPORTADO");
				
				String paisOrigen = miResultset.getString("PAÍSDEORIGEN");
				
				elProducto = new Productos(c_art, seccion,numArt,precio,fecha,importado,paisOrigen);
				
			}else {
				
				throw new Exception("No hemos encontrado el producto con código = " + cArticulo);
			}
		
		
	}catch(Exception e) {
		
		e.printStackTrace();
		
	}
		return elProducto;

}

	public void actualizarProducto(Productos productoActualizado) throws Exception {
		// TODO Auto-generated method stub
		
		Connection miConexion = null;
		
		PreparedStatement miStatement = null;
				
		try {
		//Establecer la conexion con la BBDD
		miConexion=origenDatos.getConnection();
		
		//Crear la sentencia SQL
		String sql ="UPDATE PRODUCTOS SET SECCIÓN=?, NOMBREARTÍCULO=? +"
				+ "PRECIO=?, FECHA=?, IMPORTADO=?, PAÍSDEORIGEN=? WHERE" +
				" CÓDIGOARTÍCULO=?";
		
		//Crear la consulta preparada
		miStatement=miConexion.prepareStatement(sql);
		
		//Establecer los parámetros
		miStatement.setString(1, productoActualizado.getSeccion());
		miStatement.setString(2, productoActualizado.getNumArt());
		miStatement.setString(3, productoActualizado.getPrecio());
		miStatement.setString(4, productoActualizado.getFecha());
		miStatement.setString(5, productoActualizado.getImportado());
		miStatement.setString(6, productoActualizado.getPaisOrigen());
		miStatement.setString(7, productoActualizado.getCodArt());
		
		//Ejecutar la instruccion SQL
		miStatement.executeQuery();
		
	}finally {
		
		miStatement.close();
		miConexion.close();
		
	}
		
	}

	public void eliminarProducto(String codArticulo) throws Exception{
		// TODO Auto-generated method stub
		
		Connection miConexion = null;
		
		PreparedStatement miStatement = null;
		
		//Establecer la conexion con la BBDD
		try {
		miConexion=origenDatos.getConnection();
		
		//Crear la sentencia SQL
		String sql ="DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
		
		//Crear la consulta preparada
		miStatement=miConexion.prepareStatement(sql);
		
		//Establecer los parámetros
				miStatement.setString(1, codArticulo);
		
		//Ejecutar la instruccion SQL
				miStatement.executeQuery();
				
		}finally {
			
			miStatement.close();
			miConexion.close();
			
		}
		
	}
	
}
