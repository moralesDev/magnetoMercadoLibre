# Magneto mercadolibre

Api Rest creado para detectar si tu ADN corresponde al de un Mutante o no.



Ingresa a la URL https://magnetoprueba.herokuapp.com/swagger-ui/index.html para conocer acerca de los apis habilitadas.

1. ## https://magnetoprueba.herokuapp.com/service/mutant

  Invoca el api rest cargando un body tipo raw como el siguiente ejemplo
  
  {
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","TTCCTA","TCACTG"]
  }
  
  Respuesta : En el caso de ser correctos la respuesta sera un HTTP 200 OK
  
  En el caso de no ser mutante se indicara un mensaje que no eres mutante.
  
  En el caso de que se envie mal la petición se devolvera un 403 Forbidden.
  
  Esta lista de string creara un cuadro tipo sopa de letras donde el algoritmo se encargara de encontrar semejanzas de letras (deben ser 4), horizontal, vertical
  o diagonal.
  
  En el caso de encontrar al menos dos semejanzas la api te indicara que eres mutante, en caso contrario no eres mutante.
  
  Notas : Solo se permiten las letras A C T G
  
2.  ## https://magnetoprueba.herokuapp.com/service/stats

  Todos los datos son almacenas, este servicio te mostrara un contador de las pruebas, quienes fueron mutantes y quienes no.
  
  Ejemplo de respuesta:
  
  {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}

