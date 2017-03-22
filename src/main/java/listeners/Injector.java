package listeners;

import dao.mySql.MySqlForumThemesDao;
import dao.mySql.MySqlPhotoAlbumDao;
import dao.mySql.MySqlPhotoDao;
import dao.mySql.MySqlUserDao;

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
//        MySqlUserDao mySqlUserDao = new MySqlUserDao();
////        MySqlUserDao mySqlUserDao1 = new MySqlUserDao();
//       // MySqlPhotoAlbumDao mySqlPhotoAlbumDao = new MySqlPhotoAlbumDao();
//
//        sce.getServletContext().setAttribute("UserDao", mySqlUserDao);

        sce.getServletContext().setAttribute("UserDao", new MySqlUserDao(dataSource));
        sce.getServletContext().setAttribute("ForumThemesDao", new MySqlForumThemesDao(dataSource));
        sce.getServletContext().setAttribute("PhotoAlbumDao", new MySqlPhotoAlbumDao(dataSource));
        sce.getServletContext().setAttribute("PhotoDao", new MySqlPhotoDao(dataSource));


//        sce.getServletContext().setAttribute("PhotoAlbumDao", new MySqlPhotoAlbumDao(
//                integer -> mySqlUserDao.get(integer).get()
//        ));
//        sce.getServletContext().setAttribute("PhotoDao", new MySqlPhotoDao(
////                integer -> mySqlUserDao.get(integer).get()
//                integer ->
//        ));

    }
}
