package pl.squirrel.graphqlbug;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLRootResolver {
    private final TodoRepository todos;

    public Query(TodoRepository todos) {
        this.todos = todos;
    }

    public List<Todo> todos() {
        return Lists.newArrayList(todos.findAll());
    }
}
