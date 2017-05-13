/**
 * This class contains the weka algorithms for the class
 * @Debarghya
 * @Carrie
 * @Arup
 * Date 4/28/2017
 * 
 * */





package weka;

// all the imported classes
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

import weka.associations.Apriori;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;

import weka.filters.unsupervised.attribute.Remove;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
import weka.gui.visualize.PlotData2D;
import weka.gui.visualize.ThresholdVisualizePanel;
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Random;


@SuppressWarnings("unused")
public class loadData {

	/**creating all the instance variables */
	
	private DataSource source1;// the object created to read the file
	private DataSource source2; // the object created for he test file ### not used anymore
	private Instances data; // the initial instance of the data
	private Instances data1;// # not used anymore
	private Instances newData; // instance created after deleting the first column
	private Instances newData1; //# not used anymote
	private Remove remove; // an instance of the remove
	private Instances train; // the train instance for the classifiers
	private Instances test; // the test instance for the classifiers
	private Classifier cls; // the classifier for the decision tree
	private Evaluation eval1; // the evaluation instance for the class
	PrintWriter outputStream; // this is used to redirect the output in Remove.txt
	
	
	/**Returns the newData1 instance
	 * @return the new data Instance
	 * */
	public Instances getNewData1() {
		return newData1;
	}

	/**
	 * Sets the newData1 instance
	 * @param the newData1 instance
	 * */

	public void setNewData1(Instances newData1) {
		this.newData1 = newData1;
	}
	
	/**Returns the Data1 instance
	 * @return the  data1 Instance
	 * */
	
	public Instances getData1() {
		return data1;
	}

	/**
	 * Sets the Data1 instance
	 * @param the Data1 instance
	 * */

	public void setData1(Instances data1) {
		this.data1 = data1;
	}
	
	/**Returns the source2 instance
	 * @return the  source2 Instance
	 * */
	
	public DataSource getSource2() {
		return source2;
	}

	/**
	 * Sets the source2 instance
	 * @param the source2 instance
	 * */

	public void setSource2(DataSource source2) {
		this.source2 = source2;
	}
	
	/**Returns the train instance
	 * @return the  train Instance
	 * */
	
	public Instances getTrain() {
		return train;
	}

	/**
	 * Sets the train instance
	 * @param the train instance
	 * */

	public void setTrain(Instances train) {
		this.train = train;
	}

	/**Returns the test instance
	 * @return the  test Instance
	 * */

	public Instances getTest() {
		return test;
	}


	/**
	 * Sets the train instance
	 * @param the train instance
	 * */

	public void setTest(Instances test) {
		this.test = test;
	}

	/**Returns the cls Classifier
	 * @return the  cls Classifier
	 * */
	public Classifier getCls() {
		return cls;
	}


	/**
	 * Sets the cls classifier
	 * @param the cls classifier
	 * */
	public void setCls(Classifier cls) {
		this.cls = cls;
	}


	/**
	 * Returns the eval1 Instance
	 * @return  the eval1 Instance
	 * */
	public Evaluation getEval1() {
		return eval1;
	}


	/**
	 * Sets the eval1 Instance
	 * @param the eval1 Instance
	 * */
	public void setEval1(Evaluation eval1) {
		this.eval1 = eval1;
	}

	
	/**
	 * returns the source1 Instance
	 * @return the source1 Instance
	 * */
	public DataSource getSource1() {
		return source1;
	}


	/**
	 * Sets the source Instance
	 * @param the source Instance
	 * */
	public void setSource(DataSource source) {
		this.source1 = source;
	}


	/**
	 * returns the data Instance
	 * @return the data Instance
	 * */
	public Instances getData() {
		return data;
	}


	/**
	 * sets the data Instance
	 * @param the data Instance
	 * */
	public void setData(Instances data) {
		this.data = data;
	}


	/**
	 * returns the newData Instance
	 * @return the newData Instance
	 * */
	public Instances getNewData() {
		return newData;
	}


	/**
	 * sets the newData Instance
	 * @param the newData Instance
	 * */
	public void setNewData(Instances newData) {
		this.newData = newData;
	}


	/**
	 * returns the Remove Instance
	 * @return the Remove Instance
	 * */
	public Remove getRemove() {
		return remove;
	}


	/**
	 * sets the Remove Instance
	 * @param the Remove Instance
	 * */
	public void setRemove(Remove remove) {
		this.remove = remove;
	}



	/**
	 * The default Constructor for the class
	 * 
	 * */
	
