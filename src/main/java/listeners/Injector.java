package listeners;

import dao.mySql.MySqlForumThemesDao;
import dao.mySql.MySqlPhotoAlbumDao;
import dao.mySql.MySqlPhotoDao;
import dao.mySql.MySqlUserDao;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 * Created by veraivanova on 17.03.17.
 */
public class Injector implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        MySqlUserDao mySqlUserDao = new MySqlUserDao();
////        MySqlUserDao mySqlUserDao1 = new MySqlUserDao();
//       // MySqlPhotoAlbumDao mySqlPhotoAlbumDao = new MySqlPhotoAlbumDao();
//
//        sce.getServletContext().setAttribute("UserDao", mySqlUserDao);
        sce.getServletContext().setAttribute("UserDao", new MySqlUserDao());
        sce.getServletContext().setAttribute("ForumThemesDao", new MySqlForumThemesDao());
        sce.getServletContext().setAttribute("PhotoAlbumDao", new MySqlPhotoAlbumDao());
        sce.getServletContext().setAttribute("PhotoDao", new MySqlPhotoDao());
//        sce.getServletContext().setAttribute("PhotoAlbumDao", new MySqlPhotoAlbumDao(
//                integer -> mySqlUserDao.get(integer).get()
//        ));
//        sce.getServletContext().setAttribute("PhotoDao", new MySqlPhotoDao(
////                integer -> mySqlUserDao.get(integer).get()
//                integer ->
//        ));

    }
}
