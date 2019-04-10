/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bureau.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projet3_api.metier.Bureau;
import myconnections.DBConnection;
/**
 *
 * @author David
 */
public class BureauDAOTest {
     static Connection dbConnect;
    public BureauDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();// avant on se co 
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
        System.out.println("connexion etablie");
    }
    
    @AfterClass
    public static void tearDownClass() {
        DBConnection.closeConnection();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readSigle method, of class BureauDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSigle() throws Exception {
        System.out.println("readSigle");
        Bureau obj = new Bureau(0,"TestSIGLE","TestTEL","TestDESCRIPTION");
        String SIGLE = "TestSIGLE";
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        obj.setSIGLE("TestSIGLE");
        obj.setTEL("TestTEL");
        obj.setDESCRIPTION("TestDESCRIPTION");
        Bureau expResult = obj;
        Bureau result = instance.readSigle(SIGLE);
        assertEquals("SIGLE différents",expResult.getSIGLE(), result.getSIGLE());
        try{
            result=instance.read(0);
            fail("exception de SIGLE inconnu non générée");
        }
        catch(SQLException e){}
       instance.delete(result);
    }

    /**
     * Test of create method, of class BureauDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Bureau obj = new Bureau(0,"TestSIGLE","TestTEL","TestDESCRIPTION");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau expResult = new Bureau(0,"TestSIGLE","TestTEL","TestDESCRIPTION") ;
        Bureau result = instance.create(obj);
        assertEquals(expResult, result);
        assertEquals("sigles différents",expResult.getSIGLE(), result.getSIGLE());
        assertEquals("telephones différents",expResult.getTEL(), result.getTEL());
        assertEquals("descriptions différentes",expResult.getDESCRIPTION(), result.getDESCRIPTION());
        
    }

    /**
     * Test of delete method, of class BureauDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Bureau obj = new Bureau(0,"TestSIGLE","TestTEL","TestDESCRIPTION");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
       try {
            instance.read(obj.getIDBUR());
            fail("erreur record non effacé ");
            instance.delete(obj);
        }
        catch(SQLException e){}
    }

    /**
     * Test of update method, of class BureauDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Bureau obj = new Bureau(0,"TestSIGLE","TestTEL","TestDESCRIPTION");
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        obj.setSIGLE("TestSIGLE");
        obj.setTEL("TestTEL");
        obj.setDESCRIPTION("TestDESCRIPTION");
        Bureau expResult = obj;
        Bureau result = instance.update(obj);
        //assertEquals(expResult, result);
        assertEquals(expResult.getSIGLE(), result.getSIGLE());
        assertEquals(expResult.getTEL(), result.getTEL());
        assertEquals(expResult.getDESCRIPTION(), result.getDESCRIPTION());
        instance.delete(obj);
        
    }

    /**
     * Test of rechBureauDesc method, of class BureauDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testRechBureauDesc() throws Exception {
        System.out.println("rechBureauDesc");
        Bureau obj = new Bureau(0,"TestSIGLE","TestTEL","TestDESCRIPTION");
        String BureauRdesc = "TestDESCRIPTION";
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        obj=instance.create(obj);
        List<Bureau> result = instance.rechBureauDesc(BureauRdesc);//
        if(result.indexOf(obj)<0) fail("record introuvable "+obj);
        instance.delete(obj);
        
        
        
    }

    /**
     * Test of read method, of class BureauDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int IDBUR = 0;
        BureauDAO instance = new BureauDAO();
        instance.setConnection(dbConnect);
        Bureau expResult = new Bureau(0,"TestSIGLE","TestTEL","TestDESCRIPTION");
        Bureau result = instance.read(IDBUR);
        assertEquals(expResult, result);
       
    }
    
}
