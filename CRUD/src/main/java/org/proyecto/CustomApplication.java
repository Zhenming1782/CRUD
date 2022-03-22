package org.proyecto;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import javax.ws.rs.core.Application;


@OpenAPIDefinition( 
        info = @Info(
                title="Java Framework",
                version = "1.0.0 (Test)",
                contact = @Contact(
                        name = "API Explorer",
                        url = "http://pucmm.edu.do/",
                        email = "pucmmisc@example.com"),
                license = @License(
                        name = "Proyecto Final 1.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html")))
@SecuritySchemes(value = {
        @SecurityScheme(securitySchemeName = "apiKey",
                type = SecuritySchemeType.HTTP,
                scheme = "Bearer")}
)public class CustomApplication extends Application {
}