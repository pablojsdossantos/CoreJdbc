package jdbc;

import etk.jdbc.connection.DbConnection;
import io.quarkus.arc.DefaultBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import org.eclipse.microprofile.context.ManagedExecutor;

/**
 *
 * @author Pablo JS dos Santos
 */
@ApplicationScoped
public class DbConnectionProvider {
    private ManagedExecutor executor;

    public DbConnectionProvider(ManagedExecutor executor) {
        this.executor = executor;
    }

    @Produces
    @DefaultBean
    public DbConnection connection(DataSource dataSource) {
        return new DbConnection(dataSource, this.executor);
    }
}
