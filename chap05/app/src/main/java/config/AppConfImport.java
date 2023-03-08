package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@Import( { AppCtx1.class, AppCtx2.class } )
@ComponentScan(basePackages = {"spring"},
    excludeFilters = @Filter(type = FilterType.REGEX, pattern = "spring\\..*Dao"))
public class AppConfImport {

    public AppConfImport() {
    }
    
}
