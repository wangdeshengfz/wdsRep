import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlToolsTest {
    private static Logger logger = LoggerFactory.getLogger(UrlToolsTest.class); 
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = java.net.URLEncoder.encode("公务员考试", "utf-8");
        System.out.println(str);
        logger.info(str);
    }

   
}
