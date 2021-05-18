package main.java.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import main.java.MainApp;
import main.java.model.Category;
import main.java.model.Row;
import javafx.fxml.Initializable;

public class Controller implements Initializable {
	
	   @FXML
	    public TitledPane tpLine;

	    @FXML
	    public ComboBox<Row> cbbline;	
	    
	    public  List<Row> rows = new ArrayList<>();  //Criando uma lista de itens do combobox
	   
	    public ObservableList<Row> obsCategorias; //Uma lista observavel de itens 
	 
	    @FXML
	    public TitledPane tpModel;
	    
	    @FXML
	    public TreeView<Object> listaDeModelos;  //objetos de vários tipos
	    
	    public MainApp mainApp;
	    
	    public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;
	    	}	   

		@Override
		public void initialize(URL url, ResourceBundle rb) {
			tpModel.setDisable(true);	 //Inicia com o painel de baixo desabilitado
			
			//Evento que muda a seleção da lista de itens combobox
			cbbline.getSelectionModel().selectedItemProperty().addListener((sender, oldValue, newValue) ->{
				
				//Atualiza a treeView com base a seleção do combobox
				if(newValue == null)
					tpModel.setDisable(true);
				else
				{						
					TreeItem<Object> root = new TreeItem<>(); //root Raiz
					root.setExpanded(true); //expande a raiz
					
					for(Category category : newValue.getCategories()) 
					{
						TreeItem<Object> categoryItem = new TreeItem<>(category); //pega cada item da categoria e adiciona os modelos na treeView
						categoryItem.setExpanded(true);
						for(String model : category.getModels())  
						{
							TreeItem<Object> modelItem = new TreeItem<>(model);
							modelItem.setExpanded(true);
							categoryItem.getChildren().add(modelItem);							
						}
						root.getChildren().add(categoryItem);  //adiciona em cada categoria os filhos do root
					}						
					
					listaDeModelos.setShowRoot(false);  //oculta o root
					listaDeModelos.setRoot(root);
					tpModel.setDisable(false);
					
				}
			});
		}    	
		
		public void setComboboxItems(List<Row> comboBoxItems) {						
			rows = comboBoxItems;				
			obsCategorias = FXCollections.observableArrayList(rows);			
			cbbline.setItems(obsCategorias);				
		}
}

	
	


