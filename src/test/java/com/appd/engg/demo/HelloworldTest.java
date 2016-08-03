package com.appd.engg.demo;
import com.sun.javafx.binding.BindingHelperObserver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mohitagarwal on 02/08/16.
 */
public class HelloworldTest {

    private Helloworld obj = new Helloworld();

    @Test
    public void test_myTestMethod(){
        String str = obj.hello("test");
        Assert.assertEquals(str, "This is test");
    }
}
