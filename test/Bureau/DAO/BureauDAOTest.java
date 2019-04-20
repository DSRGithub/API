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
import projet3_api.metier.Employe;
import projet3_api.metier.Vue4DAO_PRO;
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
     * aide du code de Arnaud pour le test readsigle.
     */
    @Test
    public void testReadSigle() throws Exception {
        System.out.println("readSigle");
        BureauDAO instance = new BureauDAO();
        instance.setDbConnect(dbConnect);
        Bureau obj = new Bureau(0, "TestSIGLE", "TestTEL", "TestDESCRIPTION");
        Bureau expResult = instance.create(obj);
        String SIGLE = expResult.getSIGLE();
        Bureau result = instance.readSigle(SIGLE);
        assertEquals("SIGLE différents", expResult.getSIGLE(), result.getSIGLE());
        assertEquals("TEL différents", expResult.getTEL(), result.getTEL());
        assertEquals("DESCRIPTION différentes", expResult.getDESCRIPTION(), result.getDESCRIPTION());
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
        instance.setDbConnect(dbConnect);
        Bureau expResult = new Bureau(0,"TestSIGLE","TestTEL","TestDESCRIPTION") ;
        Bureau result = instance.create(obj);
        //assertEquals(expResult, result);
        assertEquals("sigles différents",expResult.getSIGLE(), result.getSIGLE());
        assertEquals("telephones différents",expResult.getTEL(), result.getTEL());
        assertEquals("descriptions différentes",expResult.getDESCRIPTION(), result.getDESCRIPTION());
        assertNotEquals("id non généré",expResult.getIDBUR(),result.getIDBUR());
        //instance.delete(result);
        //Test doublon
        obj = new Bureau(0,"TestSIGLE","TestTEL2","TestDESCRIPTION2") ;
        try {
            Bureau result_2 = instance.create(obj);
            fail("Exception de doublon non générée");
            instance.delete(result_2);
        } catch (SQLException e) {
            instance.delete(result);
        }
        
    }

    /**
     * Test of delete method, of class BureauDAO.
     * @throws java.lang.Exception
     */
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Bureau obj = new Bureau(0,"TestSIGLE","TestTEL","TestDESCRIPTION");
        BureauDAO instance = new BureauDAO();
        instance.setDbConnect(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
       try {
            instance.read(obj.getIDBUR());
            fail("erreur record non effacé ");
            instance.delete(obj);
        }
        catch(SQLException e){}
       /*
       //test supp en cascade si bureau avec employé record associé 
       instance.create(obj);
        Employe emp=new Employe(0,"TestMATRICULE","TestNOM","TestPRENOM",1);
        EmployeDAO empl=new EmployeDAO();
        empl.setDbConnect(dbConnect);
        emp=empl.create(emp);
        try{
            instance.delete(obj);
            fail("exception de record de parent clé étrangère");
        }catch(Exception e){}
        empl.delete(emp);
        instance.delete(obj);
       */
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
        instance.setDbConnect(dbConnect);
        obj = instance.create(obj);
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
        Bureau obj1 = new Bureau(0,"TestSIGLE","TestTEL","TestDESCRIPTION");
        Bureau obj2 = new Bureau(0,"TestSIGLE2","TestTEL2","TestDESCRIPTION");
        String BureauRdesc = "TestDESCRIPTION";
        BureauDAO instance = new BureauDAO();
        instance.setDbConnect(dbConnect);
        obj1=instance.create(obj1);
        obj2=instance.create(obj2);
        List<Bureau> result = instance.rechBureauDesc(BureauRdesc);
        if(result.indexOf(obj1)<0) fail("record introuvable "+obj1);
        if(result.indexOf(obj2)<0) fail("record introuvable "+obj2);
        instance.delete(obj1);
        instance.delete(obj2);
        /*
        System.out.println("rechBureauDesc");
        String BureauRdesc = "TestDESCRIPTION";
        BureauDAO instance = new BureauDAO();
        List<Bureau> expResult = null;
        List<Bureau> result = instance.rechBureauDesc(BureauRdesc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of read method, of class BureauDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        BureauDAO instance = new BureauDAO();
        instance.setDbConnect(dbConnect);
        Bureau obj = new Bureau(0,"TestSIGLE","TestTEL","TestDESCRIPTION");
        Bureau expResult =instance.create(obj);
        int IDBUR = expResult.getIDBUR();
        Bureau result = instance.read(IDBUR);
        assertEquals("Id de bureau différents", expResult.getIDBUR(), result.getIDBUR());
        assertEquals("sigles différents", expResult.getSIGLE(), result.getSIGLE());
        assertEquals("telephone différents", expResult.getTEL(), result.getTEL());
        assertEquals("descriptions différentes", expResult.getDESCRIPTION(), result.getDESCRIPTION());
       try {
            result = instance.read(0);
            fail("Exception d'id inconnu non générée! ");
        } catch (SQLException e) {}
       instance.delete(result);
    }
    
    
    
    
     /**
     * Test of rech method, of class BureauDAO.
     * @throws java.lang.Exception
     */
    
     //@Test
    public void testRech() throws Exception {
        System.out.println("rech");
        String sig = "TestSigle";
        BureauDAO instance = new BureauDAO();
        List<Vue4DAO_PRO> expResult = null;
        List<Vue4DAO_PRO> result = instance.rech(sig);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
      
       
    }
    
}
