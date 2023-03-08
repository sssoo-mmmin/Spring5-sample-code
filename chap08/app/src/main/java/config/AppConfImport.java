package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import( { AppCtx1.class, AppCtx2.class } )
public class AppConfImport {
    
}
