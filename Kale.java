
public class Kale extends Item{

	public Kale(String renk, int puan) {
		this.renk = renk;
		if(renk == "siyah")
			this.amblem = "k";
		else
			this.amblem = "K";
		this.puan = puan;
	}

	
	public boolean hareketKabiliyeti(int baslangicSatir, int baslangicSutun, int hedefSatir, int hedefSutun, Board board, Player player) {
		
		if( baslangicSutun == hedefSutun || baslangicSatir == hedefSatir )
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
