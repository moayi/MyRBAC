import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

/**
 * moayi
 *
 * @create 2018-06-14 10:11
 **/
@RunWith(JUnit4.class)
public class DeCITest {
    @Test
    public  void test1(){
        BigDecimal rate=new BigDecimal("0.213655");
        BigDecimal ordInsidePriTl=new BigDecimal("1000.6700000");
        BigDecimal expTol=new BigDecimal("0");
        expTol=expTol.add(ordInsidePriTl.multiply(rate));
        System.out.println("-----------------"+expTol);
    }
    @Test
    public  void test2(){
        CacheManager cacheManager = CacheManager.newInstance(CacheManager.class.getClassLoader().getResource("config/ehcache.xml"));
        System.out.println(cacheManager.getCacheNames());
    }
}