package Question11A;



public class NewPackageAccessA {
		
		private float float1;
		private float float2;
		//setting the variable to float and providing the private accessor to give access to another package
				
		public NewPackageAccessA(float float1,float float2){		
			this.float1 = float1; 	
			this.float2 = float2;
		}
		//using a constructor to set parameters to the variables	
		public float getFloat1(){		
			return float1;
		}
		public float getFloat2(){	
			return float2;
		}
		//using getters to return the float variables to the other package
}



