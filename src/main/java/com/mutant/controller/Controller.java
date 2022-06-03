package com.mutant.controller;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mutant.entity.modelDNA;
import com.mutant.entity.Stats;
import com.mutant.service.StatsService;

@RestController
@RequestMapping("/service")
public class Controller {
	@Autowired
	StatsService service;

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Magneto MercadoLibre.";
	}
	
	@PostMapping("/mutant")
	public Response verificar(@RequestBody modelDNA dna) {
		mutant mutant = new mutant();
		try {
			if (mutant.isMutant(dna)) {
				service.countMutant(1);
				return Response.status(200).entity("Es mutante").build();
				
			} else {
				service.countHuman(1);
				return Response.status(200).entity("No es mutante").build();
			}
		} catch (Exception e) {
			return Response.status(403).type("text/plain").entity("Forbidden").build();
		}
	}
	
	@GetMapping("/stats")
	public ArrayList<Stats> obtenerStats(){
		return service.obtenerDatos();
	}
	
}
