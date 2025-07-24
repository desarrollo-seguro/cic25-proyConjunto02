package es.cic.curso25.cic25_proyConjunto02.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mifichero.properties")
public class MiConfiguracion {
    @Value("${otrafuncionalidad}")
    private int otrafuncionalidad;

    @Bean
    public MiClaseCompleja miClaseCompleja() {
        // Lógica de construcción
        return new MiClaseCompleja();
    }
}
