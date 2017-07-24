package pl.squirrel.graphqlbug;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@EnableTransactionManagement
@SpringBootApplication
public class Application {

    private static final String GRAPHQL_SERVLET_MAPPING = "/graphql/*";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private List<GraphQLResolver<?>> resolvers;

    @Bean
    public GraphQLSchema graphQLSchema() {
        return SchemaParser.newParser()
                .file("demo.graphqls")
                .resolvers(resolvers)
                .build()
                .makeExecutableSchema();
    }

    @Bean
    ServletRegistrationBean graphQLServletRegistrationBean() {
        return new ServletRegistrationBean(new SimpleGraphQLServlet(graphQLSchema()), GRAPHQL_SERVLET_MAPPING);
    }
}
