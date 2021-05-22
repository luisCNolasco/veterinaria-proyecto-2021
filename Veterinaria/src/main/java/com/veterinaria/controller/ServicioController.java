package com.veterinaria.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.veterinaria.entity.Servicios;
import com.veterinaria.service.ServicioService;


@Controller
public class ServicioController {

	@Autowired
	private ServicioService servicioService;

	@RequestMapping("/verServicio")
	public String mostrar() {
		return "servicio";
	}
	
	@RequestMapping("/listaServicio")
	@ResponseBody
	public List<Servicios> listaServicio(){
		return servicioService.listaServicio();
	}
	
	@RequestMapping("/consultaCrudServicio")
	public String consulta(String filtro, HttpSession session) {
		List<Servicios> data = servicioService.buscaPorNombre(filtro +"%");
		session.setAttribute("servicio", data);
		return "servicio";
	}
	
	@RequestMapping("/registraServicio")  
	@ResponseBody
	public Map<String, Object> insertaServicio(Servicios serv) {
		Map<String, Object> salida = new HashMap<>();
		serv.setFec_ser(new Date());
		try {
			servicioService.insertaServicio(serv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
		
		
	}
	
	@RequestMapping("/actualizaServicio")  
	@ResponseBody
	public Map<String, Object> actualizaServicio(Servicios serv) {
		Map<String, Object> salida = new HashMap<>();
		try {
			servicioService.insertaServicio(serv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
		
		
	}

	@RequestMapping("/eliminaServicio")
	public String elimina(Integer cod, HttpSession session) {
		servicioService.eliminaServicio(cod);
		return "servicio";
	}
}