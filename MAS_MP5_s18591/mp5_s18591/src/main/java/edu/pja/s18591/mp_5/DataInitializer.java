package edu.pja.s18591.mp_5;


import edu.pja.s18591.mp_5.model.Kingdom;
import edu.pja.s18591.mp_5.repository.KingdomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final KingdomRepository kingdomRepository;
    Kingdom k2;
    Kingdom k3;

@EventListener
    public void start(ContextRefreshedEvent event){
    k2 = Kingdom.builder().name("A").kingName("A").build();
    k3 = Kingdom.builder().name("B").kingName("B").build();
    kingdomRepository.save(k2);
    kingdomRepository.save(k3);
        System.out.println("context refreshed");
    Iterable<Kingdom> kingdoms = kingdomRepository.findAll();
    System.out.println(kingdoms);
}
}
