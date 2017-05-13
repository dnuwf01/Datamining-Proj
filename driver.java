package weka;

public class driver {

	public static void main(String[] args) throws Exception {
		
		loadData ld = new loadData();
		
		
		/**remove the first attribute from the data */
		ld.remove();
		
		/**creates an output of the decision tree and displays the tree*/
		ld.decision();
		
		/**creates an output of the naiveBayes rule*/
		ld.naiveBayes();
		
		/**creates the output for the knn classifier*/
		ld.knnCl();
		

	}

}
