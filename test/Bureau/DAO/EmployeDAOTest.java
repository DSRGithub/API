/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bureau.DAO;
import static Bureau.DAO.BureauDAOTest.dbConnect;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projet3_api.metier.Employe;
import myconnections.DBConnection;
/**
 *
 * @author David
 */
public class EmployeDAOTest {
    static Connection dbConnect;
    public EmployeDAOTest() {
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
     * Test of create method, of class EmployeDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Employe obj = new Employe(0,"TestMATRICULE","TestNOM","TestPRENOM",1);
        EmployeDAO instance = new EmployeDAO();
        instance.setDbConnect(dbConnect);
        Employe expResult = new Employe(0,"TestMATRICULE","TestNOM","TestPRENOM",1);
        Employe result = instance.create(obj);
        assertEquals("matricules différents",expResult.getMATRICULE(), result.getMATRICULE());
        assertEquals("nom différents",expResult.getNOM(), result.getNOM());
        assertEquals("prenom différentes",expResult.getPRENOM(), result.getPRENOM());
        assertEquals("bureau différentes",expResult.getIDBUR(), result.getIDBUR());
        assertNotEquals("id employé non généré",expResult.getIDEMP(),result.getIDEMP());
        instance.delete(result);
        
    }

    /**
     * Test of readMATRICULE method, of class EmployeDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testReadMATRICULE() throws Exception {
        System.out.println("readMATRICULE");
        EmployeDAO instance = new EmployeDAO();
        instance.setDbConnect(dbConnect);
        Employe obj = new Employe(0, "TestMATRICULE", "TestNOM", "TestPRENOM",1);
        Employe expResult = instance.create(obj);
        String MATRICULE = expResult.getMATRICULE();
        Employe result = instance.readMATRICULE(MATRICULE);
        assertEquals("matricules différents",expResult.getMATRICULE(), result.getMATRICULE());
        assertEquals("nom différents",expResult.getNOM(), result.getNOM());
        assertEquals("prenom différentes",expResult.getPRENOM(), result.getPRENOM());
        assertEquals("bureau différentes",expResult.getIDBUR(), result.getIDBUR());
        assertEquals("id employé non généré",expResult.getIDEMP(),result.getIDEMP());
        instance.delete(result);
    }

    /**
     * Test of delete method, of class EmployeDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Employe obj = new Employe(0,"TestMATRICULE","TestNOM","TestPRENOM",1);
        EmployeDAO instance = new EmployeDAO();
        instance.setDbConnect(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
       try {
            instance.read(obj.getIDEMP());
            fail("erreur record non effacé ");
            instance.delete(obj);
        }
        catch(SQLException e){}
    }

    /**
     * Test of update method, of class EmployeDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Employe obj = new Employe(0,"TestMATRICULE","TestNOM","TestPRENOM",1);
        EmployeDAO instance = new EmployeDAO();
        instance.setDbConnect(dbConnect);
        obj = instance.create(obj);
        obj.setMATRICULE("TestMATRICULE");
        obj.setNOM("TestNOM");
        obj.setPRENOM("TestPRENOM");
        obj.setIDBUR(1);
        Employe expResult = obj;
        Employe result = instance.update(obj);
        //assertEquals(expResult, result);
        assertEquals("matricules différents",expResult.getMATRICULE(), result.getMATRICULE());
        assertEquals("nom différents",expResult.getNOM(), result.getNOM());
        assertEquals("prenom différentes",expResult.getPRENOM(), result.getPRENOM());
        assertEquals("bureau différentes",expResult.getIDBUR(), result.getIDBUR());
        assertEquals("id employé non généré",expResult.getIDEMP(),result.getIDEMP());
        instance.delete(obj);
    }

    /**
     * Test of read method, of class EmployeDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        EmployeDAO instance = new EmployeDAO();
        instance.setDbConnect(dbConnect);
        Employe obj = new Employe(0,"TestMATRICULE","TestNOM","TestPRENOM",1);
        Employe expResult =instance.create(obj);
        int IDEMP = expResult.getIDEMP();
        Employe result = instance.read(IDEMP);
        assertEquals("matricules différents",expResult.getMATRICULE(), result.getMATRICULE());
        assertEquals("nom différents",expResult.getNOM(), result.getNOM());
        assertEquals("prenom différentes",expResult.getPRENOM(), result.getPRENOM());
        assertEquals("bureau différentes",expResult.getIDBUR(), result.getIDBUR());
        assertEquals("id employé non généré",expResult.getIDEMP(),result.getIDEMP());
        
       try {
            result = instance.read(0);
            fail("Exception d'id inconnu non générée! ");
        } catch (SQLException e) {}
       instance.delete(result);
    }
    }
    

