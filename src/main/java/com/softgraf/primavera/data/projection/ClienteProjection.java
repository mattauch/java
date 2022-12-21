package com.softgraf.primavera.data.projection;

//Usada por query repository
public interface ClienteProjection {
	
	//criar os métodos na ordem da Query
	Long getId();
	String getNome();
	String getEmail();
}
