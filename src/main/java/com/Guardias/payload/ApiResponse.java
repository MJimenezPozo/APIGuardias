package com.Guardias.payload;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {

	private Date fecha = new Date();
	private String mensaje;
	private String url;
	
	public ApiResponse(String mensaje, String url) {
	
		this.mensaje = mensaje;
		this.url = url.replace("uri=", "");
		
	}
	
}
