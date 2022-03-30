package com.everis.pruebasConBBDD_Taller1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App 
{
    public static void main( String[] args )
    {
    	//Conexión de consulta
        conexionDB();
    }
    
    private static void conexionDB() {
    	try {
    		//Se establece conexión
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		//Se abre la conexión a la BBDD
    		final Connection dBconection = DriverManager.getConnection("jdbc:mysql://"+"localhost"+":"+"3306"+"/nttdata_jdbc_ex","andrea","andrea");
    		
    		//Consulta
    		final Statement sentencia = dBconection.createStatement();
    		final String query = "SELECT name as playerName FROM nttdata_mysql_soccer_player";
    		final ResultSet queryResult = sentencia.executeQuery(query);
    		
    		//Se itera
    		StringBuilder info = new StringBuilder();
    		while(queryResult.next()) {
    			
    			info.append("Nombre: ");
    			info.append(queryResult.getString("playerName"));
    		}
    		
    		System.out.println(info.toString());
    		
    		//Se cierra la conexión
    		dBconection.close();
    	} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
    		System.out.println("Conexión realizada con éxito.");
    	}
    }
}