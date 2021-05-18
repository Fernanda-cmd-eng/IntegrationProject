package main.java;
// olá
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.model.Category;
import main.java.model.Row;
import main.java.view.Controller;

public class MainApp extends Application {
    
     private Stage primaryStage;
     private AnchorPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Projeto Integração");
              
       initInterface();
  
    }
    
    public void initInterface() {
         try {
                // Carrega o rootlayout do arquivo fxml.
                FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("/main/java/view/Interface.fxml"));

               // var resource = MainApp.class.getResource("/main/java/view/Interface.fxml");
               // loader.setLocation(resource);
                Object _root = loader.load();
                rootLayout = (AnchorPane)_root; 
                
                // Mostra a scene (cena) contendo o root layout.
                Scene scene = new Scene(rootLayout);
                primaryStage.setScene(scene);
                primaryStage.show();
                                                         
                
                // Dá ao controlador acesso à the main app.
                Controller controller  =loader.getController();
                List<Row> items = new ArrayList<Row>();
                
                //Carrega a linha Ares
                Row row = new Row(1, "Ares");                
                
                //Cria categoria de Ares TB
                Category category = new Category("Ares TB");
                category.getModels().add("ARES 7021");
                category.getModels().add("ARES 7031");
                category.getModels().add("ARES 7023");
                row.getCategories().add(category);      //Adiciona as categorias 

                category = new Category("Ares THS");
                category.getModels().add("ARES 8023 15");
                category.getModels().add("ARES 8023 200");
                category.getModels().add("ARES 8023 2,5");
                row.getCategories().add(category);
                
                items.add(row);   //Carrega itens de cada linha
                
                row = new Row(2, "Cronos");     //Carrega a linha Cronos
              
                category = new Category("Cronos Old");
                category.getModels().add("Cronos 6001-A");
                category.getModels().add("Cronos 6003");
                category.getModels().add("Cronos 7023");
                row.getCategories().add(category);                              
                
                category = new Category("Cronos L");
                category.getModels().add("Cronos 6021L");
                category.getModels().add("Cronos 6021L");
                category.getModels().add("Cronos 7023L");
                row.getCategories().add(category);
                                              
                category = new Category("Cronos-NG");
                category.getModels().add("Cronos 6001-NG");
                category.getModels().add("Cronos 6003-NG");
                category.getModels().add("Cronos 6021-NG");
                category.getModels().add("Cronos 6031-NG");
                category.getModels().add("Cronos 7021-NG");
                category.getModels().add("Cronos 7023-NG");
                row.getCategories().add(category);
                
                items.add(row);
                controller.setComboboxItems(items);
                //controller.carregarCategorias();
                //controller.set(this);
                
                
            } catch (IOException e) {
                e.printStackTrace();                
            }
    }
    
    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }
}