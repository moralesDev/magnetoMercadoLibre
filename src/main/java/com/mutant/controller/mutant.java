package com.mutant.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.mutant.entity.modelDNA;
import com.mutant.service.StatsService;

/*
 * Alejandro Morales
 * */

public class mutant {
	@Autowired
	StatsService service;

	private char[][] matriz;

	public boolean isMutant(modelDNA dna) {
		int contadorCadenasEncontradas = 0;

		try {
			String[] data = dna.getDna().toArray(new String[0]);

			matriz = new char[data.length][data.length];

			int longMatriz = matriz.length;

			if (!esMatriz(data)) {
				return false;
			} else {
				do {
					for (int x = 0; x < longMatriz; x++) {
						
						if (contadorCadenasEncontradas < 2) {
							for (int y = 0; y < longMatriz; y++) {

								char posicionActual = matriz[x][y];

								// Busqueda Horizontal
								if (contadorCadenasEncontradas < 2) {
									if ((y + 4) <= longMatriz) {
										if (horizontal(x, y, posicionActual)) {
											contadorCadenasEncontradas++;
										}
									}
								} else {
									break;
								}

								if (contadorCadenasEncontradas < 2) {
									if ((x + 4) <= longMatriz) {
										if (vertical(x, y, posicionActual)) {
											contadorCadenasEncontradas++;
										}
									}
								} else {
									break;
								}

								if (contadorCadenasEncontradas < 2) {
									if ((y + 4) <= longMatriz) {
										if ((x + 4) <= longMatriz) {
											if (diagonal(x, y, posicionActual)) {
												contadorCadenasEncontradas++;		
											}
										}
									}
								} else {
									break;
								}
							}
						} else {
							break;
						}
					}
					break;
				} while (contadorCadenasEncontradas < 2);
				
				if (contadorCadenasEncontradas == 2) {
					return true;
					

				} else {
					return false;
				}
				
			}

		} catch (Exception e) {
			return false;
		}
	}

	private boolean esMatriz(String[] data) {
		try {
			for (int i = 0; i < data.length; i++) {

				if (!data[i].matches("[ATCGatcg]*")) {
					return false;
				}

				if (data[i].length() != data.length) {
					return false;
				}

				this.setArrayMatrizCuadrada(data[i].toUpperCase().toCharArray(), i);

			}

			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	public void setArrayMatrizCuadrada(char[] array, int posicion) {
		this.matriz[posicion] = array;
	}
	
	private boolean horizontal(int fila, int posicion, char posicionActual) {

		String cadena = "";
		boolean resultado = false;

		cadena = "" + posicionActual + matriz[fila][posicion + 1] + matriz[fila][posicion + 2]
				+ matriz[fila][posicion + 3];

		switch (cadena) {
		case "AAAA":
			resultado = true;
			break;
		case "TTTT":
			resultado = true;
			break;
		case "CCCC":
			resultado = true;
			break;
		case "GGGG":
			resultado = true;
			break;
		default:
			resultado = false;
			break;
		}

		return resultado;
	}
	
	private boolean vertical(int fila, int posicion, char posicionActual) {

		boolean resultado = false;
		String cadena = "";
		cadena = "" + posicionActual + matriz[fila + 1][posicion] + matriz[fila + 2][posicion]
				+ matriz[fila + 3][posicion];

		switch (cadena) {
		case "AAAA":
			resultado = true;
			break;
		case "TTTT":
			resultado = true;
			break;
		case "CCCC":
			resultado = true;
			break;
		case "GGGG":
			resultado = true;
			break;
		default:
			resultado = false;
			break;

		}

		return resultado;
	}
	
	private boolean diagonal(int fila, int posicion, char posicionActual) {
		String cadena = "";
		cadena = "" + posicionActual + matriz[fila + 1][posicion + 1] + matriz[fila + 2][posicion + 2]
				+ matriz[fila + 3][posicion + 3];
		switch (cadena) {
		case "AAAA":
			return true;
		case "TTTT":
			return true;
		case "CCCC":
			return true;
		case "GGGG":
			return true;
		default:
			return false;

		}
	}
}
