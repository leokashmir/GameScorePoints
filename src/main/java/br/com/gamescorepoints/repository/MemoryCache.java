package br.com.gamescorepoints.repository;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Classe que representa o cache de memoria
 *
 */
@Component
public class MemoryCache {

    /**
     * Objeto que representa a Memoria em cache
     */
    private transient Map<Integer,Integer> memory;

    /**
     * Construtor MemoryCache que inicia o cache de memoria
     */
    public MemoryCache(){
         memory = new LinkedHashMap();
    }

    /**
     * Metodo que recupera o cache da memoria
     * @return memory Map<Integer,Integer>
     */
    @Bean
    public Map<Integer,Integer> getMemory() {
        return memory;
    }

    /**
     * Metodo que retornar do cache o ranking dos usuarios ordenado por pontos.
     * @return Map<Integer,Integer>
     */
    public Map<Integer,Integer> getOrderByPoints(){
       return  memory.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
  }

}
