
public class Fil extends Item{

	public Fil(String renk, int puan) {
		this.renk = renk;
		if(renk == "siyah")
			this.amblem = "f";
		else
			this.amblem = "F";
		this.puan = puan;
	}

	public boolean hareketKabiliyeti(int baslangicSatir, int baslangicSutun, int hedefSatir, int hedefSutun, Board board, Player player) {	
		if( Math.abs(hedefSatir-baslangicSatir) == Math.abs(hedefSutun-baslangicSutun) )
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
