package listeners;

import dao.H2.*;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class Injector implements ServletContextListener{

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        sce.getServletContext().setAttribute("UserDao", new H2UserDao(dataSource));
        sce.getServletContext().setAttribute("ForumThemeDao", new H2ForumThemeDao(dataSource));
        sce.getServletContext().setAttribute("PhotoAlbumDao", new H2PhotoAlbumDao(dataSource));
        sce.getServletContext().setAttribute("PhotoDao", new H2PhotoDao(dataSource));
        sce.getServletContext().setAttribute("PrivateMessageDao", new H2PrivateMessageDao(dataSource));
        sce.getServletContext().setAttribute("WallMessageDao", new H2WallMessageDao(dataSource));

    }
}
