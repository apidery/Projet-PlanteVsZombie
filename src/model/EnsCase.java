package model;

public class EnsCase {
	private static boolean tabCases [][] = new boolean[9][6];
	
	public static void setTab(){
		for (int i=0; i<tabCases.length;i++){
			for (int j =0; j<tabCases[i].length;j++){
				tabCases[i][j]=false;
			}
		}
	}
	
	public static boolean getCase (int x, int y){
		return tabCases[x][y];
	}
	
	public static void setCaseTrue (int x, int y){
		tabCases[x][y] = true;
	}
	
	public static void setCaseFalse (int x, int y){
		tabCases[x][y] = false;
	}
	
	public static int tradCase (int x){
		switch(x){
			case 1:
				return 0;
			case 100:
				return 1;
			case 200:
				return 2;
			case 300:
				return 3;
			case 400:
				return 4;
			case 500:
				return 5;
			case 600:
				return 6;
			case 700:
				return 7;
			case 800:
				return 8;
			default:
				return 0;
		}
		
	}
	   public static int getCaseX(double x){
	    	if((x > 0 && x <= 100) || x < 0 || x > 800){
	    		return 1;
	    	}
	    	else if(x > 100 && x <= 200){
	    		return 100;
	    	}
	    	else if(x > 200 && x <= 300){
	    		return 200;
	    	}
	    	else if(x > 300 && x <= 400){
	    		return 300;
	    	}
	    	else if(x > 400 && x <= 500){
	    		return 400;
	    	}
	    	else if(x > 500 && x <= 600){
	    		return 500;
	    	}
	    	else if(x > 600 && x <= 700){
	    		return 600;
	    	}
	    	else if(x > 700 && x <= 800){
	    		return 700;
	     	}
	    	else if(x > 800 && x <= 900){
	    		return 800;
	    	}

	    	return 0;
	    }

	    public static int getCaseY(double y){
	    	if((y > 0 && y <= 100) || y < 0 || y > 600){
	    		return 0;
	    	}

	    	else if (y > 100 && y <= 200){
	    		return 1;
	    	}

	    	else if (y > 200 && y <= 300){
	    		return 2;
	    	}

	    	else if (y > 300 && y <= 400){
	    		return 3;
	    	}

	    	else if (y > 400 && y <= 500){
	    		return 4;
	    	}

	    	else if (y > 500 && y <= 600){
	    		return 5;
	    	}

	    	return 0;
	    }

}
