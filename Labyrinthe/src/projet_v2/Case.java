package projet_v2;

public class Case implements Parametres {

	private int abs ; 
	private int ord ; 
	private String couleur = ""; 

	public Case(int x , int y, String c){
		this.abs = x;
		this.ord = y ;
		this.couleur = c ; 
	}
	public int getAbs(){
		return (this.abs);
	} 

	public int getOrd(){
		return(this.ord);
	}

	public String getCouleur (){
		return (this.couleur);
	}

	public String setCouleur (String c ){
		this.couleur = c ; 
		return (this.couleur); 
	}

	public void setCase(int a, int o, String c){
		this.abs = a;
		this.ord = o;
		this.couleur = c;
	}
	
	public String toString() {
        return getCouleur();
 }
	

}
