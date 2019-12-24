package Financeiro.Controller;

// Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Postgres
import Financeiro.Controller.DBConfig;

@Controller
public class MainController{
    
   DBConfig db = new DBConfig();

@RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView main() throws SQLException{
      
      
      this.db.conexao(); 
      
      // Constitui os atributos que a pagina ira receber
      ModelAndView modelo = new ModelAndView("index");      
      modelo.addObject("db",db.status);
       
      List<String> comboBox1 = db.comboBoxTipGasto();    

      List<String> listaTabelas =  db.listarTabelas();
      modelo.addObject("lista",listaTabelas);

      return modelo;
  }

  @ModelAttribute("countryList")
  public List<String> getCountryList() {
      List<String> countryList = new ArrayList<String>();
      countryList.add("United States");
      countryList.add("China");
      countryList.add("Singapore");
      countryList.add("Malaysia");
      return countryList;
   }

}