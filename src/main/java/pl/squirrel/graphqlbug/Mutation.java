package pl.squirrel.graphqlbug;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
// FIXME: Uncomment @Transaction and watch it blow up on startup
//@Transactional
public class Mutation implements GraphQLMutationResolver {
    private final TodoRepository todos;

    public Mutation(TodoRepository todos) {
        this.todos = todos;
    }

    public String saveTodos(List<TodoInput> input) {
        input.stream().map(i -> new Todo(i.getWhat())).forEach(todos::save);
        return "ok";
    }
}