	public loadData() throws Exception
	{
	  source1 = new DataSource("kddcup.csv"); // for the test set
	  source2= new DataSource("kddcup1.csv");
	  outputStream=null;
	  data=source1.getDataSet();
	  if(data.classIndex()==-1)
			data.setClassIndex(data.numAttributes()-1); // sets the last attribute as the class variable
	  data1=source2.getDataSet();
	  if(data1.classIndex()==-1)
			data1.setClassIndex(data1.numAttributes()-1);
	}	
		
		
	/**
	 * Removes the first attribute
	 * 
	 * */
	public void remove() throws Exception{
	
	String[] options1 = weka.core.Utils.splitOptions("-R 1");  
	remove = new Remove();
	remove.setOptions(options1);
	try {
		remove.setInputFormat(getData());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setNewData(Filter.useFilter(getData(),remove));
	
	try {
		remove.setInputFormat(getData1());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setNewData1(Filter.useFilter(getData1(),remove));
	
	// print the output in a text file
	try{
	outputStream = new PrintWriter(new FileOutputStream("Remove.txt"));
	}
	catch(FileNotFoundException e)
	{
		System.out.println("Error in file I/O");
		System.exit(0);
	}
	
	System.out.println(getNewData().toSummaryString());
	System.out.println(getNewData1().toSummaryString());
	outputStream.println(getNewData().toSummaryString());
	outputStream.close();
	}
	
	
	
/**
 * 
 * This method carries out the decision tree
 * The J48 classifer is used to evaluate the decision tree
 *  
 * */	
         
public void decision() throws Exception{
		 
          remove();	 
          Instances train = newData;
       
         
          cls= new J48();
          cls.buildClassifier(newData);
          eval1 = new Evaluation(train);
          Random rand = new Random(1);
          int folds=10;
          eval1.crossValidateModel(cls, newData, folds, rand);
          
          
          
          
          
          System.out.println(eval1.toSummaryString("\nResults  for Decision Tree\n======\n",false));
         
          System.out.println("Area under ROC curve: "+eval1.areaUnderROC(0));
     
          System.out.println(eval1.toMatrixString());
          
          
          
     
          System.out.println("Mean abolute error"+eval1.meanAbsoluteError());
          
          displayTree();
        
}         
         
         
/**
 * This method creates a decision tree and displays it
 * javax.swing is used tto create the decision tree
 * 
 * */       
 public void displayTree() throws Exception{         
          
       final javax.swing.JFrame jf = 
        	       new javax.swing.JFrame("Weka Classifier Tree Visualizer: J48");
        	     jf.setSize(500,400);
        	     jf.getContentPane().setLayout(new BorderLayout());
        	     TreeVisualizer tv = new TreeVisualizer(null,
        	         ((J48) cls).graph(),
        	         new PlaceNode2());
        	     jf.getContentPane().add(tv, BorderLayout.CENTER);
        	     jf.addWindowListener(new java.awt.event.WindowAdapter() {
        	       public void windowClosing(java.awt.event.WindowEvent e) {
        	         jf.dispose();
        	       }
        	     });

        	     jf.setVisible(true);	
        	     tv.fitToScreen();
 }         
         
		
/**
 * This function carries out the naive Bayes algorithm on the data
 * Creates a plot of the ROC curve 
 * 
 * */      
 @SuppressWarnings("static-access")
public void naiveBayes() throws Exception{     
 
	 	remove(); 
	 	Instances train1 = newData;
    //     Instances test1= newData;
         
         
         Classifier cls1= new NaiveBayes();
         cls1.buildClassifier(newData);
         Evaluation eval2= new Evaluation(train1);
    //     eval2.evaluateModel(cls1,test1);
         
         Random rand1 = new Random(1);
         int folds=10;
         eval2.crossValidateModel(cls1, newData, folds, rand1);
         
         
         
         
         System.out.println(eval2.toSummaryString("\n\nResults: NaiveBayes ==========\n",false));
         
         System.out.println("Area under ROC Curve : "+eval2.areaUnderROC(0));
         
         System.out.println(eval2.toMatrixString());
         

         System.out.println("Mean abolute error"+eval2.meanAbsoluteError());
         
         
         
         
    
         ThresholdCurve tc = new ThresholdCurve();
         int classIndex = 0;
         Instances result = tc.getCurve(eval2.predictions(), classIndex);
         // plot curve
         ThresholdVisualizePanel vmc = new ThresholdVisualizePanel();
         vmc.setROCString("(Area under ROC = " +
            Utils.doubleToString(tc.getROCArea(result), 4) + ")");
         vmc.setName(result.relationName());
         PlotData2D tempd = new PlotData2D(result);
         tempd.setPlotName(result.relationName());
         tempd.addInstanceNumberAttribute();
         // specify which points are connected
         boolean[] cp = new boolean[result.numInstances()];
         for (int n = 1; n < cp.length; n++)
            cp[n] = true;
         tempd.setConnectPoints(cp);
         // add plot
         vmc.addPlot(tempd);
         // display curve
         String plotName = vmc.getName();
         final javax.swing.JFrame jf =
         new javax.swing.JFrame("Weka Classifier Visualize: "+plotName);
         jf.setSize(500,400);
         jf.getContentPane().setLayout(new BorderLayout());
         jf.getContentPane().add(vmc, BorderLayout.CENTER);
         jf.addWindowListener(new java.awt.event.WindowAdapter()
         {
            public void windowClosing(java.awt.event.WindowEvent e)
            {
               jf.dispose();
            }
         });
         jf.setVisible(true);
            
         
         
         
         
         
         
         
         
         
}  
       
/**
 * This function carries out the knn Classifier
 * 
 * 
 * */         
 public void knnCl() throws Exception{
	 
	 	 remove();
	 	 Instances train2 = newData;
         Instances test2 = newData;
         
         Classifier cls2= new IBk(3);
         cls2.buildClassifier(newData);
         Evaluation eval3 = new Evaluation(train2);
      //   eval3.evaluateModel(cls2,test2);
         
         Random rand2 = new Random(1);
         int folds=10;
         eval3.crossValidateModel(cls2, newData, folds, rand2);
         
         
      
         System.out.println(eval3.toSummaryString("\n\nResults: KNN classifier =========\n",false));
         System.out.println("Area under ROC Curve : "+eval3.areaUnderROC(0));
         
       
         System.out.println(eval3.toMatrixString());
         
         
         
   
         
         System.out.println("Mean abolute error"+eval3.meanAbsoluteError());
 }         
         
         
         
}