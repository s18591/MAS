import org.junit.Assert;
import org.junit.Test;
import pja.edu.s18591.dynamic.module.Building;
import pja.edu.s18591.multi.exception.ValidationException;

public class dynamicTest {
    @Test
    public void dynamicTest(){
        Building library = new Building("Library",10);
        Building wineCellar = new Building("WineCellar",10f);
        Assert.assertEquals(library.getBooks(),10);
        Assert.assertEquals(wineCellar.getWine(),10f,0.1);
        library.becomeWineCellar(10f);
        Assert.assertEquals(library.getWine(),10f,0.1);
        wineCellar.becomeLibrary(10);
        Assert.assertEquals(wineCellar.getBooks(),10);
        try {
            library.getBooks();
            wineCellar.getWine();
        }catch (ValidationException e){
            e.printStackTrace();
        }
    }
}
